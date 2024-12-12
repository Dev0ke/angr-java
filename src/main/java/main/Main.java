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
import utils.ResultExporter;
import utils.ZipUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void preProcess() {
        Log.debug("preProcess");
        CGgen cg = new CGgen("com.android.server.wm.ActivityTaskManagerService","int checkCallingPermission(java.lang.String)");
        try {
            cg.genCG();
        } catch (Exception e) {
            // get exception String
            String errorString = e.toString();
            // if 'but got:' in exception String
            if (errorString.contains("but got:")) {
                // print 'but got:' in exception String
                String wrongClass = errorString.substring(errorString.indexOf("but got:") + 9);
                Log.error("[-] " + wrongClass);
                rmFilewithPrefix(Config.outputJimplePath, wrongClass);
            } else if (errorString.contains("parsing class ")) {
                // print 'but got:' in exception String
                String wrongClass = errorString.substring(errorString.indexOf("parsing class ") + 14);
                Log.error("[-] " + wrongClass);
                rmFilewithPrefix(Config.outputJimplePath, wrongClass);
            } else {
                // print exception String
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
        int errorCount = 0; // 错误计数
        boolean hasInited = false;

        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CGgen cg = null;
        ResultExporter resultExporter = new ResultExporter(Config.resultPath);
        for (String className : apiList.keySet()) {
            if (className.contains("DeviceIdleController"))
                continue;
            List<String> methodList = apiList.get(className);

            for (String methodSignature : methodList) {
                Log.info("---------------------------- " + methodSignature
                        + "---------------------------------------------");
                count++;
                if (!hasInited || count % 1000 == 0) {
                    cg = new CGgen(className, methodSignature);
                    cg.genCG();
                    hasInited = true;
                }
                try {
                    SootMethod m = cg.getMethodBySignature(className, methodSignature);
                    // 定义任务
                    Callable<Void> task = () -> {
                        long paStartTime = System.currentTimeMillis();
                        PathAnalyze pa = new PathAnalyze(m);
                        pa.startAnalyze();
                        Set<List<String>> result = pa.getAnalyzeResult();
                        long paEndTime = System.currentTimeMillis();
                        resultExporter.writeResult(ResultExporter.CODE_SUCCESS, className, methodSignature, result,
                                paEndTime - paStartTime, "");
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
                    Log.error("[-] Analyse timeout: ");
                    resultExporter.writeResult(ResultExporter.CODE_TIMEOUT, className, methodSignature, null, 0,
                            e.toString());
                } catch (Exception e) {
                    errorCount++; // 错误计数增加
                    // print stacktrace by log4j
                    Log.errorStack("[-] Analyse error: ", e);
                    resultExporter.writeResult(ResultExporter.CODE_ERROR, className, methodSignature, null, 0,
                            e.toString());
                }
            }
            Log.printTime("[+] Status", startTime);
            Log.info("Total API: " + count + " Success: " + success + " Timeout: " + timeoutCount + " Errors: "
                    + errorCount);
        }

        // 关闭线程池
        executor.shutdown();
    }
    public static List<String> findDexfiles(String directoryPath) {
        Queue<File> queue = new LinkedList<>();
        queue.add(new File(directoryPath));
        List<String> dexFiles = new ArrayList<>();
        while (!queue.isEmpty()) {
            File current = queue.poll();

            if (current == null || !current.exists()) {
                continue;
            }

            if (current.isDirectory()) {
                File[] files = current.listFiles();
                if (files != null) {
                    for (File file : files) {
                        queue.add(file); // 将子文件夹添加到队列中
                    }
                }
            } else {
                if (current.getName().endsWith(".dex")) {
                    dexFiles.add(current.getAbsolutePath());  // 将dex文件添加到dexFiles列表
                }
            }
        }
        return dexFiles;
    }
    public static List<String> convertJar(String jarPath) {
        String tempPath = Config.tempPath + File.separator + jarPath.substring(jarPath.lastIndexOf("/"));
        try {
            ZipUtils.unzip(jarPath, tempPath);
        } catch (IOException e) {
            Log.error("[-] Failed to unzip jar file: " + jarPath);
            e.printStackTrace();
            return null;
        }
        return findDexfiles(tempPath);
    }

    public static void multi2() {
        long startTime = System.currentTimeMillis();
        HashMap<String, List<String>> apiList = readAPIfromFile(Config.apiListPath);
        int count = 0;
        int success = 0;
        int timeoutCount = 0; // 超时计数
        int errorCount = 0; // 错误计数


        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        int APIversion = 25;
        String androidJarPath = JimpleConverter.getAndroidJarpath(APIversion);
        String inputJarPath = "/public/AOSP25/out/target/product/generic_arm64/system/framework/services.jar";
        List<String> dexFiles = convertJar(inputJarPath);
        SootEnv sootEnv = new SootEnv(androidJarPath, dexFiles);
        sootEnv.initEnv();

        ResultExporter resultExporter = new ResultExporter(Config.resultPath);
        for (String className : apiList.keySet()) {

            List<String> methodList = apiList.get(className);
            for (String methodName : methodList) {
                Log.info("---------------------------- " + methodName
                        + "---------------------------------------------");
                count++;
          
                try {
                    SootMethod m = sootEnv.geMethodByName(className, methodName);
                    // 定义任务
                    Callable<Void> task = () -> {
                        long paStartTime = System.currentTimeMillis();
                        PathAnalyze pa = new PathAnalyze(m);
                        pa.startAnalyze();
                        Set<List<String>> result = pa.getAnalyzeResult();
                        long paEndTime = System.currentTimeMillis();
                        resultExporter.writeResult(ResultExporter.CODE_SUCCESS, className, methodName, result,
                                paEndTime - paStartTime, "");
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
                    Log.error("[-] Analyse timeout: ");
                    resultExporter.writeResult(ResultExporter.CODE_TIMEOUT, className, methodName, null, 0,
                            e.toString());
                } catch (Exception e) {
                    errorCount++; // 错误计数增加
                    // print stacktrace by log4j
                    Log.errorStack("[-] Analyse error: ", e);
                    resultExporter.writeResult(ResultExporter.CODE_ERROR, className, methodName, null, 0,
                            e.toString());
                }
            }
            Log.printTime("[+] Status", startTime);
            Log.info("Total API: " + count + " Success: " + success + " Timeout: " + timeoutCount + " Errors: "
                    + errorCount);
        }

        // 关闭线程池
        executor.shutdown();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        init();
        // preProcess();
        // multi();
        // testOne("com.android.server.pm.dex.ArtManagerService","isRuntimeProfilingEnabled");
        // testOne("com.android.server.BinaryTransparencyService$UpdateMeasurementsJobService","onStartJob");
        // testOne("com.android.server.audio.AudioService","forceRemoteSubmixFullVolume");
        multi2();    
        // end
        // ==========================================================================================================

    }

    public static void testOne(String className, String methodName) {
        int APIversion = 25;
        String androidJarPath = JimpleConverter.getAndroidJarpath(APIversion);
        String inputJarPath = "/public/AOSP25/out/target/product/generic_arm64/system/framework/services.jar";
        List<String> dexFiles = convertJar(inputJarPath);
        SootEnv sootEnv = new SootEnv(androidJarPath, dexFiles);
        sootEnv.initEnv();
        SootMethod m = sootEnv.geMethodByName(className, methodName);        
        PathAnalyze pa = new PathAnalyze(m);
        pa.startAnalyze();
    }

    public static HashMap<String, List<String>> readAPIfromFile(String path) {
        File file = new File(path);
        HashMap<String, List<String>> apiMap = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    // 分割类名和方法名，最后一个"."为类和方法的分隔符
                    int lastDotIndex = line.lastIndexOf(' ');
                    if (lastDotIndex != -1) {
                        // 获取类名和方法名
                        String className = line.substring(0, lastDotIndex);  // 类名
                        String methodName = line.substring(lastDotIndex + 1);  // 方法名

                        // 确保类名存在于map中，如果没有则创建
                        apiMap.computeIfAbsent(className, k -> new ArrayList<>()).add(methodName);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apiMap;
    }

    public static void rmFilewithPrefix(String path, String prefix) {
        java.io.File file = new java.io.File(path);
        java.io.File[] files = file.listFiles();
        for (java.io.File f : files) {
            if (f.getName().startsWith(prefix)) {
                f.delete();
            }
        }

    }

}