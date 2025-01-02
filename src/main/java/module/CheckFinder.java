package module;

import soot.jimple.toolkits.ide.icfg.OnTheFlyJimpleBasedICFG;
import soot.toolkits.graph.DirectedGraph;
import soot.*;
import soot.jimple.internal.*;
import accessControl.*;
import java.util.*;
import init.StaticAPIs;

public class CheckFinder {
    public SootMethod entryMethod;
    public HashSet<SootMethod> CheckMethods;

    public CheckFinder(SootMethod entryMethod) {
        this.entryMethod = entryMethod;
        CheckMethods = new HashSet<SootMethod>();
    }

    public HashSet<SootMethod> runFind() {
        isAccessControlNode(entryMethod);
        return CheckMethods;
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

                if (StaticAPIs.shouldAnalyze(callee.getDeclaringClass().getName()) &&   isAccessControlNode(callee)) {
                    CheckMethods.add(method);   
                    isAccessControl = true;
                }
                
            }
        }
        return isAccessControl;
    }

}
