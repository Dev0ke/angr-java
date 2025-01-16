package module;

import soot.jimple.toolkits.ide.icfg.OnTheFlyJimpleBasedICFG;
import utils.Log;
import soot.*;
import soot.jimple.InvokeExpr;
import soot.jimple.internal.*;
import accessControl.*;
import java.util.*;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;

import init.StaticAPIs;

public class WarperFinder {
    public SootMethod entryMethod;
    public HashSet<SootMethod> CheckMethods;
    public HashSet<SootMethod> visitedMethods;
    public static HashSet<String> permissionClass = CheckPermissionAPI.getAllClassName();

    public WarperFinder(SootMethod entryMethod) {
        this.entryMethod = entryMethod;
        CheckMethods = new HashSet<SootMethod>();
        visitedMethods = new HashSet<SootMethod>();
    }

    public HashSet<SootMethod> runFind() {
        isAccessControlNode(entryMethod);
        return CheckMethods;
    }
public void printPath() {
    // 导入 FastJSON2

    // 用于存储所有路径的列表
    List<List<String>> allPaths = new ArrayList<>();
    // 当前路径栈
    Stack<String> currentPath = new Stack<>();
    // 访问过的方法集合（避免循环）
    Set<SootMethod> visited = new HashSet<>();
    
    // 调用DFS寻找路径
    findPaths(entryMethod, visited, currentPath, allPaths);
    
    // 将路径转换为JSON格式并输出
    String jsonOutput = JSON.toJSONString(allPaths, JSONWriter.Feature.PrettyFormat);
    System.out.println(jsonOutput);
}

private void findPaths(SootMethod method, Set<SootMethod> visited, 
                      Stack<String> currentPath, List<List<String>> allPaths) {
    // 如果当前方法已访问，直接返回以避免循环
    if (visited.contains(method)) {
        return;
    }
    
    // 将当前方法添加到访问集合和当前路径中
    visited.add(method);
    currentPath.push(method.getSignature());
    
    // 如果当前方法是检查点方法，保存当前路径
    if (CheckMethods.contains(method)) {
        allPaths.add(new ArrayList<>(currentPath));
    }
    
    // 如果方法有可执行体，继续遍历其调用
    if (method.hasActiveBody()) {
        Body body = method.getActiveBody();
        for (Unit unit : body.getUnits()) {
            if (unit instanceof JAssignStmt assignStmt && assignStmt.containsInvokeExpr()) {
                processCallExpr(assignStmt.getInvokeExpr(), visited, currentPath, allPaths);
            } else if (unit instanceof JInvokeStmt invokeStmt) {
                processCallExpr(invokeStmt.getInvokeExpr(), visited, currentPath, allPaths);
            }
        }
    }
    
    // 回溯：移除当前方法
    visited.remove(method);
    currentPath.pop();
}

private void processCallExpr(InvokeExpr invokeExpr, Set<SootMethod> visited, 
                           Stack<String> currentPath, List<List<String>> allPaths) {
    SootMethod callee = invokeExpr.getMethod();
    String className = callee.getDeclaringClass().getName();
    
    // 检查是否是访问控制相关的调用
    if (permissionClass.contains(className)) {
        if (!CheckPermissionAPI.getAllMethodNameByClassName(className).contains(callee.getName())) {
            findPaths(callee, visited, currentPath, allPaths);
        }
    } else if (StaticAPIs.shouldAnalyze(className)) {
        findPaths(callee, visited, currentPath, allPaths);
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
                    if (permissionClass.contains(className)) {
                        if (CheckPermissionAPI.getAllMethodNameByClassName(className).contains(callee.getName())) {
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
                    if (permissionClass.contains(className)) {
                        if (CheckPermissionAPI.getAllMethodNameByClassName(className).contains(callee.getName())) {
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
