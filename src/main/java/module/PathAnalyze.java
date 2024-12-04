package module;

import accessControl.CheckAppOpAPI;
import accessControl.CheckPidAPI;
import accessControl.CheckUidAPI;
import init.Config;
import accessControl.CheckPermissionAPI;
import com.microsoft.z3.*;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import soot.*;
import soot.jimple.*;
import soot.jimple.internal.*;
import soot.jimple.toolkits.ide.icfg.OnTheFlyJimpleBasedICFG;
import soot.toolkits.graph.DirectedGraph;
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
    public List<List<String>> result;

    public PathAnalyze(SootMethod entryMethod) {
        this.startTime = System.currentTimeMillis();
        this.entryMethod = entryMethod;
        this.result = new ArrayList<>();
        HashMap<String, String> ctxConfig = new HashMap<String, String>();
        ctxConfig.put("model", "true");
        this.z3Ctx = new Context(ctxConfig);
        this.enableSolve = false;
        // start
        Log.info("[+] Start PathAnalyze in API: " + this.entryMethod.getName());

    }

    public FlowState handleInitMethod() {
        FlowState initState = new FlowState();
        SootClass sc = this.entryMethod.getDeclaringClass();
        // has <clinit>?
        SootMethod clinitMethod = sc.getMethodByNameUnsafe("<clinit>");
        if (clinitMethod != null) {
            return analyzeMethod(clinitMethod, initState);
        }
        return initState;
    }

    public IntExpr makePermissionSymbol(String permissionValue) {
        return this.z3Ctx.mkIntConst(permissionValue);
    }

    public void startAnalyze() {
        // g.displayGraph();
        FlowState initState = handleInitMethod();
        this.enableSolve = true;
        analyzeMethod(this.entryMethod, initState);
        printTime("[+] PathAnalyze Finished! ", this.startTime);

    }

    public FlowState analyzeMethod(SootMethod m, FlowState state) {
        Log.info("[+] Analyzing method: " + m.getName());
        DirectedGraph<Unit> cfg = new OnTheFlyJimpleBasedICFG(m).getOrCreateUnitGraph(m);
        Unit entryPoint = cfg.getHeads().get(0);
        return doOne(entryPoint, state, cfg, false);
    }

    private List<Unit> getNextUnit(Unit unit, DirectedGraph<Unit> cfg) {
        // 获取 unit 的所有后继节点
        return cfg.getSuccsOf(unit);
    }

    // handle data flow for one unit
    public Expr handleCalculate(Value jimpleExpr, FlowState state) {
        Expr rtn = null;
        if (jimpleExpr instanceof BinopExpr binop) {
            Value leftOperand = binop.getOp1();
            Value rightOperand = binop.getOp2();
            Expr leftExpr = null;
            Expr rightExpr = null;

            if (leftOperand instanceof IntConstant)
                leftExpr = this.z3Ctx.mkInt(((IntConstant) leftOperand).value);
            else if (leftOperand instanceof Local)
                leftExpr = state.getExpr(leftOperand);
            if (rightOperand instanceof IntConstant)
                rightExpr = this.z3Ctx.mkInt(((IntConstant) rightOperand).value);
            else if (rightOperand instanceof Local)
                rightExpr = state.getExpr(rightOperand);

            if (rightExpr == null || leftExpr == null)
                return null;

            // ConditionExpr
            if (jimpleExpr instanceof EqExpr) {
                rtn = this.z3Ctx.mkEq(leftExpr, rightExpr);
            } else if (jimpleExpr instanceof NeExpr) {
                rtn = this.z3Ctx.mkNot(this.z3Ctx.mkEq(leftExpr, rightExpr));
            } else if (jimpleExpr instanceof GeExpr) {
                rtn = this.z3Ctx.mkGe(leftExpr, rightExpr);
            } else if (jimpleExpr instanceof GtExpr) {
                rtn = this.z3Ctx.mkGt(leftExpr, rightExpr);
            } else if (jimpleExpr instanceof LeExpr) {
                rtn = this.z3Ctx.mkLe(leftExpr, rightExpr);
            } else if (jimpleExpr instanceof LtExpr) {
                rtn = this.z3Ctx.mkLt(leftExpr, rightExpr);
            }

            // bit
            else if (jimpleExpr instanceof AndExpr) {
                rtn = this.z3Ctx.mkAnd((BoolExpr) leftExpr, (BoolExpr) rightExpr);
            } else if (jimpleExpr instanceof OrExpr) {
                rtn = this.z3Ctx.mkOr((BoolExpr) leftExpr, (BoolExpr) rightExpr);
            } else if (jimpleExpr instanceof XorExpr) {
                rtn = this.z3Ctx.mkXor((BoolExpr) leftExpr, (BoolExpr) rightExpr);
            } else if (jimpleExpr instanceof ShlExpr) {
                rtn = this.z3Ctx.mkBVSHL((BitVecExpr) leftExpr, (BitVecExpr) rightExpr);
            } else if (jimpleExpr instanceof ShrExpr) {
                rtn = this.z3Ctx.mkBVASHR((BitVecExpr) leftExpr, (BitVecExpr) rightExpr);
            } else if (jimpleExpr instanceof UshrExpr) {
                rtn = this.z3Ctx.mkBVLSHR((BitVecExpr) leftExpr, (BitVecExpr) rightExpr);
            }

            // base
            else if (jimpleExpr instanceof AddExpr) {
                rtn = this.z3Ctx.mkAdd(leftExpr, rightExpr);
            } else if (jimpleExpr instanceof SubExpr) {
                rtn = this.z3Ctx.mkSub(leftExpr, rightExpr);
            } else if (jimpleExpr instanceof MulExpr) {
                rtn = this.z3Ctx.mkMul(leftExpr, rightExpr);
            } else if (jimpleExpr instanceof DivExpr) {
                rtn = this.z3Ctx.mkDiv(leftExpr, rightExpr);
            } else if (jimpleExpr instanceof RemExpr) {
                rtn = this.z3Ctx.mkRem((IntExpr) leftExpr, (IntExpr) rightExpr);
            }

            // CMPExpr
            // TODO is it right?
            else if (jimpleExpr instanceof CmpExpr) {
                rtn = this.z3Ctx.mkEq(leftExpr, rightExpr);
            } else if (jimpleExpr instanceof CmpgExpr) {
                rtn = this.z3Ctx.mkGe(leftExpr, rightExpr);
            }

        } else if (jimpleExpr instanceof UnopExpr) {

            UnopExpr unop = (UnopExpr) jimpleExpr;
            Value operand = unop.getOp();
            Expr operandExpr = null;

            if (operand instanceof Local) {
                operandExpr = state.getExpr(operand);
            } else if (operand instanceof IntConstant) {
                operandExpr = this.z3Ctx.mkInt(((IntConstant) operand).value);
            }

            if (unop instanceof NegExpr) {
                rtn = this.z3Ctx.mkNot((BoolExpr) operandExpr);
            } else if (unop instanceof LengthExpr) {
                // TODO
                Log.error("Unsupported expression type: " + jimpleExpr.getClass());

            }
        } else {
            Log.error("Unsupported expression type: " + jimpleExpr.getClass());

        }
        return rtn;
    }

    public FlowState doOne(Unit curUnit, FlowState state, DirectedGraph<Unit> cfg, Boolean isFromReturn) {
        // handle return
        if (isFromReturn) {
            List<Unit> units = getNextUnit(curUnit, cfg);
            for (Unit u : units) {
                doOne(u, state, cfg, false);
            }
            return null;
        }

        while (curUnit != null) {
            Log.info(curUnit.toString());
            if (curUnit instanceof JIfStmt ifStmt) {
                Value condition = ifStmt.getCondition();
                Expr result = handleCalculate(condition, state);
                // copy current state
                FlowState branchState = state.copy();
                Unit target = ifStmt.getTarget();
                if (result != null) {
                    // sat branch
                    Log.debug("|- IfStmt 1, condition: " + condition);
                    branchState.addConstraint(result);
                    if (state.addInstCount(curUnit) <= Config.branchLimit
                            && (enableLazySolve || solveConstraintsSingle(branchState.constraints))) 
                        doOne(target, branchState, cfg, false);
                    else
                        Log.info("[-] unsat branch");

                    // Unsat branch
                    Log.info("|- IfStmt 2, condition: !" + condition);
                    state.addConstraint(this.z3Ctx.mkNot(result));
                    if (state.addInstCount(curUnit) <= Config.branchLimit + 1
                            && (enableLazySolve || solveConstraintsSingle(branchState.constraints))) 
                        doOne(getNextUnit(curUnit, cfg).get(0), state, cfg, false);
                    else
                        Log.info("[-] unsat branch");
                    return null;
                } else {
                    if (state.addInstCount(curUnit) <= Config.branchLimit) {
                        Log.info("|- IfStmt 1, condition: " + condition);
                        doOne(target, branchState, cfg, false);
                    }
                    if (state.addInstCount(curUnit) <= Config.branchLimit + 1) {
                        Log.info("|- IfStmt 2, unsat condition: !" + condition);
                        doOne(getNextUnit(curUnit, cfg).get(0), state, cfg, false);
                    }
                    return null;
                }

            } else if (curUnit instanceof JAssignStmt assignStmt) {

                Value left = assignStmt.getLeftOp();
                // TODO ADD FIELD ref
                if (left instanceof JInstanceFieldRef)
                    return null;

                Value right = assignStmt.getRightOp();

                if (right instanceof Local) {
                    Expr v = state.getExpr(right);
                    if (v != null)
                        state.addExpr(left, v);
                } else if (right instanceof IntConstant intConst) {
                    Expr v = z3Ctx.mkInt(intConst.value);
                    state.addExpr(left, v);
                } else if (right instanceof StringConstant strConst) {
                    Expr v = z3Ctx.mkString(strConst.value);
                    state.addExpr(left, v);
                } else if (right instanceof InvokeExpr invoke) {
                    state.pushCall(curUnit);
                    state.pushCFG(cfg);
                    FlowState rtnValue = handleInvoke(invoke, state);
                    return null;
                    // TODO ADD INSTANCE FIELD REF
                } else if (right instanceof JNewExpr newExpr) {
                    if (newExpr.getBaseType().toString().equals("java.lang.SecurityException")) {
                        Log.info("[-] SecurityException branch. Terminate.");
                        return null;
                    } else {
                        Log.error("[-] Unsupported right type: " + right.getClass());
                    }
                } else if(right instanceof BinopExpr binop){
                    Expr v = handleCalculate(binop, state);
                    if (v != null)
                        state.addExpr(left, v);
                } else if(right instanceof UnopExpr unop){
                    Expr v = handleCalculate(unop, state);
                    if (v != null)
                        state.addExpr(left, v);
                }else {
                    Log.error("Unsupported right type: " + right.getClass());
                }

            } else if (curUnit instanceof JLookupSwitchStmt switchStmt) {
                Value key = switchStmt.getKey();
                Expr exp = state.getExpr(key);

                // handle switch case
                List<IntConstant> caseValues = switchStmt.getLookupValues();
                for (IntConstant ii : caseValues) {
                    Unit target = switchStmt.getTargetForValue(ii.value);
                    Expr v = z3Ctx.mkInt(ii.value);
                    FlowState branchState = state.copy();

                    if (exp != null) {
                        branchState.addConstraint(z3Ctx.mkEq(exp, v));
                        if (enableLazySolve || solveConstraintsSingle(state.constraints)) {
                            doOne(target, branchState, cfg, false);
                        }
                    } else
                        doOne(target, branchState, cfg, false);
                }

                // handle default case
                Unit defaultTarget = switchStmt.getDefaultTarget();
                FlowState branchState = state.copy();
                if (exp != null) {
                    branchState.addConstraint(z3Ctx.mkNot(z3Ctx.mkOr(caseValues.stream()
                            .map(ii -> z3Ctx.mkEq(exp, z3Ctx.mkInt(ii.value))).toArray(Expr[]::new))));
                    if (enableLazySolve || solveConstraintsSingle(state.constraints)) {
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
                return null;
            } else if (curUnit instanceof JEnterMonitorStmt) {
            } else if (curUnit instanceof JExitMonitorStmt) {
            } else if (curUnit instanceof JReturnStmt) {
                if (state.isCallStackEmpty()) {
                    if (enableSolve)// Entry method
                        // TODO FIX
                        // if(entryMethod.getReturnType().toString().equals("boolean")){
                        // Value retValue = ((ReturnStmt)curUnit).getOp();
                        // if(retValue instanceof IntConstant intConst){
                        // if(intConst.value == 0)
                        // return null;
                        // }
                        // }
                        this.printSimplifyConstaints(state.constraints);
                } else { // callee method
                    Unit ret = state.popCall();
                    if (ret instanceof AssignStmt assign) {
                        Value left = assign.getLeftOp();
                        Value retValue = ((ReturnStmt) curUnit).getOp();
                        Expr retExpr = null;
                        if (retValue instanceof IntConstant) {
                            retExpr = z3Ctx.mkInt(((IntConstant) retValue).value);
                        } else if (retValue instanceof Local) {
                            retExpr = state.getExpr(retValue);
                        } else if (retValue instanceof StringConstant) {
                            retExpr = z3Ctx.mkString(((StringConstant) retValue).value);
                        } else {
                            Log.error("[-] Unsupported Ret type: " + ret.getClass());
                        }
                        if (retExpr != null)
                            state.addExpr(left, retExpr);
                        state.popParam();
                    } else {
                        Log.error("[-] Unsupported Ret type: " + ret.getClass());
                    }
                    doOne(ret, state, state.popCFG(), true);
                }
                return state;

            } else if (curUnit instanceof JReturnVoidStmt) {
                if (state.isCallStackEmpty()) {
                    if (enableSolve)// Entry method
                        this.printSimplifyConstaints(state.constraints);
                } else { // callee method
                    Unit ret = state.popCall();
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
                } else {
                    Log.error("|- [-] Unsupported right type: " + right.getClass());
                }
            } else {
                Log.error("Unhandle Unit: " + curUnit + curUnit.getClass());
            }

            // end handle ,get next unit
            if (curUnit instanceof JGotoStmt) {
                GotoStmt gotoStmt = (GotoStmt) curUnit;
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
    public Expr handleUidAPI(InvokeExpr expr, FlowState state) {
        List<Value> args = expr.getArgs();
        String methodName = expr.getMethod().getName();
        if (methodName.equals("getCallingUid")) {
            String symbolName = "TYPE_PID#UID";
            Expr uidExpr = state.getSymbolByName(symbolName);
            if (uidExpr == null) {
                uidExpr = z3Ctx.mkIntConst(symbolName);
                state.addSymbol(uidExpr);
            }
            return uidExpr;
        }
        return null;
    }

    // TODO add uid limit
    public Expr handlePidAPI(InvokeExpr expr, FlowState state) {
        List<Value> args = expr.getArgs();
        String methodName = expr.getMethod().getName();
        if (methodName.equals("getCallingPid")) {
            String symbolName = "TYPE_PID#PID";
            Expr pidExpr = state.getSymbolByName(symbolName);
            if (pidExpr == null) {
                pidExpr = z3Ctx.mkInt(symbolName);
                state.addSymbol(pidExpr);
            }
            return pidExpr;
        }
        return null;
    }

    public Expr handleAppOpAPI(InvokeExpr expr, FlowState state) {
        List<Value> args = expr.getArgs();
        String methodName = expr.getMethod().getName();
        if (CheckAppOpAPI.getAllMethodNameByClassName("android.app.AppOpsManager").contains(methodName)
                || methodName.equals("noteOp") ||  methodName.equals("checkOp")) {
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
                AppOpExpr = z3Ctx.mkIntConst(symbolName);
                state.addSymbol(AppOpExpr);
            }

            // add Constraint for possible results
            List<Expr> possbileValueConstraints = new ArrayList<>();
            for (int i : CheckAppOpAPI.POSSIBLE_APPOP_CHECK_RESULTS) {
                possbileValueConstraints.add(z3Ctx.mkEq(AppOpExpr, z3Ctx.mkInt(i)));
            }
            state.addConstraint(z3Ctx.mkEq(z3Ctx.mkOr(possbileValueConstraints.toArray(new Expr[0])), z3Ctx.mkTrue()));
            return AppOpExpr;
        }
        return null;
    }

    public Expr handlePermissionAPI(InvokeExpr expr, FlowState state) {
        List<Value> args = expr.getArgs();
        String methodName = expr.getMethod().getName();
        if (methodName.startsWith("enforce")) {
            String permissionValue;
            if (args.get(0) instanceof StringConstant) {
                // add permission symbol
                permissionValue = ((StringConstant) args.get(0)).value;
            } else if (args.get(0) instanceof Local) {
                Value permission = args.get(0);
                Expr permissionExpr = state.getExpr(permission);
                permissionValue = permissionExpr.toString();
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
            Expr enforceExpr = z3Ctx.mkEq(permissionExpr, z3Ctx.mkInt(PERMISSION_GRANTED));
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
                permissionValue = permissionExpr.toString();
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
            for (int i : CheckPermissionAPI.POSSIBLE_PERMISSIONS_CHECK_RESULTS) {
                possbileValueConstraints.add(z3Ctx.mkEq(permissionExpr, z3Ctx.mkInt(i)));
            }
            state.addConstraint(z3Ctx.mkEq(z3Ctx.mkOr(possbileValueConstraints.toArray(new Expr[0])), z3Ctx.mkTrue()));
            return permissionExpr;
        }
        return null;
    }

    public FlowState handleInvoke(InvokeStmt stmt, FlowState state) {
        return handleInvoke(stmt.getInvokeExpr(), state);
    }

    public FlowState handleInvoke(InvokeExpr expr, FlowState state) {
        SootMethod callee = expr.getMethod();
        String methodName = callee.getName();
        String className = callee.getDeclaringClass().getName();

        if (CheckPermissionAPI.allClassNames.contains(className)) {
            Log.info("[+] Find Permission API: " + className + "." + methodName);
            Expr e = handlePermissionAPI(expr, state);
            if (e != null) {
                Unit ret = state.popCall();
                if (ret instanceof AssignStmt assign) {
                    Value left = assign.getLeftOp();
                    state.addExpr(left, e);
                } else {
                    Log.error("[-] Unsupported Ret type: " + ret.getClass());
                }

                doOne(ret, state, state.popCFG(), true);
                return null;
            }

        } else if (CheckUidAPI.allClassNames.contains(className)) {
            Log.info("[+] Find UID API: " + className + "." + methodName);
            Expr e = handleUidAPI(expr, state);
            if (e != null) {
                Unit ret = state.popCall();
                if (ret instanceof AssignStmt assign) {
                    Value left = assign.getLeftOp();
                    state.addExpr(left, e);
                } else {
                    Log.error("[-] Unsupported Ret type: " + ret.getClass());
                }
                doOne(ret, state, state.popCFG(), true);
                return null;
            }
        } else if (CheckPidAPI.allClassNames.contains(className)) {
            Log.info("[+] Find UID API: " + className + "." + methodName);
            Expr e = handlePidAPI(expr, state);
            if (e != null) {
                Unit ret = state.popCall();
                if (ret instanceof AssignStmt assign) {
                    Value left = assign.getLeftOp();
                    state.addExpr(left, e);
                } else {
                    Log.error("[-] Unsupported Ret type: " + ret.getClass());
                }
                doOne(ret, state, state.popCFG(), true);
                return null;
            }
        } else if (CheckAppOpAPI.getAllClassName().contains(className)) {
            Log.info("[+] Find AppOp API: " + className + "." + methodName);
            Expr e = handleAppOpAPI(expr, state);
            if (e != null) {
                Unit ret = state.popCall();
                if (ret instanceof AssignStmt assign) {
                    Value left = assign.getLeftOp();
                    state.addExpr(left, e);
                } else {
                    Log.error("[-] Unsupported Ret type: " + ret.getClass());
                }
                doOne(ret, state, state.popCFG(), true);
                return null;
            }
        }

        else if (className.equals("java.lang.Exception")) {
            Log.info("[-] Exception invoke. Terminate. ");
            return null;
        }

        // handle normal case
        if (className.equals(entryMethod.getDeclaringClass().getName()) || enableInterAnalysis) {
            preInvoke(expr, state);
            analyzeMethod(callee, state);
        } else {
            Unit ret = state.popCall();
            doOne(ret, state, state.popCFG(), true);
        }
        return null;
    }

    // pass the parameters to the callee
    public void preInvoke(InvokeExpr expr, FlowState state) {
        List<Value> args = expr.getArgs();
        // get all ParameterRef
        List<Expr> params = new ArrayList<>();
        for (int i = 0; i < args.size(); i++) {
            Value arg = args.get(i);
            if (arg instanceof Local l) {
                Expr e = state.getExpr(l);
                params.add(e);
            } else {
                Log.error("Unsupported type: " + arg.getClass());
            }
        }
        state.pushParam(params);
    }

    // ============================================================================================
    public void printSimplifyConstaints(List<Expr> constraints) {
        Log.info("================== [Solve] ========================");
        List<String> r = new ArrayList<>();
        for (Expr c : constraints) {
            r.add(c.toString());
        }
        this.result.add(r);
        Log.info("===================================================");
        return;
    }

    public Set<List<String>> getResult() {
        Set<List<String>> uniqueLists = new LinkedHashSet<>();
        // 遍历原始列表，将其加入 Set 中
        for (List<String> sublist : this.result) {
            uniqueLists.add(new ArrayList<>(sublist));
        }
        // 清空原始列表并重新赋值
        return uniqueLists;
    }

    public boolean solveConstraints(List<Expr> constraints) {
        Log.info("================== [Solve] ========================");
        Solver s = this.z3Ctx.mkSolver();
        boolean sat = false;
        for (Expr c : constraints) {
            s.add(c);
            Log.info(c.toString());
        }
        // list all symbol and remove which is not constaint

        // while (s.check() == com.microsoft.z3.Status.SATISFIABLE) {
        // Log.info("[+] SATISFIABLE");
        // sat = true;
        //
        // Model model = s.getModel();
        // Map<Expr, Expr> currentSolution = new HashMap<>();
        //
        // // 获取并输出符号的解
        // for (FuncDecl<?> decl : model.getConstDecls()) {
        // String symbolName = decl.getName().toString();
        // Expr<?> value = model.getConstInterp(decl);
        // Log.info("Symbol: " + symbolName + ", Value: " + value);
        // currentSolution.put(this.z3Ctx.mkConst(decl), value);
        // }
        //
        // // 添加约束以避免找到相同的解
        // List<BoolExpr> blockingClause = new ArrayList<>();
        // for (Map.Entry<Expr, Expr> entry : currentSolution.entrySet()) {
        // blockingClause.add(this.z3Ctx.mkNot(this.z3Ctx.mkEq(entry.getKey(),
        // entry.getValue())));
        // }
        // s.add(this.z3Ctx.mkOr(blockingClause.toArray(new BoolExpr[0])));
        // }

        Log.info("===================================================");
        return sat;
    }

    public boolean solveConstraintsSingle(List<Expr> constraints) {
        if (constraints.size() == 0)
            return true;
        Solver s = this.z3Ctx.mkSolver();
        boolean sat = false;
        for (Expr c : constraints) {
            s.add(c);
        }

        if (s.check() == com.microsoft.z3.Status.SATISFIABLE) {
            sat = true;
        }
        return sat;
    }

    // 用于表示数据传播的状态
    class FlowState {
        public Set<Expr> symbol;
        public Map<Value, Expr> localMap;
        public List<Expr> constraints;
        public Stack<Unit> callStack;
        public Stack<DirectedGraph<Unit>> cfgStack;
        public List<List<Expr>> paramList;
        // public Map<SootClass,Map<Value,Expr>> staticMaps;
        public Map<Unit, Integer> instCount;

        protected FlowState() {
            this.localMap = new HashMap();
            this.constraints = new ArrayList();
            this.symbol = new HashSet<>();
            this.callStack = new Stack<>();
            this.cfgStack = new Stack<>();
            this.paramList = new ArrayList<>();
            this.instCount = new HashMap<>();
        }

        public int addInstCount(Unit u) {
            int count;
            if (this.instCount.containsKey(u)) {
                count = this.instCount.get(u) + 1;
                this.instCount.put(u, count);
            } else {
                this.instCount.put(u, 1);
                count = 1;
            }
            return count;
        }

        public void pushCall(Unit u) {
            this.callStack.push(u);
        }

        public Unit popCall() {
            return this.callStack.pop();
        }

        public boolean isCallStackEmpty() {
            return this.callStack.isEmpty();
        }

        public void pushCFG(DirectedGraph<Unit> cfg) {
            this.cfgStack.push(cfg);
        }

        public DirectedGraph<Unit> popCFG() {
            return this.cfgStack.pop();
        }

        public boolean isCFGstackEmpty() {
            return this.cfgStack.isEmpty();
        }

        public void pushParam(List<Expr> params) {
            this.paramList.add(params);
        }

        public List<Expr> getParam() {
            return this.paramList.get(this.paramList.size() - 1);
        }

        public Expr getParam(int index) {
            if (this.paramList.isEmpty())
                return null;
            List<Expr> exprs = this.paramList.get(this.paramList.size() - 1);
            if (index < exprs.size())
                return exprs.get(index);
            return null;
        }

        public void popParam() {
            this.paramList.remove(this.paramList.size() - 1);
        }

        public boolean isParamEmpty() {
            return this.paramList.isEmpty();
        }

        // public Map<Value,Expr> getStaticMapByClassName(SootClass c){
        // return this.staticMaps.get(c);
        // }

        // public Expr getExprByValue(SootClass c,Value v){
        // Map<Value,Expr> map = this.staticMaps.get(c);
        // if(map == null)
        // return null;
        // return map.get(v);
        // }

        public void addConstraint(Expr c) {
            this.constraints.add(c);
        }

        public void addSymbol(Expr s) {
            this.symbol.add(s);
        }

        public Expr getSymbolByName(String name) {
            for (Expr s : this.symbol) {
                if (s.toString().equals(name)) {
                    return s;
                }
            }
            return null;
        }

        public void removeLocal(Value l) {
            this.localMap.remove(l);
        }

        public void removeAllLocal() {
            this.localMap.clear();
        }

        public Expr getExpr(Value l) {
            Expr r = (Expr) this.localMap.get(l);
            return r;
        }

        public void addExpr(Value l, Expr e) {
            if (e == null) {
                throw new IllegalArgumentException("Not valid");
            }
            this.localMap.put(l, e);
        }

        // TODO 处理深拷贝
        public void copyTo(FlowState dest) {
            dest.localMap.putAll(this.localMap);
            dest.constraints.addAll(this.constraints);
            dest.symbol.addAll(this.symbol);
            dest.callStack.addAll(this.callStack);
            dest.cfgStack.addAll(this.cfgStack);
            dest.paramList.addAll(this.paramList);
            dest.instCount.putAll(this.instCount);
        }

        public FlowState copy() {
            FlowState copy = new FlowState();
            this.copyTo(copy);
            return copy;
        }

        public void clear() {
            this.localMap.clear();
            this.constraints.clear();
        }

    }
}
