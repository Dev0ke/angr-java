package accessControl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class CheckPermissionAPI {
    private static final HashMap<String, HashSet<String>> apiMap = new HashMap<>();
    public static Set<String> allClassNames;
    public static final int PERMISSION_GRANTED = 0;
    public static final int PERMISSION_HARD_DENIED = 2;
    public static final int PERMISSION_SOFT_DENIED = 1;

    public static final int[] POSSIBLE_PERMISSIONS_CHECK_RESULTS
            = {PERMISSION_GRANTED, PERMISSION_HARD_DENIED, PERMISSION_SOFT_DENIED};

    public static void initialize(String[][] apiData) {
        for (String[] entry : apiData) {
            String className = entry[0];
            String methodName = entry[1];

            // 获取或创建对应类名的方法集合
            HashSet<String> methods = apiMap.getOrDefault(className, new HashSet<>());
            methods.add(methodName);
            apiMap.put(className, methods);
        }
        allClassNames = getAllClassName();
    }

    //init
    public static void init() {
        String[][] apiData = {
                //Activity Manager Permission
                {"android.app.ActivityManager", "checkComponentPermission"},
                {"android.app.ActivityManager", "checkUidPermission"},

                //Context Uri Permission
                {"android.content.Context", "enforceCallingUriPermission"},
                {"android.content.Context", "enforceCallingOrSelfUriPermission"},
                {"android.content.Context", "enforceUriPermission"},
                {"android.content.Context", "checkCallingUriPermission"},
                {"android.content.Context", "checkCallingOrSelfUriPermission"},
                {"android.content.Context", "checkCallingUriPermissions"},
                {"android.content.Context", "checkUriPermission"},
                {"android.content.Context", "checkUriPermissions"},
                {"android.content.Context", "checkContentUriPermissionFull"},
                {"android.content.Context", "checkCallingOrSelfUriPermissions"},

                //Context Permission
                {"android.content.Context", "enforceCallingPermission"},
                {"android.content.Context", "enforceCallingOrSelfPermission"},
                {"android.content.Context", "checkCallingPermission"},
                {"android.content.Context", "checkCallingOrSelfPermission"},
                {"android.content.Context", "checkPermission"},
                {"android.content.Context", "checkSelfPermission"},
                {"android.content.Context", "enforcePermission"},

                // test
//                {"testCheckAPI","enforceP1"},
//                {"testCheckAPI","checkP2"},



        };
        initialize(apiData);

    }

    public static HashSet<String> getAllClassName(){
        return new HashSet<String>(apiMap.keySet());
    }
    public static HashSet<String> getAllMethodNameByClassName(String className){
        return apiMap.getOrDefault(className, new HashSet<>());
    }



}
