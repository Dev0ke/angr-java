package init;

import java.util.List;

public class StaticAPIs {

    public static final List<String> EXCLUDE_API_FOR_ANALYSIS = List.of(
            "android.util.*",
            "com.android.internal.app.procstats.ProcessStats", //special bug
            "android.os.EventLogTags",
            "android.os.Parcel",
            "android.os.BaseBundle",
            "android.util.Log",
            "android.util.Slog",
            "java.*",
            "jdk.*",
            "com.android.internal.os.BinderInternal",
            "android.os.Binder",
            "java.lang.Throwable"
    );
}
