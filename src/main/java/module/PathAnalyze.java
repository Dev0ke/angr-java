package module;

import accessControl.*;

import init.Config;
import init.StaticAPIs;

import com.microsoft.z3.*;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;

import Engine.Expression;
import Engine.SimState;
import Engine.SymbolSolver;
import soot.*;
import soot.dava.internal.javaRep.DIntConstant;
import soot.jimple.*;
import soot.jimple.internal.*;
import soot.jimple.toolkits.ide.icfg.OnTheFlyJimpleBasedICFG;
import soot.tagkit.Tag;
import soot.toolkits.graph.DirectedGraph;
import soot.util.Cons;
import utils.Log;

import java.util.*;
import java.util.concurrent.Flow;

import static accessControl.CheckPermissionAPI.PERMISSION_GRANTED;
import static init.Config.enableInterAnalysis;
import static init.Config.enableLazySolve;
import static utils.Log.printTime;

public class PathAnalyze {
    public SootMethod entryMethod;
    public Context z3Ctx;
    public long startTime;
    public boolean enableSolve;
    public List<List<String>> analyzeResult;

    public PathAnalyze(SootMethod entryMethod) {
        this.startTime = System.currentTimeMillis();
        this.entryMethod = entryMethod;
        this.analyzeResult = new ArrayList<>();
        HashMap<String, String> ctxConfig = new HashMap<String, String>();
        ctxConfig.put("model", "true");
        this.z3Ctx = new Context(ctxConfig);
        this.enableSolve = false;
        // start
        Log.info("[+] Start PathAnalyze in API: " + this.entryMethod.getName());

    }

    public void makeParamsSymbol(SootMethod m, SimState state) {
        //get soot params of soot method
        Log.info(m.toString());
        List<Type> paramTypes = m.getParameterTypes();
        List<Expr> entryParams = new ArrayList<>();
        for(int i = 0; i < paramTypes.size(); i++){
            Type paramType = paramTypes.get(i);
            Expr paramExpr = Expression.makeSymbol(this.z3Ctx,paramType,"TYPE_PARAM" + i);
            entryParams.add(paramExpr);
        }
        state.pushParam(entryParams);

    }


    public Expr valueToExpr(Value operand,SimState state){
        Expr v = null;
        if(operand instanceof Constant constant)
            v = Expression.makeConstantExpr(this.z3Ctx,constant);
        else if(operand instanceof Local)
            v = state.getExpr(operand);
        else if(operand instanceof StaticFieldRef staticRef)
            v = state.getStaticExpr(staticRef);
        else {
            Log.error("Unsupported value type: " + operand.getClass());
        }
        return v;
    }

    public void updateValue(Value v, Expr e, SimState state){
        if(v instanceof Local)
            state.addExpr(v, e);
        else if(v instanceof StaticFieldRef staticRef)
            state.addStaticField(staticRef, e);
        else
            Log.error("[-] Unsupported value type: " + v.getClass());
    }

    public SimState handleInitMethod() {
        SimState initState = new SimState();
        SootClass sc = this.entryMethod.getDeclaringClass();
        // has <clinit>?
        SootMethod clinitMethod = sc.getMethodByNameUnsafe("<clinit>");
        if (clinitMethod != null) {
            return analyzeMethod(clinitMethod, initState);
        }
        return initState;
    }

    public Expr makePermissionSymbol(String permissionValue) {
        return this.z3Ctx.mkBVConst(permissionValue, 32);
    }

    public void startAnalyze() {
        // g.displayGraph();
        SimState initState = handleInitMethod();
        this.enableSolve = true;

        //symbolize params
        makeParamsSymbol(this.entryMethod, initState);
        return;
        // analyzeMethod(this.entryMethod, initState);
        // printTime("[+] PathAnalyze Finished! ", this.startTime);

    }

    public SimState analyzeMethod(SootMethod m, SimState state) {
        Log.info("[+] Analyzing method: " + m.getName());
        DirectedGraph<Unit> cfg = new OnTheFlyJimpleBasedICFG(m).getOrCreateUnitGraph(m);
        Unit entryPoint = cfg.getHeads().get(0);
        return doOne(entryPoint, state, cfg, false);
    }

    private List<Unit> getNextUnit(Unit unit, DirectedGraph<Unit> cfg) {
        // 获取 unit 的所有后继节点
        return cfg.getSuccsOf(unit);
    }
    public Expr handleCastExpr(Context z3Ctx,JCastExpr castExpr, SimState state){
        Expr src = valueToExpr(castExpr.getOp(),state);
        Type type = castExpr.getType();
        return Expression.makeCastExpr(z3Ctx,type,src);
    }
    // handle data flow for one unit
    public Expr handleCalculate(Value expr, SimState state) {
        if(expr instanceof BinopExpr binopExpr){
            Expr left = valueToExpr(binopExpr.getOp1(),state);
            Expr right = valueToExpr(binopExpr.getOp2(),state);
            return Expression.makeBinOpExpr(this.z3Ctx,binopExpr,left,right);
        }
        else if(expr instanceof UnopExpr unopExpr){
            Expr src = valueToExpr(unopExpr.getOp(),state);
            return Expression.makeUnOpExpr(this.z3Ctx,unopExpr,src);
        }
        else{
            Log.error("Unsupported expression type: " + expr.getClass());
        }
        return null;
    }

    public SimState doOne(Unit curUnit, SimState state, DirectedGraph<Unit> cfg, Boolean isFromReturn) {
        // handle return
        if (isFromReturn) {
            List<Unit> units = getNextUnit(curUnit, cfg);
            for (Unit u : units) {
                doOne(u, state, cfg, false);
            }
            return state;
        }

        while (curUnit != null) {
            Log.info(curUnit.toString());
            
            if (curUnit instanceof JIfStmt ifStmt) {
                Value condition = ifStmt.getCondition();
                Expr result = handleCalculate(condition, state);
                // copy current state
                SimState branchState = state.copy();
                Unit target = ifStmt.getTarget();
                if (result != null) {
                    // condition is true
                    Log.info("|- IfStmt 1, condition TRUE: " + condition);
                    branchState.addConstraint(result);
                    if (branchState.addInstCount(curUnit) <= Config.branchLimit
                            && (enableLazySolve || SymbolSolver.solveConstraintsSingle(this.z3Ctx,branchState.constraints))) {
                        doOne(target, branchState, cfg, false);

                    } else
                        Log.info("[-] unsat branch");

                    // condition is false
                    Log.info("|- IfStmt 2, condition FALSE: !" + condition);
                    state.addConstraint(this.z3Ctx.mkNot(result));
                    if (state.addInstCount(curUnit) <= Config.branchLimit + 1
                            && (enableLazySolve || SymbolSolver.solveConstraintsSingle(this.z3Ctx,state.constraints))) {
                        doOne(getNextUnit(curUnit, cfg).get(0), state, cfg, false);
                    } else {
                        Log.info("[-] unsat branch");
                    }
                    return state;
                } else {
                    if (branchState.addInstCount(curUnit) <= Config.branchLimit) {
                        Log.info("|- IfStmt 1, condition TRUE: " + condition);
                        doOne(target, branchState, cfg, false);

                    }
                    if (state.addInstCount(curUnit) <= Config.branchLimit + 1) {
                        Log.info("|- IfStmt 2, condition FALSE: !" + condition);
                        doOne(getNextUnit(curUnit, cfg).get(0), state, cfg, false);

                    }
                    return state;

                }

            } else if (curUnit instanceof JAssignStmt assignStmt) {

                Value left = assignStmt.getLeftOp();
                Value right = assignStmt.getRightOp();
                Expr v = null;
                if (right instanceof Local) {
                    v = state.getExpr(right);
                } else if (right instanceof Constant constant) {
                    v = Expression.makeConstantExpr(this.z3Ctx, constant);
                } else if (right instanceof StaticFieldRef staticRef) {
                    v = state.getStaticExpr(staticRef);
                } else if (right instanceof BinopExpr binop) {
                    v = handleCalculate(binop, state);
                } else if (right instanceof UnopExpr unop) {
                    v = handleCalculate(unop, state);
                } else if (right instanceof JCastExpr cast) {
                    v = handleCastExpr(this.z3Ctx,cast, state);
                } else if (right instanceof JNewExpr newExpr) {
                    if (newExpr.getBaseType().toString().equals("java.lang.SecurityException")) {
                        Log.info("[-] SecurityException branch. Terminate.");
                        return state;
                    } else {
                        Log.error("[-] Unsupported right type: " + right.getClass());
                    }
                } else if (right instanceof InvokeExpr invoke) {
                    state.pushCall(curUnit);
                    state.pushCFG(cfg);
                    SimState rtnValue = handleInvoke(invoke, state);
                    return state;
                    // TODO ADD INSTANCE FIELD REF
                } else {
                    Log.error("Unsupported right type: " + right.getClass());
                }
                // TODO ADD FIELD ref
                if (left instanceof JInstanceFieldRef) {
                    // TODO
                } else if (left instanceof StaticFieldRef staticRef) {
                    if (v != null)
                        state.addStaticField(staticRef, v);
                } else if (left instanceof Local l) {
                    if (v != null)
                        state.addExpr(l, v);
                }

            } else if (curUnit instanceof JLookupSwitchStmt switchStmt) {
                Value key = switchStmt.getKey();
                Expr exp = state.getExpr(key);

                // handle switch case
                List<IntConstant> caseValues = switchStmt.getLookupValues();
                for (IntConstant ii : caseValues) {
                    Unit target = switchStmt.getTargetForValue(ii.value);
                    Expr v = z3Ctx.mkBV(ii.value, 32);
                    SimState branchState = state.copy();

                    if (exp != null) {
                        branchState.addConstraint(z3Ctx.mkEq(exp, v));
                        if (enableLazySolve || SymbolSolver.solveConstraintsSingle(this.z3Ctx,state.constraints)) {
                            doOne(target, branchState, cfg, false);
                        }
                    } else
                        doOne(target, branchState, cfg, false);
                }

                // handle default case
                Unit defaultTarget = switchStmt.getDefaultTarget();
                SimState branchState = state.copy();
                if (exp != null) {
                    branchState.addConstraint(z3Ctx.mkNot(z3Ctx.mkOr(caseValues.stream()
                            .map(ii -> z3Ctx.mkEq(exp, z3Ctx.mkBV(ii.value, 32))).toArray(Expr[]::new))));
                    if (enableLazySolve || SymbolSolver.solveConstraintsSingle(this.z3Ctx,state.constraints)) {
                        doOne(defaultTarget, branchState, cfg, false);
                    }
                } else
                    doOne(defaultTarget, branchState, cfg, false);
                return state;

            } else if (curUnit instanceof InvokeStmt invokeStmt) {
                state.pushCall(curUnit);
                state.pushCFG(cfg);
                handleInvoke(invokeStmt, state);
                return state;

            } else if (curUnit instanceof JThrowStmt) {
                // TODO TRY CATCH
                // Log.error("[-] Unsupported ThrowStmt: " + curUnit);
                return state;
          } else if (curUnit instanceof JEnterMonitorStmt) {
            } else if (curUnit instanceof JExitMonitorStmt) {
            } else if (curUnit instanceof JReturnStmt) {
                if (state.isCallStackEmpty()) {
                    if (enableSolve)// Entry method
                        this.printSimplifyConstaints(state.constraints);
                } else { // callee method
                    Unit ret = state.popCall();
                    if (ret instanceof AssignStmt assign) {
                        Value left = assign.getLeftOp();
                        Value retValue = ((ReturnStmt) curUnit).getOp();
                        Expr retExpr = valueToExpr(retValue,state);
                        state.popLocalMap();
                        if (retExpr != null) {
                            updateValue(left, retExpr, state);
                        }
                        state.popParam();
                        
                    } else {
                        Log.error("[-] Unsupported Ret Unit type: " + ret.getClass());
                    }
                    doOne(ret, state, state.popCFG(), true);
                }
                return state;

            } else if (curUnit instanceof JReturnVoidStmt ) {
                if (state.isCallStackEmpty()) {
                    if (enableSolve)// Entry method
                        this.printSimplifyConstaints(state.constraints);
                } else { // callee method
                    Unit ret = state.popCall();
                    state.popLocalMap();
                    state.popParam();
                    doOne(ret, state, state.popCFG(), true);
                }
                return state;

            } else if (curUnit instanceof JIdentityStmt) {
                Value right = ((IdentityStmt) curUnit).getRightOp();
                Value left = ((IdentityStmt) curUnit).getLeftOp();
                if (right instanceof ParameterRef p) {
                    int paramIndex = p.getIndex();
                    Expr param = state.getParam(paramIndex);
                    if (param != null) {
                        updateValue(left, param, state);
                    }

                } else {
                    Log.error("|- [-] Unsupported right type: " + right.getClass());
                }
            } else if (curUnit instanceof JGotoStmt) {
                ;
            } else {
                Log.error("Unhandle Unit: " + curUnit + curUnit.getClass());
            }
            // end handle ,get next unit
            if (curUnit instanceof JGotoStmt gotoStmt) {
                curUnit = gotoStmt.getTarget();

            } else {
                List<Unit> nextUnits = getNextUnit(curUnit, cfg);
                for (Unit u : nextUnits) {
                    if (u instanceof JIdentityStmt id) {
                        Value right = id.getRightOp();
                        // ignore the exception
                        // TODO FIX
                        if (right instanceof JCaughtExceptionRef)
                            continue;
                    }
                    doOne(u, state, cfg, false);
                }
                return state;
            }
        }
        return state;
    }

    // TODO add uid limit
    public Expr handleUidAPI(InvokeExpr expr, SimState state) {
        List<Value> args = expr.getArgs();
        String methodName = expr.getMethod().getName();
        if (methodName.equals("getCallingUid")) {
            String symbolName = "TYPE_UID#CallingUid";
            Expr uidExpr = state.getSymbolByName(symbolName);
            if (uidExpr == null) {
                uidExpr = z3Ctx.mkBVConst(symbolName, 32);
                state.addSymbol(uidExpr);
            }
            return uidExpr;
        }
        return null;
    }

    // TODO add uid limit
    public Expr handlePidAPI(InvokeExpr expr, SimState state) {
        List<Value> args = expr.getArgs();
        String methodName = expr.getMethod().getName();
        if (methodName.equals("getCallingPid")) {
            String symbolName = "TYPE_PID#CallingPid";
            Expr pidExpr = state.getSymbolByName(symbolName);
            if (pidExpr == null) {
                pidExpr = z3Ctx.mkBVConst(symbolName, 32);
                state.addSymbol(pidExpr);
            }
            return pidExpr;
        }
        return null;
    }

    public Expr handleMyPidAPI(InvokeExpr expr, SimState state) {
        String symbolName = "TYPE_PID#MY_PID";
        Expr pidExpr = state.getSymbolByName(symbolName);
        if (pidExpr == null) {
            pidExpr = z3Ctx.mkBVConst(symbolName, 32);
            state.addSymbol(pidExpr);
        }
        return pidExpr;

    }

    public Expr handleAppOpAPI(InvokeExpr expr, SimState state) {
        List<Value> args = expr.getArgs();
        String methodName = expr.getMethod().getName();
        if (CheckAppOpAPI.getAllMethodNameByClassName("android.app.AppOpsManager").contains(methodName)
                || methodName.equals("noteOp") || methodName.equals("checkOp")) {
            // get APPOP STR
            String appOPSTR;
            if (args.get(0) instanceof StringConstant)
                appOPSTR = ((StringConstant) args.get(0)).value;
            // TODO FIX APPOP 2 OPSTR
            else if (args.get(0) instanceof IntConstant)
                appOPSTR = String.valueOf(((IntConstant) args.get(0)).value);
            else if (args.get(0) instanceof Local) {
                Value permission = args.get(0);
                Expr permissionExpr = state.getExpr(permission);
                appOPSTR = permissionExpr.toString();
            } else {
                Log.error("[-] Unsupported APPOP type: " + args.get(0).getClass());
                return null;
            }
            String symbolName = "TYPE_AppOp#" + appOPSTR;

            // create or get Expr
            Expr AppOpExpr = state.getSymbolByName(symbolName);
            if (AppOpExpr == null) {
                AppOpExpr = z3Ctx.mkBVConst(symbolName, 32);
                state.addSymbol(AppOpExpr);
            }

            // add Constraint for possible results
            List<Expr> possbileValueConstraints = new ArrayList<>();
            for (int i : CheckAppOpAPI.POSSIBLE_APPOP_CHECK_RESULTS) {
                possbileValueConstraints.add(z3Ctx.mkEq(AppOpExpr, z3Ctx.mkBV(i, 32)));
            }
            state.addConstraint(z3Ctx.mkEq(z3Ctx.mkOr(possbileValueConstraints.toArray(new Expr[0])), z3Ctx.mkTrue()));
            return AppOpExpr;
        }
        return null;
    }

    public Expr handlePermissionAPI(InvokeExpr expr, SimState state) {
        List<Value> args = expr.getArgs();
        String methodName = expr.getMethod().getName();
        if (methodName.startsWith("enforce")) {
            String permissionValue;
            if (args.get(0) instanceof StringConstant strConstant) {
                // add permission symbol
                permissionValue = strConstant.value;
            } else if (args.get(0) instanceof Local) {
                Value permission = args.get(0);
                Expr permissionExpr = state.getExpr(permission);
                permissionValue = permissionExpr.getString();
            } else {
                Log.error("[-] Unsupported permission type: " + args.get(0).getClass());
                return null;
            }

            // create or get Expr
            String permissionSymbolName = "TYPE_PERMISSION#" + permissionValue;
            Expr permissionExpr = state.getSymbolByName(permissionSymbolName);
            if (permissionExpr == null) {
                permissionExpr = makePermissionSymbol(permissionSymbolName);
                state.addSymbol(permissionExpr);
            }
            Expr enforceExpr = z3Ctx.mkEq(permissionExpr, z3Ctx.mkBV(PERMISSION_GRANTED, 32));
            state.addConstraint(enforceExpr);
            return enforceExpr;

        } else if (methodName.startsWith("check")) {
            String permissionValue;
            if (args.get(0) instanceof StringConstant) {
                // add permission symbol
                permissionValue = ((StringConstant) args.get(0)).value;
            } else if (args.get(0) instanceof Local) {
                Value permission = args.get(0);
                Expr permissionExpr = state.getExpr(permission);
                permissionValue = permissionExpr.getString();
            } else {
                Log.error("[-] Unsupported permission type: " + args.get(0).getClass());
                return null;
            }

            // create or get Expr
            String permissionSymbolName = "TYPE_PERMISSION#" + permissionValue;
            Expr permissionExpr = state.getSymbolByName(permissionSymbolName);
            if (permissionExpr == null) {
                permissionExpr = makePermissionSymbol(permissionSymbolName);
                state.addSymbol(permissionExpr);
            }

            // add Constraint for possible results
            List<Expr> possbileValueConstraints = new ArrayList<>();
            for (int i : CheckPermissionAPI.POSSIBLE_PERMISSIONS_CHECK_RESULTS_OLD) {
                possbileValueConstraints.add(z3Ctx.mkEq(permissionExpr, z3Ctx.mkBV(i, 32)));
            }
            state.addConstraint(z3Ctx.mkEq(z3Ctx.mkOr(possbileValueConstraints.toArray(new Expr[0])), z3Ctx.mkTrue()));
            return permissionExpr;
        }
        return null;
    }

    public SimState handleInvoke(InvokeStmt stmt, SimState state) {
        return handleInvoke(stmt.getInvokeExpr(), state);
    }

    public SimState handleInvoke(InvokeExpr expr, SimState state) {
        SootMethod callee = expr.getMethod();
        String methodName = callee.getName();
        String className = callee.getDeclaringClass().getName();

        if (CheckPermissionAPI.allClassNames.contains(className)) {
            Log.warn("[+] Find Permission API: " + className + "." + methodName);
            Expr e = handlePermissionAPI(expr, state);
            if (e != null) {
                Unit ret = state.popCall();
                if (ret instanceof AssignStmt assign) {
                    Value left = assign.getLeftOp();
                    updateValue(left, e, state);
                } else {
                    Log.error("[-] Unsupported Ret Unit type: " + ret.getClass());
                }

                doOne(ret, state, state.popCFG(), true);
                return null;
            }

        } else if (CheckUidAPI.allClassNames.contains(className) && methodName.equals("getCallingUid")) {
            Log.warn("[+] Find UID API: " + className + "." + methodName);
            Expr e = handleUidAPI(expr, state);
            if (e != null) {
                Unit ret = state.popCall();
                if (ret instanceof AssignStmt assign) {
                    Value left = assign.getLeftOp();
                    updateValue(left, e, state);
                } else {
                    Log.error("[-] Unsupported Ret Unit type:  " + ret.getClass());
                }
                doOne(ret, state, state.popCFG(), true);
                return null;
            }
        } else if (CheckPidAPI.allClassNames.contains(className) && methodName.equals("getCallingPid")) {
            Log.warn("[+] Find PID API: " + className + "." + methodName);
            Expr e = handlePidAPI(expr, state);
            if (e != null) {
                Unit ret = state.popCall();
                if (ret instanceof AssignStmt assign) {
                    Value left = assign.getLeftOp();
                    updateValue(left, e, state);
                } else {
                    Log.error("[-] Unsupported Ret Unit type: " + ret.getClass());
                }
                doOne(ret, state, state.popCFG(), true);
                return null;
            }
        } else if (CheckAppOpAPI.getAllClassName().contains(className)) {
            Log.warn("[+] Find AppOp API: " + className + "." + methodName);
            Expr e = handleAppOpAPI(expr, state);
            if (e != null) {
                Unit ret = state.popCall();
                if (ret instanceof AssignStmt assign) {
                    Value left = assign.getLeftOp();
                    updateValue(left, e, state);
                } else {
                    Log.error("[-] Unsupported Ret Unit type:  " + ret.getClass());
                }
                doOne(ret, state, state.popCFG(), true);
                return null;
            }
        }

        else if (className.equals("java.lang.Exception")) {
            Log.info("[-] Exception invoke. Terminate. ");
            return null;
        } else if (className.equals("android.os.Process") && methodName.equals("myPid")) {
            Expr e = handleMyPidAPI(expr, state);
            if (e != null) {
                Unit ret = state.popCall();
                if (ret instanceof AssignStmt assign) {
                    Value left = assign.getLeftOp();
                    updateValue(left, e, state);
                } else {
                    Log.error("[-] Unsupported Ret Unit type:  " + ret.getClass());
                }
                doOne(ret, state, state.popCFG(), true);
                return null;
            }
        }
        // TOFIX TEMP PATCH
        Log.info("[+] Analyzing method: " + callee.getName());
        OnTheFlyJimpleBasedICFG cfg = new OnTheFlyJimpleBasedICFG(callee);
        Boolean hasActiveBody = callee.hasActiveBody();

        // handle normal case
        if ((entryMethod.getDeclaringClass().getName().contains(className) || StaticAPIs.ANALYZE_CLASS_SET.contains(methodName) || enableInterAnalysis) && hasActiveBody) {
            preInvoke(expr, state);
            analyzeMethod(callee, state);
            
        } else {
            Unit ret = state.popCall();
            doOne(ret, state, state.popCFG(), true);
        }
        return state;
    }

    // pass the parameters to the callee
    public void preInvoke(InvokeExpr expr, SimState state) {

        // handle param
        List<Value> args = expr.getArgs();
        List<Expr> params = new ArrayList<>();
        for (int i = 0; i < args.size(); i++) {
            Value arg = args.get(i);
            Expr e = valueToExpr(arg, state);
            params.add(e);
        }
        state.pushParam(params);
        
        //handle localmap
        state.pushLocalMap();
    }

    // ============================================================================================
    public void printSimplifyConstaints(List<Expr> constraints) {
        Log.info("================== [Solve] ========================");
        Solver s = this.z3Ctx.mkSolver();
        List<Expr> idExpr = new ArrayList<>();
        for (Expr c : constraints) {
            if (AccessControlUtils.isAccessControlExpr(c)) {
                if (AccessControlUtils.isUIDExpr(c) || AccessControlUtils.isPIDExpr(c)) {
                    idExpr.add(c);
                } else {
                    s.add(c);
                }
            }
        }

        // list all symbol and remove which is not constaint

        while (s.check() == com.microsoft.z3.Status.SATISFIABLE) {

            Model model = s.getModel();
            Map<Expr, Expr> currentSolution = new HashMap<>();
            List<String> r = new ArrayList<>();
            // 获取并输出符号的解
            for (FuncDecl<?> decl : model.getConstDecls()) {
                String symbolName = decl.getName().toString();
                Expr<?> value = model.getConstInterp(decl);

                // put and print

                String result = symbolName + " = " + value;
                Log.info(result);
                r.add(result);

                currentSolution.put(this.z3Ctx.mkConst(decl), value);
            }

            for (Expr e : idExpr) {
                Log.info(e.toString());
                r.add(e.toString());
            }
            analyzeResult.add(r);

            // 添加约束以避免找到相同的解
            List<BoolExpr> blockingClause = new ArrayList<>();
            for (Map.Entry<Expr, Expr> entry : currentSolution.entrySet()) {
                blockingClause.add(this.z3Ctx.mkNot(this.z3Ctx.mkEq(entry.getKey(),
                        entry.getValue())));
            }
            s.add(this.z3Ctx.mkOr(blockingClause.toArray(new BoolExpr[0])));
            Log.info("----------------------------------------\n");
        }

        Log.info("===================================================");
        return;
    }

    public Set<List<String>> getAnalyzeResult() {
        Set<List<String>> uniqueLists = new LinkedHashSet<>();
        // 遍历原始列表，将其加入 Set 中
        for (List<String> sublist : this.analyzeResult) {
            uniqueLists.add(new ArrayList<>(sublist));
        }
        // 清空原始列表并重新赋值
        return uniqueLists;
    }


}