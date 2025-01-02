package accessControl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.microsoft.z3.Expr;

public class AccessControlUtils {
    public static Set<String>  accessControlClassName = getAccessControlClassName();
    public static HashMap<String, HashSet<String>> accessControlAPI = getAllAccessControlAPI();


    public static boolean isAccessControlExpr(Expr e) {
        return e.toString().contains("TYPE_");
    }

    public static boolean isUIDExpr(Expr e) {
        return e.toString().contains("TYPE_UID");
    }

    public static boolean isPIDExpr(Expr e) {
        return e.toString().contains("TYPE_PID");
    }
    public static Set<String> getAccessControlClassName(){
        Set<String> accessControlClassName = new HashSet<>();
        accessControlClassName.addAll(CheckPermissionAPI.getAllClassName());
        accessControlClassName.addAll(CheckAppOpAPI.getAllClassName());
        accessControlClassName.addAll(CheckUidAPI.getAllClassName());
        accessControlClassName.addAll(CheckPidAPI.getAllClassName());
        accessControlClassName.addAll(CheckPackageNameAPI.getAllClassName());
        return accessControlClassName;
    }


    public static HashMap<String, HashSet<String>> getAllAccessControlAPI(){
        HashMap<String, HashSet<String>> accessControlAPI = new HashMap<>();
        accessControlAPI.putAll(CheckPermissionAPI.apiMap);
        accessControlAPI.putAll(CheckAppOpAPI.apiMap);
        accessControlAPI.putAll(CheckUidAPI.apiMap);
        accessControlAPI.putAll(CheckPidAPI.apiMap);
        accessControlAPI.putAll(CheckPackageNameAPI.apiMap);
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
