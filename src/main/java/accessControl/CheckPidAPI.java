package accessControl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class CheckPidAPI {
    private static final HashMap<String, HashSet<String>> apiMap = new HashMap<>();
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
                //pid
                {"android.os.Binder","getCallingPid"},



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
