package main;

import accessControl.CheckAppOpAPI;
import accessControl.CheckPermissionAPI;
import accessControl.CheckPidAPI;
import accessControl.CheckUidAPI;
import module.APIFinder;
import module.PathAnalyze;
import soot.SootMethod;
import utils.Log;
import init.Config;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;


import static utils.Log.printTime;

public class Main {
    
    public static void preProcess() {

        Log.debug("preProcess");
        CGgen cg = new CGgen("com.android.server.audio.AudioService","setEncodedSurroundMode");
        try {
            cg.genCG();
        } catch (Exception e) {
            //get exception String
            String errorString = e.toString();
            //if 'but got:' in exception String
            if (errorString.contains("but got:")) {
                //print 'but got:' in exception String
                String wrongClass = errorString.substring(errorString.indexOf("but got:")+9);
                Log.error("[-] " + wrongClass);
                rmFilewithPrefix(Config.outputJimplePath,wrongClass);
            } else {
                //print exception String
                Log.error("[-] " + errorString);
            }

        }
        cg.traverseCG();
    }

    public static void init() {
        CheckPermissionAPI.init();
        CheckUidAPI.init();
        CheckPidAPI.init();
        CheckAppOpAPI.init();
    }



    public static void multi() {
        long startTime = System.currentTimeMillis();
        HashMap<String, List<String>> apiList = APIFinder.findAPI();
        int count = 0;
        int success = 0;
        int timeoutCount = 0; // 超时计数
        int errorCount = 0;   // 错误计数
        
        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CGgen cg = new CGgen("com.android.server.devicepolicy.NonRequiredPackageDeleteObserver","void packageDeleted(java.lang.String,int)");
        cg.genCG();
        for (String className : apiList.keySet()) {
            if(className.contains("DeviceIdleController"))
                continue;
            List<String> methodList = apiList.get(className);

            for (String methodSignature : methodList) {
                Log.info("---------------------------- " +  methodSignature + "---------------------------------------------");
                count++;
  
                try {
                    SootMethod m = cg.getMethodBySignature(className, methodSignature);
                    // 定义任务
                    Callable<Void> task = () -> {
                        long paStartTime = System.currentTimeMillis();
                        PathAnalyze pa = new PathAnalyze(m);
                        pa.startAnalyze();
                        Set<List<String>> result = pa.getResult();
                        long paEndTime = System.currentTimeMillis();
                        writeResult2File(className,methodSignature, result,paEndTime-paStartTime);
                        return null;
                    };
    
                    // 提交任务并设置超时时间（例如5秒）
                    Future<Void> future = executor.submit(task);
                    try {
                        future.get(Config.timeout, TimeUnit.SECONDS);
                    } catch (TimeoutException e) {
                        future.cancel(true); // Cancel the task
                        throw e;
                    }
                    success++;
                } catch (TimeoutException e) {
                    timeoutCount++; // 超时计数增加
                    Log.error("[-] Analyse timeout: " );
                } catch (Exception e) {
                    errorCount++; // 错误计数增加
                    //print stacktrace by log4j
                    Log.errorStack("[-] Analyse error: " ,e);
                }
            }
            printTime("[+] Status",startTime);
            Log.info("Total API: " + count + " Success: " + success + " Timeout: " + timeoutCount + " Errors: " + errorCount);
        }
        printTime("[+] Status",startTime);
        Log.info("Total API: " + count + " Success: " + success + " Timeout: " + timeoutCount + " Errors: " + errorCount);
    
        // 关闭线程池
        executor.shutdown();
    }
    

    public static void writeResult2File(String className, String signature, Set<List<String>> result,long time) {
        // 检查并确保目标目录存在
        java.io.File file = new java.io.File(Config.resultPath);
        java.io.File parentDir = file.getParentFile();
    
        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                System.err.println("Failed to create directory: " + parentDir.getAbsolutePath());
                return; // 如果目录创建失败，直接返回
            }
        }
    
        // 使用 try-with-resources 确保 FileWriter 资源安全关闭
        try (java.io.FileWriter fw = new java.io.FileWriter(file, true)) {
            fw.write("   "+ className + "   " + signature + "\n================" + time + "\n");
            for (List<String> path : result) {
                for (String expr : path) {
                    fw.write("      " + expr.toString() + " \n");
                }
            }
            fw.write("\n------------------\n");
        } catch (java.io.IOException e) {
            System.err.println("Failed to write to file: " + file.getAbsolutePath());
            e.printStackTrace();
        }
    }
    
    

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        init();


//        CGgen cg = new CGgen("com.android.server.pm.UserManagerService","setUserRestriction");
//        printTime("GenCG",startTime);
//        PathAnalyze pa = new PathAnalyze(cg.getMethodByName("com.android.server.audio.AudioService","forceVolumeControlStream")); //TODO FIX
       multi();
//        testOne("com.android.server.pm.dex.ArtManagerService","isRuntimeProfilingEnabled");
//        testOne("com.android.server.BinaryTransparencyService$UpdateMeasurementsJobService","onStartJob");
        // testOne("com.android.server.MountService","int getPasswordType()");


        //end ==========================================================================================================

    }



    public static void testOne(String className,String methodName){
        CGgen cg = new CGgen(className,methodName);
        cg.genCG();
        PathAnalyze pa = new PathAnalyze(cg.getMethodBySignature(className,methodName));
        pa.startAnalyze();
    }

    public static void rmFilewithPrefix(String path ,String prefix){
        java.io.File file = new java.io.File(path);
        java.io.File[] files = file.listFiles();
        for (java.io.File f: files){
            if(f.getName().startsWith(prefix)){
                f.delete();
            }
        }

    }


}