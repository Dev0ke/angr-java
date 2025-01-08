package init;

public class Config {

    // Basic Config
    public static int threads = 256;
    public static boolean useExistJimple = true;
    public static String logLevel = "ERROR";
    // Analysis Config
    public static boolean enableLazySolve = false;
    public static boolean enableInterAnalysis = true;
    public static boolean enableParamSymbolize = false;
    public static int branchLimit = 4;
    public static int timeout = 3000000;

    // Path Config
    public static String outputJimplePath = "/home/devoke/decheck/decheck_data/output/jimple";
    public static String androidJarPath = "/home/devoke/decheck/decheck_data/android-platforms-master";
    public static String testInput = "/home/devoke/decheck/decheck_data/input/classes";
    public static String resultPath = "/home/devoke/decheck/decheck_data/result/result.txt";
    public static String testInput2= "/home/devoke/decheck/decheck_data/target/test-classes";

    public static String inputFirmwarePath = "/home/devoke/decheck/decheck_data/system";
    public static String tempPath = "/home/devoke/decheck/decheck_data/temp";
    public static String apiListPath = "/home/devoke/decheck/decheck_data/test_api_list/arcade_api.txt";
    public static String apiListPath2 = "/home/devoke/decheck/decheck_data/test_api_list/arcade_api2.txt";
}
