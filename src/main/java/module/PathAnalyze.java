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
import soot.jimple.*;
import soot.jimple.internal.*;
import soot.jimple.toolkits.ide.icfg.OnTheFlyJimpleBasedICFG;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.util.Chain;
import utils.Log;

import module.HookSymbol.*;


import java.util.*;

import static init.Config.enableInterAnalysis;
import static init.Config.enableLazySolve;

public class PathAnalyze {
    public SootMethod entryMethod;
    public Context z3Ctx;
    public boolean enableSolve;
    public List<List<String>> analyzeResult;
    public HashSet<SootMethod> CheckMethods;

    public PathAnalyze(SootMethod entryMethod,HashSet<SootMethod> CheckMethods) {
        this.CheckMethods = CheckMethods;
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
            Log.error("Unsupported value type: " + v.getClass());
    }

    public SimState handleInitMethod() {
        SimState initState = new SimState();
        SootClass sc = this.entryMethod.getDeclaringClass();
        // has <clinit>?
        SootMethod clinitMethod = sc.getMethodByNameUnsafe("<clinit>");
        if (clinitMethod != null) {
            analyzeMethod(clinitMethod, initState);
        }
        return initState;
    }


    public void startAnalyze() {
        // g.displayGraph();
        SimState initState = handleInitMethod();
        this.enableSolve = true;

        //symbolize params
        if(Config.enableParamSymbolize){
            makeParamsSymbol(this.entryMethod, initState);
        }

        // return;
        analyzeMethod(this.entryMethod, initState);
    }

    public void analyzeMethod(SootMethod m, SimState state) {
        Log.warn("[+] Analyzing method: " + m.getDeclaringClass().getName() + "." + m.getName());
        OnTheFlyJimpleBasedICFG icfg = new OnTheFlyJimpleBasedICFG(m);
        Body body = m.retrieveActiveBody();
        ExceptionalUnitGraph cfg = new ExceptionalUnitGraph(body);
        state.setCurCFG(cfg);
        Unit entryPoint = cfg.getHeads().get(0);

        doOne(entryPoint, state, false);
        return;
    }

    // TODO HANDLE MULTIPLE EXCEPTION HANDLER
    // public Unit getExceptionHandler(Unit curUnit, SimState state){ 
    //     Log.warn("Get Exception Handler");
    //     while(!state.isCallStackEmpty()){
    //         Unit lastCallUnit = postInvoke(state);
    //         ExceptionalUnitGraph lastcfg = state.getCurCFG();
    //         lastcfg.getBody().getTraps();
    //         List<Unit> exceptionHandler = lastcfg.getExceptionalSuccsOf(lastCallUnit);
    //         if(exceptionHandler.size() == 1){
    //             return exceptionHandler.get(0);
    //         }
    //     }
    //     return null;
    // }



    public Unit getExceptionHandler(Unit curUnit, SimState state, RefType exceptionType) {
        Log.warn("Get Exception Handler for exception type: " + exceptionType);
        while (!state.isCallStackEmpty()) {
            Unit lastCallUnit = postInvoke(state);
            ExceptionalUnitGraph lastcfg = state.getCurCFG();
            
            // 获取所有异常处理
            List<Unit> exceptionHandlers = lastcfg.getExceptionalSuccsOf(lastCallUnit);
            
            if (exceptionHandlers.isEmpty()) {
                continue; // 如果没有异常处理，继续检查调用栈的下一个单元
            }
            // 获取特定异常类型的处理
            Chain<Trap> traps = lastcfg.getBody().getTraps();
            for (Trap trap : traps) {
                // 检查该trap是否覆盖当前单元
                if (trap.getBeginUnit().equals(lastCallUnit) || 
                    lastcfg.getSuccsOf(trap.getBeginUnit()).contains(lastCallUnit)) {
                    
                    // 检查异常类型是否匹配
                    RefType trapException = trap.getException().getType();
                    if (exceptionType.equals(trapException) || 
                        Scene.v().getActiveHierarchy().isClassSubclassOf(
                            exceptionType.getSootClass(), 
                            trapException.getSootClass())) {
                        
                        return trap.getHandlerUnit();
                    }
                }
            }
            
            // 如果没有找到具体异常类型的处理，但有通用处理器（catch all）
            for (Trap trap : traps) {
                if (trap.getException().getType().equals(
                    Scene.v().getType("java.lang.Throwable"))) {
                    return trap.getHandlerUnit();
                }
            }
        }
        
        Log.warn("No handler found for exception type: " + exceptionType);
        return null;
    }



    public Expr handleCastExpr(Context z3Ctx,JCastExpr castExpr, SimState state){
        Expr src = valueToExpr(castExpr.getOp(),state);
        Type type = castExpr.getType();
        //TODO 
        if(type instanceof RefType refType){
            return null;
        }
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

    public void doOne(Unit curUnit, SimState state, Boolean isFromReturn) {

        ExceptionalUnitGraph cfg = state.getCurCFG();
        // handle return
        if (isFromReturn) {
            List<Unit> units = cfg.getUnexceptionalSuccsOf(curUnit);
            for (Unit u : units) {
                doOne(u, state, false);
            }
            return;
        }

        while (curUnit != null) {
            Log.info(curUnit.toString());
            if (curUnit instanceof JIfStmt ifStmt) {
                Value condition = ifStmt.getCondition();
                Expr result = handleCalculate(condition, state);
                
                // copy current state
                SimState branchState = state.copy();
                Unit branch1 = ifStmt.getTarget();
                Unit branch2 = cfg.getUnexceptionalSuccsOf(curUnit).get(0);
                if (result != null) {
                    // condition is true
                    Log.info("|- IfStmt 1, condition TRUE: " + condition);
                    branchState.addConstraint(result);
                    if (branchState.addInstCount(curUnit) <= Config.branchLimit
                            && (enableLazySolve || SymbolSolver.solveConstraintsSingle(this.z3Ctx,branchState.constraints))) {
                        doOne(branch1, branchState, false);

                    } else
                        Log.info("unsat branch");

                    // condition is false
                    Log.info("|- IfStmt 2, condition FALSE: !" + condition);
                    state.addConstraint(this.z3Ctx.mkNot(result));
                    if (state.addInstCount(curUnit) <= Config.branchLimit + 1
                            && (enableLazySolve || SymbolSolver.solveConstraintsSingle(this.z3Ctx,state.constraints))) {
                        doOne(branch2, state,  false);
                    } else {
                        Log.info("unsat branch");
                    }

                    return;
                } else {
                    if (branchState.addInstCount(curUnit) <= Config.branchLimit) {
                        Log.info("|- IfStmt 1, condition TRUE: " + condition);
                        doOne(branch1, branchState,  false);
                    }
                    if (state.addInstCount(curUnit) <= Config.branchLimit + 1) {
                        Log.info("|- IfStmt 2, condition FALSE: !" + condition);
                        doOne(branch2, state, false);
                    }
                    return;

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
                        Log.info("SecurityException branch. Terminate.");
                        return;
                    } else {
                        Log.error("Unsupported right type: " + right.getClass());
                    }
                } else if (right instanceof InvokeExpr) {
                    preInvoke(curUnit, state);
                    handleInvoke(curUnit, state);
                    return;
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
                Expr expr = state.getExpr(key);

                // handle switch case
                List<IntConstant> caseValues = switchStmt.getLookupValues();
                for (IntConstant ii : caseValues) {
                    Unit target = switchStmt.getTargetForValue(ii.value);
                    Expr v = z3Ctx.mkBV(ii.value, 32);
                    SimState branchState = state.copy();
                    if (expr != null) {
                        branchState.addConstraint(z3Ctx.mkEq(expr, v));
                        if (enableLazySolve || SymbolSolver.solveConstraintsSingle(this.z3Ctx,state.constraints)) {
                            doOne(target, branchState, false);
                        }
                    } else
                        doOne(target, branchState,false);
                }

                // handle default case
                Unit defaultTarget = switchStmt.getDefaultTarget();
                SimState branchState = state.copy();
                if (expr != null) {
                    branchState.addConstraint(z3Ctx.mkNot(z3Ctx.mkOr(caseValues.stream()
                            .map(ii -> z3Ctx.mkEq(expr, z3Ctx.mkBV(ii.value, 32))).toArray(Expr[]::new))));
                    if (enableLazySolve || SymbolSolver.solveConstraintsSingle(this.z3Ctx,state.constraints)) {
                        doOne(defaultTarget, branchState,false);
                    }
                } else
                    doOne(defaultTarget, branchState,  false);
                return;

            } else if (curUnit instanceof JInvokeStmt) {
                preInvoke(curUnit, state);
                handleInvoke(curUnit, state);
                return;

            } else if (curUnit instanceof JThrowStmt) {
                //TODO Handle other exception
                return;
          } else if(curUnit instanceof JCaughtExceptionRef) {
            

          }
          
          else if (curUnit instanceof JEnterMonitorStmt) {
            /* DO NOTHING */
          } else if (curUnit instanceof JExitMonitorStmt) {
            /* DO NOTHING */
          } else if (curUnit instanceof JReturnStmt returnStmt) {
                if (state.isCallStackEmpty()) {
                    if (enableSolve)
                        this.printSimplifyConstaints(state.constraints);
                } else { 
                    Value retValue = returnStmt.getOp();
                    Expr retExpr = valueToExpr(retValue,state);
                    Unit ret = postInvoke(state);
                    if (ret instanceof AssignStmt assignStmt) {
                        Value left = assignStmt.getLeftOp();
                        if (retExpr != null) {
                            updateValue(left, retExpr, state);
                        }
                    } else {
                        Log.error("Unsupported Ret Unit type: " + ret.getClass());
                    }
                    doOne(ret, state, true);
                }
                return;

            } else if (curUnit instanceof JReturnVoidStmt) {
                if (state.isCallStackEmpty()) {
                    if (enableSolve)// Entry method
                        this.printSimplifyConstaints(state.constraints);
                } else { // callee method
                    Unit ret = postInvoke(state);
                    doOne(ret, state, true);
                }
                return;

            } else if (curUnit instanceof JIdentityStmt identityStmt) {
                Value right = identityStmt.getRightOp();
                Value left = identityStmt.getLeftOp();
                if (right instanceof ParameterRef p) {
                    int paramIndex = p.getIndex();
                    Expr param = state.getParam(paramIndex);
                    if (param != null) {
                        updateValue(left, param, state);
                    }
                } else {
                    Log.error("Unsupported right type: " + right.getClass());
                }
            } else if (curUnit instanceof JGotoStmt gotoStmt) {
                Unit target = gotoStmt.getTarget();
                doOne(target, state, false);
                return;
            } else {
                Log.error("Unhandle Unit: " + curUnit + curUnit.getClass());
            }
            // end handle ,get next unit
             


            List<Unit> nextUnits = cfg.getUnexceptionalSuccsOf(curUnit);
            for (Unit u : nextUnits) {
                doOne(u, state, false);
            }
            return;
            
        }
        return;
    }


    public void handleInvoke(Unit curUnit, SimState state) {
        // get invoke expr
        InvokeExpr expr = null;
        if(curUnit instanceof JInvokeStmt invokeStmt){
            expr = invokeStmt.getInvokeExpr();
        // } 
        // else if(curUnit instanceof JIdentityStmt identityStmt){
        //     Value right = identityStmt.getRightOp();
        //     if(right instanceof InvokeExpr invokeExpr){
        //         expr = invokeExpr;
        // }
        } else if(curUnit instanceof JAssignStmt assignStmt){
            Value right = assignStmt.getRightOp();
            if(right instanceof InvokeExpr invokeExpr){
                expr = invokeExpr;
            }
        } else {
            Log.error("Unsupported Stmt: " + curUnit.getClass());
        }

        // get callee method and Name
        SootMethod callee = expr.getMethod();
        String methodName = callee.getName();
        String className = callee.getDeclaringClass().getName();


        //hook
        if (CheckPermissionAPI.allClassNames.contains(className)) {
            Log.warn("[+] Handle Permission API: " + className + "." + methodName);
            Expr e = HookSymbol.handlePermissionAPI(expr, state, this.z3Ctx);
            if (e != null) {
                //spceial case for enforce
                //throw SecurityException
                if(methodName.startsWith("enforce")){
                    SimState throwState = state.copy();
                    Unit exceptionHandler = getExceptionHandler(curUnit, throwState, Scene.v().getRefType("java.lang.SecurityException"));
                    if(exceptionHandler != null){ 
                        throwState.popConstraint();
                        Expr permissionExpr = throwState.getLastSymbol();
                        Expr permissionValue = this.z3Ctx.mkEq(permissionExpr, z3Ctx.mkBV(CheckPermissionAPI.PERMISSION_SOFT_DENIED, 32));
                        throwState.addConstraint(permissionValue);
                        doOne(exceptionHandler, throwState, false);
                        return;
                    }
                }

                Unit ret = postInvoke(state);
                if (ret instanceof JAssignStmt assign) {
                    Value left = assign.getLeftOp();
                    updateValue(left, e, state);
                } else if(ret instanceof JInvokeStmt ){
                    // VOID invoke
                } else {
                    Log.error("Unsupported Ret Unit type: " + ret.getClass());
                }
                doOne(ret, state, true);
                return;
            }
        } else if (CheckUidAPI.allClassNames.contains(className) && methodName.equals("getCallingUid")) {
            Log.warn("[+] Find UID API: " + className + "." + methodName);
            Expr e = HookSymbol.handleUidAPI(expr, state, this.z3Ctx);
            if (e != null) {
                Unit ret = postInvoke(state);
                if (ret instanceof AssignStmt assign) {
                    Value left = assign.getLeftOp();
                    updateValue(left, e, state);
                } else {
                    Log.error("Unsupported Ret Unit type:  " + ret.getClass());
                }
                doOne(ret, state, true);
                return;
            }
        } else if (CheckPidAPI.allClassNames.contains(className) && methodName.equals("getCallingPid")) {
            Log.warn("[+] Find PID API: " + className + "." + methodName);
            Expr e = HookSymbol.handlePidAPI(expr, state, this.z3Ctx);
            if (e != null) {
                Unit ret = postInvoke(state);
                if (ret instanceof AssignStmt assign) {
                    Value left = assign.getLeftOp();
                    updateValue(left, e, state);
                } else {
                    Log.error("Unsupported Ret Unit type: " + ret.getClass());
                }
                doOne(ret, state, true);
                return;
            }
        } else if (CheckAppOpAPI.getAllClassName().contains(className)) {
            Log.warn("[+] Find AppOp API: " + className + "." + methodName);
            Expr e = HookSymbol.handleAppOpAPI(expr, state, this.z3Ctx);
            if (e != null) {
                Unit ret = postInvoke(state);
                if (ret instanceof AssignStmt assign) {
                    Value left = assign.getLeftOp();
                    updateValue(left, e, state);
                } else {
                    Log.error("Unsupported Ret Unit type:  " + ret.getClass());
                }
                doOne(ret, state, true);
                return ;
            }
        }

        else if (className.equals("java.lang.Exception")) {
            Log.warn("Exception invoke. Terminate.");
            return;
        } else if (className.equals("android.os.Process") && methodName.equals("myPid")) {
            Expr e = HookSymbol.handleMyPidAPI(expr, state, this.z3Ctx);
            if (e != null) {
                Unit ret = postInvoke(state);
                if (ret instanceof AssignStmt assign) {
                    Value left = assign.getLeftOp();
                    updateValue(left, e, state);
                } else {
                    Log.error("Unsupported Ret Unit type:  " + ret.getClass());
                }
                
                doOne(ret, state, true);
                return;
            }
        }


        OnTheFlyJimpleBasedICFG cfg = new OnTheFlyJimpleBasedICFG(callee);
        Boolean hasActiveBody = callee.hasActiveBody();

        // handle normal case
        if(  hasActiveBody && (entryMethod.getDeclaringClass().getName().contains(className) || StaticAPIs.ANALYZE_CLASS_SET.contains(methodName) || (enableInterAnalysis && this.CheckMethods.contains(callee) ) )  ) {
           
            analyzeMethod(callee, state);
            return;
        } else { // DO NOTHING
            Unit ret = postInvoke(state);
            doOne(ret, state, true);
        }
        return;
    }

    // pass the parameters to the callee
    public void preInvoke(Unit curUnit, SimState state) {
        // get invoke expr
        InvokeExpr expr = null;
        if(curUnit instanceof JInvokeStmt invokeStmt){
            expr = invokeStmt.getInvokeExpr();
        // }
        //  else if(curUnit instanceof JIdentityStmt identityStmt){
        //     Value right = identityStmt.getRightOp();
        //     if(right instanceof InvokeExpr invokeExpr){
        //         expr = invokeExpr;
        //     }
        } else if(curUnit instanceof JAssignStmt assignStmt){
            Value right = assignStmt.getRightOp();
            if(right instanceof InvokeExpr invokeExpr){
                expr = invokeExpr;
            }
        } else {
            Log.error("Unsupported Stmt: " + curUnit.getClass());
        }

        // pass param
        List<Value> args = expr.getArgs();
        List<Expr> params = new ArrayList<>();
        for (int i = 0; i < args.size(); i++) {
            Value arg = args.get(i);
            Expr e = valueToExpr(arg, state);
            params.add(e);
        }
        state.pushCall(curUnit);
        state.pushLocalMap();
        state.pushParam(params);
        state.pushCFG();
    }


    public Unit postInvoke(SimState state) {
        state.popCFG();
        state.popParam();
        state.popLocalMap();
        return state.popCall();
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