package accessControl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class CheckPackageNameAPI {
    public static final HashMap<String, HashSet<String>> apiMap = new HashMap<>();
    public static Set<String> allClassNames;
//    public static final int PERMISSION_GRANTED = 0;
//    public static final int PERMISSION_HARD_DENIED = 2;
//    public static final int PERMISSION_SOFT_DENIED = 1;
//
//    public static final int[] POSSIBLE_PERMISSIONS_CHECK_RESULTS
//            = {PERMISSION_GRANTED, PERMISSION_HARD_DENIED, PERMISSION_SOFT_DENIED};

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
                //pid
                {"android.content.Context", "getPackageName"},
                {"android.content.pm.PackageManager", "getNameForUid"},
                {"android.app.ActivityManagerService", "getPackagesForUid"}

        };
        initialize(apiData);

    }
    public static HashSet<String> getAllAPI(){
        HashSet<String> allAPI = new HashSet<>();
        for (String className : apiMap.keySet()){
            allAPI.addAll(apiMap.get(className));
        }
        return allAPI;
    }

    public static HashSet<String> getAllClassName(){
        return new HashSet<String>(apiMap.keySet());
    }
    public static HashSet<String> getAllMethodNameByClassName(String className){
        return apiMap.getOrDefault(className, new HashSet<>());
    }

    public static boolean isPackageNameAPI(String className, String methodName){
        return apiMap.containsKey(className) && apiMap.get(className).contains(methodName);
    }



}
