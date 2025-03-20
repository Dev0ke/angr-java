package module;

import soot.jimple.toolkits.ide.icfg.OnTheFlyJimpleBasedICFG;
import utils.Log;
import soot.*;
import soot.jimple.internal.*;
import accessControl.*;
import java.util.*;
import init.StaticAPIs;

public class ClearDetector {
    public SootMethod entryMethod;
    public HashSet<SootMethod> CheckMethods;
    public HashSet<SootMethod> visitedMethods;
    public boolean isClear;
    public boolean isFind;
    
    public ClearDetector(SootMethod entryMethod) {
        this.entryMethod = entryMethod;
        CheckMethods = new HashSet<SootMethod>();
        visitedMethods = new HashSet<SootMethod>();
    }

    public void runFind() {
        List<SootMethod> callStack = new ArrayList<>();
        callStack.add(entryMethod);
        FindClearNode(entryMethod, callStack);
    }


    public boolean isClearNode(SootMethod method) {
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        if(className.equals("android.os.Binder")){
            if(methodName.equals("clearCallingIdentity")){
                return true;
            }
        }
        return false;
    }

    public boolean isRestoreNode(SootMethod method) {
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        if(className.equals("android.os.Binder")){
            if(methodName.equals("restoreCallingIdentity")){
                return true;
            }
        }
        return false;
    }


    public void FindClearNode(SootMethod method, List<SootMethod> callStack) {
        OnTheFlyJimpleBasedICFG cfg = new OnTheFlyJimpleBasedICFG(method);              
        if (method.hasActiveBody()) { 
            Body body = method.getActiveBody();
            UnitPatchingChain units = body.getUnits();
            for (Unit unit :units) {
                if(isFind){
                    return;
                }
                SootMethod callee = null;
                if (unit instanceof JAssignStmt assignStmt) {
                    if (assignStmt.containsInvokeExpr())
                        callee = assignStmt.getInvokeExpr().getMethod();
                } else if (unit instanceof JInvokeStmt stmt)
                    callee = stmt.getInvokeExpr().getMethod();

                if(callee != null){
                    if(isClearNode(callee)){
                        isClear = true;
                        // Log.info("Find Clear Node: " + callee.toString());
                        continue;
                    }else if(isRestoreNode(callee)){
                        isClear = false;
                        continue;
                    } 
                    
                    String className = callee.getDeclaringClass().getName();
                    String methodName = callee.getName();
                    if (AccessControlUtils.isAccessControlClassName(className)) {
                        if (AccessControlUtils.isAccessControlAPI(className, methodName)) {
                            if(isClear){
                                // 输出完整调用栈
                                StringBuilder stackTrace = new StringBuilder();
                                for (int i = 0; i < callStack.size(); i++) {
                                    stackTrace.append(callStack.get(i).toString());
                                    if (i < callStack.size() - 1) {
                                        stackTrace.append("\n -> ");
                                    }
                                }
                                stackTrace.append("\n -> ").append(className).append(".").append(methodName).append("\n");
                                Log.info(stackTrace.toString());
                                // throw new RuntimeException("1");
                                isFind = true;
                            } 
                            continue;
                        }
                    }
                    if(visitedMethods.contains(callee)){
                        continue;
                    }
                    if (StaticAPIs.shouldAnalyze(callee.getDeclaringClass().getName())) {
                        // Log.info(callee.toString());
                        visitedMethods.add(callee);
                        List<SootMethod> newCallStack = new ArrayList<>(callStack);
                        newCallStack.add(callee);
                        FindClearNode(callee, newCallStack);
                        if(isFind){
                            return;
                        }
                    }
                }
            }
        }
    }


    public boolean isAccessControlNode(SootMethod method) {
        Boolean isAccessControl = false;
        OnTheFlyJimpleBasedICFG cfg = new OnTheFlyJimpleBasedICFG(method);              
        if (method.hasActiveBody()) {
            Body body = method.getActiveBody();
            List<Unit> units = new ArrayList<Unit>();
            for (Unit unit : body.getUnits()) {
                if (unit instanceof JAssignStmt assignStmt) {
                    if (assignStmt.containsInvokeExpr())
                        units.add(unit);
                } else if (unit instanceof JInvokeStmt)
                    units.add(unit);
            }

            Stack<SootMethod> stack = new Stack<SootMethod>();
            Iterator<Unit> iterator = units.iterator();
            while (iterator.hasNext()) {
                Unit unit = iterator.next();
                if (unit instanceof JAssignStmt assignStmt) {
                    SootMethod callee = assignStmt.getInvokeExpr().getMethod();
                    String className = callee.getDeclaringClass().getName();
                    if (AccessControlUtils.isAccessControlClassName(className)) {
                        if (AccessControlUtils.isAccessControlAPI(className, callee.getName())) {
                            CheckMethods.add(method);
                            isAccessControl = true;
                        } else {
                            stack.push(callee);
                        }
                    } else {
                        stack.push(callee);
                    }

                } else if (unit instanceof JInvokeStmt invokeStmt) {
                    SootMethod callee = invokeStmt.getInvokeExpr().getMethod();
                    String className = callee.getDeclaringClass().getName();
                    if (AccessControlUtils.isAccessControlClassName(className)) {
                        if (AccessControlUtils.isAccessControlAPI(className, callee.getName())) {
                            CheckMethods.add(method);
                            isAccessControl = true;
                        } else {
                            stack.push(callee);
                        }
                    } else {
                        stack.push(callee);
                    }
                }
            }

            // analyze remain call
            while(!stack.isEmpty()){
                SootMethod callee = stack.pop();
                if(CheckMethods.contains(callee)){
                    isAccessControl = true;
                    continue;
                }

                if(visitedMethods.contains(callee)){
                    continue;
                }
                if (StaticAPIs.shouldAnalyze(callee.getDeclaringClass().getName())) {
                    Log.info(callee.toString());
                    visitedMethods.add(callee);
                    if(isAccessControlNode(callee)){
                        CheckMethods.add(method);   
                        isAccessControl = true;
                    }
                }
                
            }
        }
        return isAccessControl;
    }

}
