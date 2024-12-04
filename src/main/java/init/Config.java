package init;

public class Config {

    // Basic Config
    public static int threads = 128;
    public static boolean useExistJimple = true;

    // Analysis Config
    public static boolean enableLazySolve = false;
    public static boolean enableInterAnalysis = false;
    public static int branchLimit = 4;
    public static int timeout = 60;

    // Path Config
    public static String outputJimplePath = "/home/devoke/decheck/decheck_data/output/jimple";
    public static String androidJarPath = "/home/devoke/decheck/decheck_data/android-platforms-master";
    public static String testInput = "/home/devoke/decheck/decheck_data/input/classes";
    public static String resultPath = "/home/devoke/decheck/decheck_data/result/result.txt";
    public static String testInput2= "/home/devoke/decheck/decheck_data/target/test-classes";

    public static String inputFirmwarePath = "/home/devoke/decheck/decheck_data/system";
    public static String tempPath = "/home/devoke/decheck/decheck_data/temp";

}
