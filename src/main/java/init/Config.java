package init;

public class Config {

    // Basic Config
    public static int threads = 64;
    public static boolean useExistJimple = true;

    // Analysis Config
    public static boolean enableLazySolve = false;
    public static boolean enableInterAnalysis = false;
    public static int branchLimit = 64;

    // Path Config
    public static String outputJimplePath = "E:\\decheck_data\\output\\jimple";
    public static String androidJarPath = "E:\\decheck_data\\android-platforms-master";
    public static String testInput = "E:\\decheck_data\\input\\classes";

//    public static String testInput2 = "E:\\Onedrive_pre\\OneDrive\\Research\\decheck\\target\\test-classes";
    public static String testInput2= "D:\\OneDrivePersonal\\OneDrive\\Research\\decheck\\target\\test-classes";

    public static String inputFirmwarePath = "E:\\decheck_data\\system";
    public static String tempPath = "E:\\decheck_data\\temp";

}
