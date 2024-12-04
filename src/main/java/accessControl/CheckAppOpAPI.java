package accessControl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class CheckAppOpAPI {
    private static final HashMap<String, HashSet<String>> apiMap = new HashMap<>();
    public static Set<String> allClassNames;
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_IGNORED = 1;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_FOREGROUND = 4;

    public static final int[] POSSIBLE_APPOP_CHECK_RESULTS
            = {MODE_ALLOWED, MODE_IGNORED, MODE_ERRORED, MODE_DEFAULT, MODE_FOREGROUND};

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
                //noteOp
                {"android.app.AppOpsManager","noteOp"},
                {"android.app.AppOpsManager","noteProxyOp"},
                {"android.app.AppOpsManager","noteOpNoThrow"},

                {"android.app.AppOpsManager","startOp"},
                {"android.app.AppOpsManager","startOpNoThrow"},
                {"android.app.AppOpsManager","startProxyOpNoThrow"},
                {"android.app.AppOpsManager","startProxyOp"},

                {"android.app.AppOpsManager","checkOpNoThrow"},
                {"android.app.AppOpsManager","checkOp"},
                {"android.app.AppOpsManager","checkAudioOp"},
                {"android.app.AppOpsManager","checkAudioOpNoThrow"},

                {"android.app.AppOpsManager","unsafeCheckOpNoThrow"},
                {"android.app.AppOpsManager","unsafeCheckOp"},
                {"android.app.AppOpsManager","unsafeCheckOpRawNoThrow"},
                {"android.app.AppOpsManager","unsafeCheckOpRaw"},

                {"com.android.server.location.injector.AppOpsHelper","noteOp"}



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
