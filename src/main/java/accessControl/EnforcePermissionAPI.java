package accessControl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class EnforcePermissionAPI {
    public static final HashMap<String, HashSet<String>> apiMap = new HashMap<>();
    public static Set<String> allClassNames;
    public static final int PERMISSION_GRANTED = 0;
    public static final int PERMISSION_SOFT_DENIED = -1;
    public static final int PERMISSION_HARD_DENIED = 2;
    
    // public static final int[] POSSIBLE_PERMISSIONS_CHECK_RESULTS
    //         = {PERMISSION_GRANTED, PERMISSION_HARD_DENIED, PERMISSION_SOFT_DENIED};
    public static final int[] POSSIBLE_PERMISSIONS_CHECK_RESULTS
            = {PERMISSION_GRANTED, PERMISSION_SOFT_DENIED};          

    public static void initialize(String[][] apiData) {
        for (String[] entry : apiData) {
            String className = entry[0];
            String methodName = entry[1];

            // 获取或创建对应类名的方法集合
            HashSet<String> methods = EnforcePermissionAPI.apiMap.getOrDefault(className, new HashSet<>());
            methods.add(methodName);
            EnforcePermissionAPI.apiMap.put(className, methods);
        }
        allClassNames = getAllClassName();
    }

    //init
    public static void init() {
        String[][] apiData = {
                {"android.content.Context", "enforceCallingUriPermission"},
                {"android.content.Context", "enforceCallingOrSelfUriPermission"},
                {"android.content.Context", "enforceUriPermission"},
                {"android.content.Context", "enforceCallingPermission"},
                {"android.content.Context", "enforceCallingOrSelfPermission"},
                {"android.content.Context", "enforcePermission"},
                {"com.android.server.am.ActivityManagerService","enforceCallingPermission"}
        };
        initialize(apiData);

    }



    public static HashSet<String> getAllAPI(){
        HashSet<String> allAPI = new HashSet<>();
        for (String className : EnforcePermissionAPI.apiMap.keySet()){
            allAPI.addAll(EnforcePermissionAPI.apiMap.get(className));
        }
        return allAPI;
    }

    public static HashSet<String> getAllClassName(){
        return new HashSet<String>(EnforcePermissionAPI.apiMap.keySet());
    }
    public static HashSet<String> getAllMethodNameByClassName(String className){
        return EnforcePermissionAPI.apiMap.getOrDefault(className, new HashSet<>());
    }

    public static boolean isEnforcePermissionAPI(String className, String methodName){
        if (EnforcePermissionAPI.apiMap.containsKey(className)){
            return EnforcePermissionAPI.apiMap.get(className).contains(methodName);
        }
        return false;
    }

}
