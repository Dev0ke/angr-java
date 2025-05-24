package accessControl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.microsoft.z3.Expr;

import Engine.SymBase;

public class AccessControlUtils {
    public static Set<String>  accessControlClassName = getAccessControlClassName();
    public static HashMap<String, HashSet<String>> accessControlAPI = getAllAccessControlAPI();


    public static boolean isAccessControlSym(SymBase sym) {
        if(sym == null) {
            return false;
        }
        Expr expr = sym.getExpr();
        return isAccessControlExpr(expr);
    }
    public static boolean isAccessControlExpr(Expr e) {
        if(e == null) {
            return false;
        }
        String exprStr = e.toString();
        return exprStr.contains("<") && exprStr.contains(">");
    }
    public static boolean isUIDExpr(Expr e) {
        return e.toString().contains("UID");
    }

    public static boolean isPIDExpr(Expr e) {
        return e.toString().contains("PID");
    }
    public static Set<String> getAccessControlClassName(){
        Set<String> accessControlClassName = new HashSet<>();
        accessControlClassName.addAll(EnforcePermissionAPI.getAllClassName());
        accessControlClassName.addAll(CheckAppOpAPI.getAllClassName());
        accessControlClassName.addAll(CheckUidAPI.getAllClassName());
        accessControlClassName.addAll(CheckPidAPI.getAllClassName());
        accessControlClassName.addAll(CheckPackageNameAPI.getAllClassName());
        accessControlClassName.addAll(CheckPermissionAPI.getAllClassName());
        return accessControlClassName;
    }


    public static HashMap<String, HashSet<String>> getAllAccessControlAPI(){
        HashMap<String, HashSet<String>> accessControlAPI = new HashMap<>();
        
        // 使用 merge 操作合并所有 API Map
        EnforcePermissionAPI.apiMap.forEach((className, methods) -> 
            accessControlAPI.merge(className, new HashSet<>(methods), (existing, newSet) -> {
                existing.addAll(newSet);
                return existing;
            })
        );
        
        CheckAppOpAPI.apiMap.forEach((className, methods) -> 
            accessControlAPI.merge(className, new HashSet<>(methods), (existing, newSet) -> {
                existing.addAll(newSet);
                return existing;
            })
        );
        
        CheckUidAPI.apiMap.forEach((className, methods) -> 
            accessControlAPI.merge(className, new HashSet<>(methods), (existing, newSet) -> {
                existing.addAll(newSet);
                return existing;
            })
        );
        
        CheckPidAPI.apiMap.forEach((className, methods) -> 
            accessControlAPI.merge(className, new HashSet<>(methods), (existing, newSet) -> {
                existing.addAll(newSet);
                return existing;
            })
        );
        
        CheckPackageNameAPI.apiMap.forEach((className, methods) -> 
            accessControlAPI.merge(className, new HashSet<>(methods), (existing, newSet) -> {
                existing.addAll(newSet);
                return existing;
            })
        );
        
        CheckPermissionAPI.apiMap.forEach((className, methods) -> 
            accessControlAPI.merge(className, new HashSet<>(methods), (existing, newSet) -> {
                existing.addAll(newSet);
                return existing;
            })
        );

        return accessControlAPI;
    }

    public static boolean isAccessControlClassName(String className){
        return accessControlClassName.contains(className);
    }

    public static boolean isAccessControlAPI(String className, String methodName){
        if (accessControlAPI.containsKey(className)){
            return accessControlAPI.get(className).contains(methodName);
        }
        return false;
    }





}
