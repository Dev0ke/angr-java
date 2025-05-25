package Engine;

import accessControl.*;

import init.Config;
import module.HookSymbol;
import solver.SymbolSolver;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;

import soot.*;
import soot.jimple.*;
import soot.jimple.internal.*;
import soot.jimple.toolkits.ide.icfg.OnTheFlyJimpleBasedICFG;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.util.Chain;
import utils.Log;

import java.util.*;

import static init.Config.enableInterAnalysis;
import static init.Config.enableLazySolve;

public class PathAnalyze {
    public SootMethod entryMethod;
    public Context z3Ctx;
    public boolean enableSolve;
    public List<List<String>> analyzeResult;
    public HashSet<SootMethod> CheckMethods;
    
    // 记录已求解的约束键，避免重复求解
    private Set<String> solvedConstraints;
    
    // 缓存 solveConstraintsSingle 的结果
    private Map<String, Boolean> constraintsSingleCache;

    public PathAnalyze(SootMethod entryMethod,HashSet<SootMethod> CheckMethods) {
        this.CheckMethods = CheckMethods;
        this.entryMethod = entryMethod;
        this.analyzeResult = new ArrayList<>();
        this.z3Ctx = new Context();
        this.enableSolve = false;
        // 初始化已求解约束集合
        this.solvedConstraints = new HashSet<>();
        // 初始化 solveConstraintsSingle 缓存
        this.constraintsSingleCache = new HashMap<>();
        // start
        Log.info("[+] Start PathAnalyze in API: " + this.entryMethod.getName());

    }

    public void makeParamsSymbol(SootMethod m, SimState state) {
        List<Type> paramTypes = m.getParameterTypes();
        List<SymBase> entryParams = new ArrayList<>();
        for(int i = 0; i < paramTypes.size(); i++){
            Type paramType = paramTypes.get(i);
            String name = String.format("<INPUT>%s_x%d",paramType.toString(),i);
            SymBase paramExpr = SymGen.makeSymbol(this.z3Ctx,paramType,name);
            entryParams.add(paramExpr);
        }
        state.pushParam(entryParams);

    }

    public SymBase valueToSym(Value operand,SimState state){
        SymBase v = null;
        if(operand instanceof Constant constant)
            v = SymGen.makeConstantExpr(this.z3Ctx,constant);
        else if(operand instanceof JimpleLocal)
            v = state.getLocalSym(operand);
        else if(operand instanceof StaticFieldRef staticRef)
            v = state.getStaticExpr(staticRef);
        else if(operand instanceof JArrayRef arrayRef){
            Value base = arrayRef.getBase();
            v = state.getLocalSym(base);
        } else{
            Log.error("Unsupported value type: " + operand.getClass());
        }
        return v;
    }


    public void updateValue(Value v, SymBase e, SimState state){
        if(v instanceof JimpleLocal)
            state.addLocalSym(v, e);
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

    public void handleArrayAssign(JAssignStmt assignStmt, SimState state){}

    public static boolean hasMultipleInDegrees(UnitGraph cfg, Unit unit) {
        List<Unit> predecessors = cfg.getPredsOf(unit);
        return predecessors.size() > 1;
    }
    

    public void startAnalyze() {
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


    /*   ------------------------------------------------   */
    /*                    Exception Handler                 */
    /*   ------------------------------------------------   */

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



    public static int SwitchCase2Int(List<IntConstant> caseValues, IntConstant key){
        int size = caseValues.size();
        List<Integer> sortedCaseValues = new ArrayList<>(size);
        for(IntConstant c : caseValues){
            sortedCaseValues.add(c.value);
        }
        Collections.sort(sortedCaseValues);
        //find key
        int mappedKey = sortedCaseValues.indexOf(key.value) + 1;
        return mappedKey;
    }


    public static List<IntConstant> getCaseValuesFromTableSwitch(TableSwitchStmt tableSwitch) {
        List<IntConstant> caseValues = new ArrayList<>();
        int low = tableSwitch.getLowIndex();
        int high = tableSwitch.getHighIndex();
    
        for (int i = low; i <= high; i++) {
            caseValues.add(IntConstant.v(i));
        }
        return caseValues;
    }

    public SymBase handleCastExpr(Context z3Ctx,JCastExpr castExpr, SimState state){
        SymBase src = valueToSym(castExpr.getOp(),state);
        Type type = castExpr.getType();
        //TODO 
        if(type instanceof RefType refType){
            return null;
        }
        return SymGen.makeCastExpr(z3Ctx,type,src);
    }

    // handle data flow for one unit
    public SymBase handleCalculate(Value expr, SimState state) {
        if(expr instanceof BinopExpr binopExpr){
            SymBase left = valueToSym(binopExpr.getOp1(),state);
            if(left == null){
                left = SymGen.makeSymbol(this.z3Ctx,binopExpr.getOp1().getType(),binopExpr.getOp1().toString());
                updateValue(binopExpr.getOp1(), left, state);
            }
            SymBase right = valueToSym(binopExpr.getOp2(),state);
            if(right == null){
                right = SymGen.makeSymbol(this.z3Ctx,binopExpr.getOp2().getType(),binopExpr.getOp2().toString());
                updateValue(binopExpr.getOp2(), right, state);
            }
            return SymGen.makeBinOpExpr(this.z3Ctx,binopExpr,left,right);
        }
        else if(expr instanceof UnopExpr unopExpr){
            SymBase op = valueToSym(unopExpr.getOp(),state);
            if(op == null){
                op = SymGen.makeSymbol(this.z3Ctx,unopExpr.getOp().getType(),unopExpr.getOp().toString());
                updateValue(unopExpr.getOp(), op, state);
            }
            return SymGen.makeUnOpExpr(this.z3Ctx,unopExpr,op);
        }
        else{
            Log.error("Unsupported expression type: " + expr.getClass());
        }
        return null;
    }

     /*   ------------------------------------------------   */
     /*                     Main Loop                        */
     /*   ------------------------------------------------   */
    
    public void doOne(Unit curUnit, SimState state, Boolean isFromReturn) {

        /*   ------------------------------------------------   */
        /*                    From Return                       */
        /*   ------------------------------------------------   */

        ExceptionalUnitGraph cfg = state.getCurCFG();
        // handle return
        if (isFromReturn) {
            List<Unit> units = cfg.getUnexceptionalSuccsOf(curUnit);
            Log.warn("Return to: " + cfg.getBody().getMethod().getName());
            for (Unit u : units) {
                doOne(u, state, false);
            }
            return;
        }

        while (curUnit != null) {
            Log.info(curUnit.toString());

            /*   ------------------------------------------------   */
            /*                         If                           */
            /*   ------------------------------------------------   */

            if (curUnit instanceof JIfStmt ifStmt) {
                Value condition = ifStmt.getCondition();
                SymBase result = handleCalculate(condition, state);
                
                // copy current state
                SimState state_true = state.copy();
                SimState state_false = state;
                Unit branch_true = ifStmt.getTarget();
                Unit branch_false = cfg.getUnexceptionalSuccsOf(curUnit).get(0);

                if (result != null) {
                    Expr resultExpr = result.getExpr();
                    boolean isAccessControl = AccessControlUtils.isAccessControlSym(result);

                    // TODO 感觉需要修复一下
                    // if(state_true.getBranchDepth() > Config.branchLimit  && !isAccessControl){
                    //     Log.info("Branch Limit: " + state_true.getBranchDepth());

                    //     int choice = 0;
                    //     int branchCount0 = state_true.getBranchCount(curUnit,0);
                    //     int branchCount1 = state_true.getBranchCount(curUnit,1);
                    //     if(branchCount0 > branchCount1){
                    //         choice = 1;
                    //     } else if(branchCount0 < branchCount1){
                    //         choice = 0;
                    //     } else {
                    //         Random random = new Random();
                    //         choice = random.nextInt(2);
                    //     }

                    //     // TRUE state
                    //     if(choice == 0){ 
                    //         if(isAccessControl){
                    //             state_true.addGlobalConstraint(resultExpr);
                    //         } else{
                    //             state_true.addLocalConstraint(resultExpr);
                    //         }
                    //         state_true.addInstCount(curUnit,0);
                    //         doOne(branch_true, state_true, false);
                    //     }

                    //     // FALSE state
                    //     else{ 
                    //         if(isAccessControl){
                    //             state_false.addGlobalConstraint(this.z3Ctx.mkNot(resultExpr));
                    //         } else{
                    //             state_false.addLocalConstraint(this.z3Ctx.mkNot(resultExpr));
                    //         }
                    //         state_false.addInstCount(curUnit,1);
                    //         doOne(branch_false, state_false, false);      
                    //     }
                    //     return;
                    // }

                    Log.info("|- IfStmt 1, condition [TRUE]: " + condition);
                    if(isAccessControl){
                        state_true.addGlobalConstraint(resultExpr);
                    } else{
                        state_true.addLocalConstraint(resultExpr);
                    }
                    if ((state_true.addInstCount(curUnit,0) <= Config.LoopLimit ||  isAccessControl ) ){
                        if(enableLazySolve || solveConstraintsSingleWithCache(state_true.getFullConstraints()))
                            doOne(branch_true, state_true, false);
                        else{
                            Log.info("unsat branch");
                        }
                    } else {
                        Log.info("Limit branch");
                    }

             
                    Log.info("|- IfStmt 2, condition [FALSE]: not " + condition);
                    if(isAccessControl){
                        state_false.addGlobalConstraint(this.z3Ctx.mkNot(resultExpr));
                    } else{
                        state_false.addLocalConstraint(this.z3Ctx.mkNot(resultExpr));
                    }
                    if ((state_false.addInstCount(curUnit,1) <= Config.LoopLimit ||  isAccessControl ) ) {
                        if(enableLazySolve || solveConstraintsSingleWithCache(state_false.getFullConstraints()))
                            doOne(branch_false, state_false,  false);
                        else
                            Log.info("unsat branch");
                    } else {
                        Log.info("Limit branch");
                    }
                    return;

                } else {

                    // if(state_true.getBranchDepth() > Config.branchLimit && !AccessControlUtils.isAccessControlSym(result)){
                    //     Log.info("Branch Limit: " + state_true.getBranchDepth());

                    //     int choice = 0;
                    //     int branchCount0 = state_true.getBranchCount(curUnit,0);
                    //     int branchCount1 = state_true.getBranchCount(curUnit,1);
                    //     if(branchCount0 > branchCount1){
                    //         choice = 1;
                    //     } else if(branchCount0 < branchCount1){
                    //         choice = 0;
                    //     } else {
                    //         Random random = new Random();
                    //         choice = random.nextInt(2);
                    //     }

                    //     // choose branch
                    //     if(choice == 0){
                    //         // branchState.addConstraint(resultExpr);
                    //         state_true.addInstCount(curUnit,0);
                    //         doOne(branch_true, state_true, false);
                    //     } else{
                    //         // state.addConstraint(this.z3Ctx.mkNot(resultExpr));
                    //         state_false.addInstCount(curUnit,1);
                    //         doOne(branch_false, state_false, false);      
                    //     }
                    //     return;
                    // }

                    if (state_true.addInstCount(curUnit,0) <= Config.LoopLimit) {
                        // TODO Add constraint 
                        Log.info("|- IfStmt 1, condition TRUE: " + condition);
                        doOne(branch_true, state_true,  false);
                    }
                    if (state_false.addInstCount(curUnit,1) <= Config.LoopLimit) {
                        // TODO Add constraint 
                        Log.info("|- IfStmt 2, condition FALSE: !" + condition);
                        doOne(branch_false, state_false, false);
                    }
                    return;

                }

            }
            
            /*   ------------------------------------------------   */
            /*                       Assign                         */
            /*   ------------------------------------------------   */

            else if (curUnit instanceof JAssignStmt assignStmt) {
                Value left = assignStmt.getLeftOp();
                Value right = assignStmt.getRightOp();
                SymBase v = null;
                if (right instanceof JimpleLocal) {
                    v = state.getLocalSym(right);
                } else if (right instanceof Constant constant) {
                    v = SymGen.makeConstantExpr(this.z3Ctx, constant);
                } else if (right instanceof StaticFieldRef staticRef) {
                    v = state.getStaticExpr(staticRef);
                } else if (right instanceof BinopExpr binop) {
                    v = handleCalculate(binop, state);
                } else if (right instanceof UnopExpr unop) {
                    v = handleCalculate(unop, state);
                } else if (right instanceof JCastExpr cast) {
                    v = handleCastExpr(this.z3Ctx,cast, state);
                } else if (right instanceof JNewExpr newExpr) {
                    Type type = newExpr.getBaseType();
                    if (type.toString().equals("java.lang.SecurityException"))
                    {
                        Log.info("SecurityException branch. Terminate.");
                        Unit handler = getExceptionHandler(curUnit, state, (RefType)type);
                        if(handler != null){
                            doOne(handler, state, false);
                        }
                        return;
                    } 
                    else if(type.toString().equals("java.lang.StringBuilder"))
                    {
                        v = SymGen.makeSymbol(z3Ctx, type, "String_" + left.toString());
                    }
                    else 
                    {
                        Log.error("Unsupported right type: " + right.getClass());
                    }
                } else if(right instanceof JNewArrayExpr newArrayExpr){
                    // TODO
                    v = SymGen.makeArray(this.z3Ctx, newArrayExpr,newArrayExpr.toString());
                } else if(right instanceof JArrayRef arrayRef){
                    Value index = arrayRef.getIndex();
                    SymList symList = (SymList) valueToSym(arrayRef, state);
                    if(symList != null){
                        if(index instanceof IntConstant constant){
                            int indexValue = constant.value;
                            v = symList.get(indexValue);
                        } else if(index instanceof JimpleLocal local){
                            SymBase indexSym = state.getLocalSym(local);
                            v = symList.get(this.z3Ctx, indexSym,state);
                        } else{
                            Log.error("Unsupported index type: " + index.getClass());
                        }
                    } else {
                        v = null;
                    }
                } 
                
                else if(right instanceof JLengthExpr lengthExpr){
                    Value src = lengthExpr.getOp();
                    SymBase sym = valueToSym(src, state);
                    if(sym instanceof SymString symString){
                        // TODO
                        v = symString.length(this.z3Ctx);
                    } else{
                        Log.error("Unsupported length type: " + sym.getClass());
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
                // } else if (left instanceof JArrayRef arrayRef) {
                //     // TODO
                //     Value arrayValue = arrayRef.getBase();
                //     SymBase sym = valueToSym(arrayValue, state);
                //     if(sym instanceof SymArray symArray){
                //         Value index = arrayRef.getIndex();
                //         SymBase indexSym = valueToSym(index, state);
                //         if(indexSym instanceof BitVecExpr bitVecExpr){
                //             // SymArray.set(this.z3Ctx, seqExpr, bitVecExpr, v);
                //         }
                //         else{
                //             Log.error("Unsupported index type: " + indexExpr.getClass());
                //         }

                //     } else{
                //         Log.error("Unsupported JArrayRef: " + arrayRef.toString());
                //     }
                }
                else if (left instanceof StaticFieldRef staticRef) {
                    if (v != null)
                        state.addStaticField(staticRef, v);
                } else if (left instanceof JimpleLocal l) {
                    if (v != null)
                        state.addLocalSym(l, v);
                    else{
                        v = SymGen.makeSymbol(this.z3Ctx,left.getType(),left.toString());
                        state.addLocalSym(l, v);
                    }
                } else if (left instanceof JArrayRef arrayRef) {
                    SymList symList = (SymList) valueToSym(arrayRef, state);

                    if(symList != null){
                        Value index = arrayRef.getIndex();
                        if(index instanceof IntConstant constant){
                            int indexValue = constant.value;
                            if(v != null){
                                symList.set(indexValue, v);
                            }
                        }
                        else{
                            Log.error("Unsupported index type: " + index.getClass());
                        }
                    } else{
                        Log.error("SymList null");
                    }
                }

            }

            /*   ------------------------------------------------   */
            /*                       Identity                       */
            /*   ------------------------------------------------   */

            else if (curUnit instanceof JIdentityStmt identityStmt) {
                Value right = identityStmt.getRightOp();
                Value left = identityStmt.getLeftOp();
                if (right instanceof ParameterRef p) {
                    int paramIndex = p.getIndex();
                    SymBase param = state.getParam(paramIndex);
                    if (param != null) {
                        updateValue(left, param, state);
                    }
                } else {
                    Log.error("Unsupported right type: " + right.getClass());
                }
            } 

            /*   ------------------------------------------------   */
            /*                     LookupSwitch                     */
            /*   ------------------------------------------------   */

            else if (curUnit instanceof JLookupSwitchStmt switchStmt) {
                Value key = switchStmt.getKey();
                SymBase sym = state.getLocalSym(key);

                // handle switch case
                List<IntConstant> caseValues = switchStmt.getLookupValues();
                for (IntConstant ii : caseValues) {
                    Unit target = switchStmt.getTargetForValue(ii.value);
                    Expr v = z3Ctx.mkBV(ii.value, 32);
                    SimState branchState = state.copy();
                    int caseIdx = SwitchCase2Int(caseValues, ii);
                    if (sym != null) {
                        boolean isAccessControl = AccessControlUtils.isAccessControlSym(sym);
                        if(isAccessControl){
                            branchState.addGlobalConstraint(z3Ctx.mkEq(sym.getExpr(), v));
                        } else{
                            branchState.addLocalConstraint(z3Ctx.mkEq(sym.getExpr(), v));
                        }
                        if ( (branchState.addInstCount(switchStmt, caseIdx) <= Config.LoopLimit || isAccessControl) 
                                && (enableLazySolve || solveConstraintsSingleWithCache(branchState.getFullConstraints()))  ) {
                            doOne(target, branchState, false);
                        }
                    } else if(branchState.addInstCount(switchStmt, caseIdx) <= Config.LoopLimit){
                        doOne(target, branchState,false);
                    }
                }

                // handle default case
                Unit defaultTarget = switchStmt.getDefaultTarget();
                SimState branchState = state.copy();
                if (sym != null) {
                    boolean isAccessControl = AccessControlUtils.isAccessControlSym(sym);
                    if(isAccessControl){
                        branchState.addGlobalConstraint(z3Ctx.mkNot(z3Ctx.mkOr(caseValues.stream()
                                .map(ii -> z3Ctx.mkEq(sym.getExpr(), z3Ctx.mkBV(ii.value, 32))).toArray(Expr[]::new))));
                    } else{
                        branchState.addLocalConstraint(z3Ctx.mkNot(z3Ctx.mkOr(caseValues.stream()
                                .map(ii -> z3Ctx.mkEq(sym.getExpr(), z3Ctx.mkBV(ii.value, 32))).toArray(Expr[]::new))));
                    }
                    if ( (branchState.addInstCount(switchStmt, 0) <= Config.LoopLimit || isAccessControl) 
                                && (enableLazySolve || solveConstraintsSingleWithCache(branchState.getFullConstraints()))  ) {
                        doOne(defaultTarget, branchState,false);
                    }
                } else
                    doOne(defaultTarget, branchState,  false);
                return;

            }

            /*   ------------------------------------------------   */
            /*                     TableSwitch                      */
            /*   ------------------------------------------------   */

             else if (curUnit instanceof JTableSwitchStmt tableSwitchStmt) {
                Value key = tableSwitchStmt.getKey();
                SymBase sym = state.getLocalSym(key);

                // handle switch case
                List<IntConstant> caseValues = getCaseValuesFromTableSwitch(tableSwitchStmt);
                for (IntConstant ii : caseValues) {
                    Unit target = tableSwitchStmt.getTargetForValue(ii.value);
                    Expr v = z3Ctx.mkBV(ii.value, 32);
                    SimState branchState = state.copy();
                    int caseIdx = SwitchCase2Int(caseValues, ii);
                    if (sym != null) {
                        boolean isAccessControl = AccessControlUtils.isAccessControlSym(sym);
                        if(isAccessControl){
                            branchState.addGlobalConstraint(z3Ctx.mkEq(sym.getExpr(), v));
                        } else{
                            branchState.addLocalConstraint(z3Ctx.mkEq(sym.getExpr(), v));
                        }
                        if ( (branchState.addInstCount(tableSwitchStmt, caseIdx) <= Config.LoopLimit || isAccessControl)
                                            && (enableLazySolve || solveConstraintsSingleWithCache(branchState.getFullConstraints()))  ) {
                            doOne(target, branchState, false);
                        }
                    } else if(branchState.addInstCount(tableSwitchStmt, 0) <= Config.LoopLimit){
                        doOne(target, branchState,false);
                    }
                }

                // handle default case
                Unit defaultTarget = tableSwitchStmt.getDefaultTarget();
                SimState branchState = state.copy();
                if (sym != null) {
                    boolean isAccessControl = AccessControlUtils.isAccessControlSym(sym);
                    if(isAccessControl){
                        branchState.addGlobalConstraint(z3Ctx.mkNot(z3Ctx.mkOr(caseValues.stream()
                                .map(ii -> z3Ctx.mkEq(sym.getExpr(), z3Ctx.mkBV(ii.value, 32))).toArray(Expr[]::new))));
                    } else{
                        branchState.addLocalConstraint(z3Ctx.mkNot(z3Ctx.mkOr(caseValues.stream()
                                .map(ii -> z3Ctx.mkEq(sym.getExpr(), z3Ctx.mkBV(ii.value, 32))).toArray(Expr[]::new))));
                    }
                    if ( (branchState.addInstCount(tableSwitchStmt, 0) <= Config.LoopLimit || isAccessControl)
                                           && (enableLazySolve || solveConstraintsSingleWithCache(branchState.getFullConstraints()))  ) {
                        doOne(defaultTarget, branchState,false);
                    }
                } else if(branchState.addInstCount(tableSwitchStmt, 0) <= Config.LoopLimit){
                    doOne(defaultTarget, branchState,  false);
                }
                return;
            }
            
            /*   ------------------------------------------------   */
            /*                       Invoke                         */
            /*   ------------------------------------------------   */               
            
            else if (curUnit instanceof JInvokeStmt) {
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
          }
            /*   ------------------------------------------------   */
            /*                       Return                         */
            /*   ------------------------------------------------   */     
            
            else if (curUnit instanceof JReturnStmt returnStmt) {
                if (state.isCallStackEmpty()) {

                    // ignore return null
                    Value retValue = returnStmt.getOp();
                    if(retValue instanceof NullConstant)
                        return;

                    if (enableSolve)
                        this.printSimplifyConstaints(state.getGlobalConstraints());
                } else { 
                    Value retValue = returnStmt.getOp();
                    SymBase retExpr = valueToSym(retValue,state);
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
            } 
            
            else if (curUnit instanceof JReturnVoidStmt) {
                if (state.isCallStackEmpty()) {
                    if (enableSolve)// Entry method
                        this.printSimplifyConstaints(state.getGlobalConstraints());
                } else { // callee method
                    Unit ret = postInvoke(state);
                    doOne(ret, state, true);
                }
                return;

            } 
            



            /*   ------------------------------------------------   */
            /*                        Goto                          */
            /*   ------------------------------------------------   */   


           else if (curUnit instanceof JGotoStmt gotoStmt) {
                Unit target = gotoStmt.getTarget();
                doOne(target, state, false);
                return;
            } else {
                Log.error("Unhandle Unit: " + curUnit + curUnit.getClass());
            }

            /*   ------------------------------------------------   */
            /*                      Next Unit                       */
            /*   ------------------------------------------------   */                

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


        if(className.equals("java.lang.StringBuilder")){
            if(expr instanceof VirtualInvokeExpr virtualInvokeExpr){
                Value instance = virtualInvokeExpr.getBase();

                state.popLocalMap();
                SymBase instanceSym = valueToSym(instance, state);
                state.pushLocalMap();

                List<SymBase> params = state.getLastParam();
                SymBase result = null;
                if(instanceSym instanceof SymString symString){
                    Log.warn("[+] Handle StringBuilder: " + className + "." + methodName);
                    if(methodName.equals("append")){
                        SymBase param =  params.get(0);
                        if(param instanceof SymString str0){
                            result = symString.concat(this.z3Ctx, str0);
                        } else if(param instanceof SymPrim prim0){
                            result = symString.concat(this.z3Ctx, prim0);
                        }
                    } else if(methodName.equals("toString")){
                        result = symString;
                    } 
                } 

                Unit ret = postInvoke(state);
                if (ret instanceof AssignStmt assign) {
                    Value left = assign.getLeftOp();
                    updateValue(left, (SymBase)result, state);
                } else {
                    Log.error("Unsupported Ret Unit type:  " + ret.getClass());
                }
                
                doOne(ret, state, true);
                return;

            }
           
        } else if(methodName.equals("toString")){
            List<SymBase> params = state.getLastParam();
            SymBase result = null;
            int paramSize = params.size();
            if(paramSize == 0){
                result = new SymString(this.z3Ctx, expr.toString());
            } else{
                SymBase param =  params.get(0);
                if(param instanceof SymString str0){
                    result = str0;
                } else if(param instanceof SymPrim prim0){
                    result = SymGen.maketoString(this.z3Ctx, prim0);
                } else{
                    Log.error("[toString] Unsupported param type: " + param.getClass());
                }
            }
            Unit ret = postInvoke(state);
            if (ret instanceof AssignStmt assign) {
                Value left = assign.getLeftOp();
                updateValue(left, (SymBase)result, state);
            } else {
                Log.error("[toString] Unsupported Ret Unit type:  " + ret.getClass());
            }
            
            
            doOne(ret, state, true);
            return;
        }



        boolean isEnforcePermission = EnforcePermissionAPI.isEnforcePermissionAPI(className, methodName);
        boolean isCheckPermission = CheckPermissionAPI.isCheckPermissionAPI(className, methodName);
        //hook
        if (isEnforcePermission || isCheckPermission) {
            Log.warn("[+] Handle Permission API: " + className + "." + methodName);
            SymBase e = HookSymbol.handlePermissionAPI(this.z3Ctx, expr, state);
            if (e != null) {
                //spceial case for enforce
                //throw SecurityException
                if(isEnforcePermission){
                    SimState throwState = state.copy();
                    Unit exceptionHandler = getExceptionHandler(curUnit, throwState, Scene.v().getRefType("java.lang.SecurityException"));
                    if(exceptionHandler != null ){ 
                        throwState.popGlobalConstraint();
                        SymBase permissionExpr = e;
                        Expr permissionValue = this.z3Ctx.mkNot(this.z3Ctx.mkEq(permissionExpr.getExpr(), z3Ctx.mkBV(EnforcePermissionAPI.PERMISSION_GRANTED, 32)));
                        throwState.addGlobalConstraint(permissionValue);
                        doOne(exceptionHandler, throwState, false);
                        // return;
                    } 
                }

                Unit ret = postInvoke(state);
                if (ret instanceof JAssignStmt assign) {
                    Value left = assign.getLeftOp();
                    updateValue(left, e, state);
                } else if(ret instanceof JInvokeStmt invokeStmt){
                    // VOID invoke
                } else {
                    Log.error("Unsupported Ret Unit type: " + ret.getClass());
                }
                doOne(ret, state, true);
                return;
            }
        
        } else if (CheckUidAPI.allClassNames.contains(className) && methodName.equals("getCallingUid")) {
            Log.warn("[+] Find UID API: " + className + "." + methodName);
            SymBase e = HookSymbol.handleUidAPI(this.z3Ctx, expr, state);
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
            SymBase e = HookSymbol.handlePidAPI(this.z3Ctx, expr, state);
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
            SymBase e = HookSymbol.handleAppOpAPI(this.z3Ctx, expr, state);
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
            SymBase e = HookSymbol.handleMyPidAPI(this.z3Ctx, expr, state);
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

        // if(state.callDepth > Config.depthLimit){
        //     Log.info("Call Depth Limit: " + state.callDepth);
        //     Unit ret = postInvoke(state);
        //     doOne(ret, state, true);
        //     return;
        // }
        // if(state.visitedMethods.contains(callee)){
        //     Log.info("Already Visited: " + callee.getName());
        //     Unit ret = postInvoke(state);
        //     doOne(ret, state, true);
        //     return;
        // }
        // handle normal case

        boolean isAccessControl = false;
        List<SymBase> paramList = state.getLastParam();
        for(SymBase p : paramList){
            if(AccessControlUtils.isAccessControlSym(p)){
                isAccessControl = true;
            }
        }

        if( (isAccessControl || ( (enableInterAnalysis && this.CheckMethods.contains(callee) ) )) && hasActiveBody ) {
            state.visitedMethods.add(callee);
            analyzeMethod(callee, state);
            return;
        } else { // DO NOTHING
            Unit ret = postInvoke(state);

            if (ret instanceof AssignStmt assign) {
                Value left = assign.getLeftOp();
                SymBase e = SymGen.makeSymbol(this.z3Ctx,left.getType(),left.toString());
                if(e != null){
                    updateValue(left, e, state);
                }
            } else if(ret instanceof JInvokeStmt invoke){
               
            } else {
                Log.error("Unsupported Ret Unit type: " + ret.getClass());
            }
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
        List<SymBase> params = new ArrayList<>();
        for (int i = 0; i < args.size(); i++) {
            Value arg = args.get(i);
            SymBase e = valueToSym(arg, state);
            params.add(e);
        }
        state.pushCall(curUnit);
        state.pushLocalMap();
        state.pushLocalConstraints();
        state.pushParam(params);
        state.pushCFG();
        state.callDepth++;
    }


    public Unit postInvoke(SimState state) {
        state.callDepth--;
        state.popCFG();
        state.popParam();
        state.popLocalConstraints();
        state.popLocalMap();
        return state.popCall();
    }

    /**
     * 生成约束集合的缓存键
     * 通过将约束转换为字符串并排序来确保相同约束集合有相同的缓存键
     * @param constraints 约束列表
     * @return 缓存键字符串
     */
    private String generateConstraintCacheKey(List<Expr> constraints) {
        if (constraints == null || constraints.isEmpty()) {
            return "EMPTY_CONSTRAINTS";
        }
        
        // 将约束转换为字符串并排序
        List<String> constraintStrings = new ArrayList<>();
        for (Expr constraint : constraints) {
            constraintStrings.add(constraint.toString());
        }
        Collections.sort(constraintStrings);
        
        // 计算排序后字符串的哈希值
        return String.valueOf(constraintStrings.hashCode());
    }

    /**
     * 带缓存的约束可满足性检查
     * 如果相同的约束已经求解过，直接返回缓存的结果
     * @param constraints 约束列表
     * @return 约束是否可满足
     */
    private boolean solveConstraintsSingleWithCache(List<Expr> constraints) {
        // 生成缓存键
        String cacheKey = generateConstraintCacheKey(constraints);
        
        // 检查缓存中是否存在结果
        if (constraintsSingleCache.containsKey(cacheKey)) {
            return constraintsSingleCache.get(cacheKey);
        }
        
        // 缓存中不存在，执行求解
        boolean result = SymbolSolver.solveConstraintsSingle(this.z3Ctx, constraints);
        
        // 将结果存入缓存
        constraintsSingleCache.put(cacheKey, result);
        
        return result;
    }

    public void printSimplifyConstaints(List<Expr> constraints) {

        
        // 生成缓存键
        String cacheKey = generateConstraintCacheKey(constraints);
        
        // 检查是否已经求解过相同的约束
        if (solvedConstraints.contains(cacheKey)) {
            return;
        }
        Log.info("================== [Solve] ========================");

        Context ctx = this.z3Ctx;
        // List<Expr> toSolve = new ArrayList<>();

        // for(Expr e : constraints){
        //     if(AccessControlUtils.isAccessControlExpr(e)){
        //         toSolve.add(e);
        //     }
        // }

        List<String> result = SymbolSolver.solve(ctx, constraints);
        
        // 记录已求解的约束
        solvedConstraints.add(cacheKey);
        
        for(String s : result){
            Log.info(s);
        }
        this.analyzeResult.add(result);

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

    public void close(){
        // 将Z3上下文归还到池中而不是直接关闭
        if (this.z3Ctx != null) {
            this.z3Ctx.close();
        }
        
        // 清理已求解约束集合
        if (this.solvedConstraints != null) {
            this.solvedConstraints.clear();
        }
        // 清理 solveConstraintsSingle 缓存
        if (this.constraintsSingleCache != null) {
            this.constraintsSingleCache.clear();
        }
    }

}
