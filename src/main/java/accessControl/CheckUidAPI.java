package accessControl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class CheckUidAPI {
    public static final HashMap<String, HashSet<String>> apiMap = new HashMap<>();
    public static Set<String> allClassNames;

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
                //uid
                {"android.os.Binder","getCallingUid"},
                // {"android.os.UserHandle","getCallingUserId"}



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



}
