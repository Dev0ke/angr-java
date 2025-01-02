package init;

import java.util.Set;

public class StaticAPIs {

    public static final Set<String> EXCLUDE_API_FOR_ANALYSIS = Set.of(
            "android.util.*",
            "com.android.internal.app.procstats.ProcessStats", //special bug
            "android.os.EventLogTags",
            "android.os.Parcel",
            "android.os.BaseBundle",
            "android.os.Handler",
            "android.util.Log",
            "android.util.Slog",
            "java.*",
            "jdk.*",
            "com.android.internal.os.BinderInternal",
            "android.os.Binder",
            "java.lang.Throwable"
    );


    public static final Set<String> ANALYZE_CLASS_SET = Set.of(
    "android.os.UserHandle"
    );


    public static boolean shouldAnalyze(String className){
       for (String excludeAPI : EXCLUDE_API_FOR_ANALYSIS) {
            if (className.startsWith(excludeAPI.replace("*", ""))) {
                return false;
            }
        }
        return true;
    }
}
