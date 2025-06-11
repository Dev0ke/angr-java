package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.concurrent.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Collection;

import accessControl.*;


import entry.APIFinder2;
import entry.APIFinder3;

import module.CheckFinder;
import module.JimpleConverter;

import soot.SootMethod;
import soot.options.Options;

import utils.FirmwareUtils;
import utils.Log;
import utils.ResultExporter;

import init.Config;

import Engine.PathAnalyze;
import module.ClearDetector;


public class Main {

    public static void init() {
        EnforcePermissionAPI.init();
        CheckPermissionAPI.init();
        CheckUserIdAPI.init();
        CheckUidAPI.init();
        CheckPidAPI.init();
        CheckAppOpAPI.init();
        CheckPackageNameAPI.init();
        Log.initLogLevel();
    }

    public static void test_full_api(int APIversion,String inputPath) {
        int processors = Config.threads;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                processors, // 核心线程数
                processors * 2, // 最大线程数
                0L, TimeUnit.SECONDS, // 移除空闲线程存活时间限制
                new LinkedBlockingQueue<>(), // 使用无界队列
                new ThreadPoolExecutor.CallerRunsPolicy() // 队列满时的处理策略
        );

        // 4. 初始化环境
        String androidJarPath = JimpleConverter.getAndroidJarpath(APIversion);
        List<String> allFiles = FirmwareUtils.findAllFiles(inputPath,false);
        FirmwareUtils.removeErrorFile(allFiles);
        
        System.out.println("[-] Total files: " + allFiles.size());
        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv(true);

        APIFinder2 finder2 = new APIFinder2();
        HashMap<String,HashSet<String>> apiList2 = finder2.collectAllClassApis(false);

        APIFinder3 finder3 = new APIFinder3();
        HashMap<String,HashSet<String>> apiList3 = finder3.collectAllClassApis(false);
        
        // merage api
        for(Map.Entry<String,HashSet<String>> entry1 : apiList3.entrySet()){
            String className = entry1.getKey();
            HashSet<String> methodList = entry1.getValue();
            if(apiList2.containsKey(className)){
                apiList2.get(className).addAll(methodList);
            }else{
                apiList2.put(className, methodList);
            }
        }
        System.out.println("[-] Total api: " + apiList2.values().stream().mapToInt(Set::size).sum());
        // 读取已有结果
        // Set<String> existingResults = ResultExporter.readExistingResults(Config.resultPath);
        // Log.info("Found " + existingResults.size() + " existing results");

        // 过滤掉已处理的方法
        // HashMap<String, HashSet<String>> filteredApiList = new HashMap<>();
        // int skippedCount = 0;
        // for (Map.Entry<String, HashSet<String>> entry : apiList2.entrySet()) {
        //     String className = entry.getKey();
        //     HashSet<String> methodList = entry.getValue();
        //     HashSet<String> filteredMethods = new HashSet<>();
            
        //     for (String methodSign : methodList) {
        //         String key = className + "#" + methodSign;
        //         if (!existingResults.contains(key)) {
        //             filteredMethods.add(methodSign);
        //         } else {
        //             skippedCount++;
        //         }
        //     }
            
        //     if (!filteredMethods.isEmpty()) {
        //         filteredApiList.put(className, filteredMethods);
        //     }
        // }
        // Log.info("Skipped " + skippedCount + " already processed methods");
        // Log.info("Remaining methods to process: " + filteredApiList.values().stream().mapToInt(Set::size).sum());

        // write api to apiResultPath
        // format: className#methodsignature
        // catch exception
        try {
            File file = new File(Config.apiResultPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            for (Map.Entry<String, HashSet<String>> entry : apiList2.entrySet()) {
                String className = entry.getKey();
                HashSet<String> methodList = entry.getValue();
                for (String methodSignature : methodList) {
                    fw.write(className + "#" + methodSignature + "\n");
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        // 预加载所有SootMethod对象
        Map<String, SootMethod> preloadedMethods = preloadSootMethods(apiList2, sootEnv);

        // 5. 使用批处理方式处理任务
        ResultExporter resultExporter = new ResultExporter(Config.resultPath);
        List<Future<?>> futures = new ArrayList<>();

        for (Map.Entry<String, HashSet<String>> entry : apiList2.entrySet()) {
            String className = entry.getKey();
            HashSet<String> methodList = entry.getValue();

            // 6. 批量提交任务
            for (String methodSign : methodList) {
                Future<?> future = executor.submit(() -> {
                    try {
                        String key = className + "#" + methodSign;
                        SootMethod m = preloadedMethods.get(key);
                        
                        if (m != null) {
                            processMethod(m, className, methodSign, resultExporter);
                        } else {
                            Log.warn("Skipping unpreloaded method: " + className + "." + methodSign);
                            handleError(className, methodSign, resultExporter, 
                                new RuntimeException("Method not successfully resolved during preloading phase"));
                        }
                    } catch (Exception e) {
                        handleError(className, methodSign, resultExporter, e);
                    }
                });
                futures.add(future);
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Log.error("Executor termination interrupted: " + e.getMessage());
        }
    }

    public static void test_arc_api(int apiVersion, String arcade_api_path, String inputPath) {

        // 1. 预先加载API列表
        HashMap<String, List<String>> apiList = readAPIfromFile(arcade_api_path);

        // 2. 读取已有结果
        Set<String> existingResults = ResultExporter.readExistingResults(Config.resultPath);
        Log.info("Found " + existingResults.size() + " existing results");

        // 3. 优化线程池配置
        int processors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                processors, // 核心线程数
                processors * 2, // 最大线程数
                0L, TimeUnit.SECONDS, // 移除空闲线程存活时间限制
                new LinkedBlockingQueue<>(), // 使用无界队列
                new ThreadPoolExecutor.CallerRunsPolicy() // 队列满时的处理策略
        );

        // 4. 初始化环境
        String androidJarPath = JimpleConverter.getAndroidJarpath(apiVersion);
        List<String> allFiles = FirmwareUtils.findAllFiles(inputPath,false);
        FirmwareUtils.removeErrorFile(allFiles);
        Log.info("[-] Total files: " + allFiles.size());
        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv(false);
        
        // 5. 过滤掉已处理的方法
        HashMap<String, List<String>> filteredApiList = new HashMap<>();
        int skippedCount = 0;
        for (Map.Entry<String, List<String>> entry : apiList.entrySet()) {
            String className = entry.getKey();
            List<String> methodList = entry.getValue();
            List<String> filteredMethods = new ArrayList<>();
            
            for (String methodSign : methodList) {
                String key = className + "#" + methodSign;
                if (!existingResults.contains(key)) {
                    filteredMethods.add(methodSign);
                } else {
                    skippedCount++;
                }
            }
            
            if (!filteredMethods.isEmpty()) {
                filteredApiList.put(className, filteredMethods);
            }
        }
        Log.info("Skipped " + skippedCount + " already processed methods");
        Log.info("Remaining methods to process: " + filteredApiList.values().stream().mapToInt(List::size).sum());
        
        // 6. 预加载所有SootMethod对象
        Map<String, SootMethod> preloadedMethods = preloadSootMethods(filteredApiList, sootEnv);
        
        // 7. 使用批处理方式处理任务
        ResultExporter resultExporter = new ResultExporter(Config.resultPath);
        List<Future<?>> futures = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : filteredApiList.entrySet()) {
            String className = entry.getKey();
            List<String> methodList = entry.getValue();

            // 8. 批量提交任务
            for (String methodSign : methodList) {
                Future<?> future = executor.submit(() -> {
                    try {
                        String key = className + "#" + methodSign;
                        SootMethod m = preloadedMethods.get(key);
                        
                        if (m != null) {
                            processMethod(m, className, methodSign, resultExporter);
                        } else {
                            Log.warn("Skipping unpreloaded method: " + className + "." + methodSign);
                            handleError(className, methodSign, resultExporter, 
                                new RuntimeException("Method not successfully resolved during preloading phase"));
                        }
                    } catch (Exception e) {
                        handleError(className, methodSign, resultExporter, e);
                    } 
                });
                futures.add(future);
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Log.error("Executor termination interrupted: " + e.getMessage());
        }
    }

    // 抽取的辅助方法
    private static void processMethod(SootMethod m, String className, String methodSignature,
            ResultExporter resultExporter) throws TimeoutException {
        long paStartTime = System.currentTimeMillis();
        CheckFinder cf = new CheckFinder(m);
        HashSet<SootMethod> CheckNodes = cf.runFind();
        PathAnalyze pa = new PathAnalyze(m,CheckNodes);
        try {
            pa.startAnalyze();
            Set<List<String>> result = pa.getAnalyzeResult();
            long paEndTime = System.currentTimeMillis();
            resultExporter.writeResult(ResultExporter.CODE_SUCCESS, className, methodSignature, result,
                    paEndTime - paStartTime, "");
        } finally {
            pa.close();
        }
    }

    private static Map<String, SootMethod> preloadSootMethods(Map<String, ? extends Collection<String>> apiList, SootEnv sootEnv) {
        Map<String, SootMethod> preloadedMethods = new HashMap<>();
        int totalMethods = 0;
        int successCount = 0;
        int failureCount = 0;
        
        Log.info("Starting SootMethod preloading...");
        
        for (Map.Entry<String, ? extends Collection<String>> entry : apiList.entrySet()) {
            String className = entry.getKey();
            Collection<String> methodList = entry.getValue();
            
            for (String methodSign : methodList) {
                totalMethods++;
                String key = className + "#" + methodSign;
                
                try {
                    SootMethod m = null;
                    try {
                        // 首先尝试通过签名获取方法
                        m = sootEnv.getMethodBySignature(className, methodSign);
                    } catch (Exception e) {
                        // 如果签名解析失败，尝试通过方法名获取
                        String methodName = methodSign.substring(0, methodSign.indexOf('('));
                        methodName = methodName.substring(methodName.lastIndexOf(' ') + 1);
                        m = sootEnv.getMethodByName(className, methodName);
                    }
                    
                    if (m != null) {
                        preloadedMethods.put(key, m);
                        successCount++;
                    } else {
                        Log.warn("Preload failed: Unable to get method " + className + "." + methodSign);
                        failureCount++;
                    }
                } catch (Exception e) {
                    Log.warn("Preload failed: " + className + "." + methodSign + " - " + e.getMessage());
                    failureCount++;
                }
            }
        }
        
        Log.info("SootMethod preloading completed - Total: " + totalMethods + ", Success: " + successCount + ", Failed: " + failureCount);
        return preloadedMethods;
    }

    private static void find_clearAPI(SootMethod m, String className, String methodSignature,
            ResultExporter resultExporter) throws TimeoutException {
        // long paStartTime = System.currentTimeMillis();
        ClearDetector cf2 = new ClearDetector(m);
        cf2.runFind();
        // long paEndTime = System.currentTimeMillis();
        // resultExporter.writeResult(ResultExporter.CODE_SUCCESS, className, methodSignature, ,
        //         paEndTime - paStartTime, "");
    }


    private static void handleError(String className, String methodName,
            ResultExporter resultExporter, Exception e) {
        // Log.errorStack("[-] Analyse error: ", e);
        resultExporter.writeResult(ResultExporter.CODE_ERROR, className, methodName, null, 0,
                e.toString());
    }



    public static void testByMethodName(String className, String methodName) {

        String androidJarPath = JimpleConverter.getAndroidJarpath(defaultAPIversion);
        List<String> allFiles = FirmwareUtils.findAllFiles(defaultinputPath,false);
        FirmwareUtils.removeErrorFile(allFiles);
        Log.info("[-] Total files: " + allFiles.size());
        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv(false);
        SootMethod m2 = sootEnv.getMethodByName(className, methodName);
        Log.info("[-] " + m2.getSubSignature());
        CheckFinder cf = new CheckFinder(m2);
        HashSet<SootMethod> result = cf.runFind();
        PathAnalyze pa = new PathAnalyze(m2,result);
        pa.startAnalyze();
        
    }

    public static void testOneBySign(String className, String signature) {
        long paStartTime = System.currentTimeMillis();
        String androidJarPath = JimpleConverter.getAndroidJarpath(defaultAPIversion);
        List<String> allFiles = FirmwareUtils.findAllFiles(defaultinputPath,false);
        FirmwareUtils.removeErrorFile(allFiles);
        Log.info("[-] Total files: " + allFiles.size());

        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv(false);

        SootMethod m2 = sootEnv.getMethodBySignature(className, signature);
        CheckFinder cf = new CheckFinder(m2);
        HashSet<SootMethod> result = cf.runFind();
        Log.info("------------------------------------CheckFind-----------------------------------------------");
        for (SootMethod m : result) {
            Log.info("[-] " + m);
        }
        Log.info("--------------------------------------------------------------------------------------------");
        PathAnalyze pa = new PathAnalyze(m2,result);
        pa.startAnalyze();
        Set<List<String>> paresult = pa.getAnalyzeResult();
        for (List<String> path : paresult) {
            Log.info(" - " + path);
        }

        long paEndTime = System.currentTimeMillis();

        // write to result file
        ResultExporter resultExporter = new ResultExporter(Config.resultPath);
        resultExporter.writeResult(ResultExporter.CODE_SUCCESS, className, signature, paresult,
                paEndTime - paStartTime, "");

    
    }

    
    public static void test_find3(int APIversion,String inputPath){
        String androidJarPath = JimpleConverter.getAndroidJarpath(APIversion);
        List<String> allFiles = FirmwareUtils.findAllFiles(inputPath,false);
        FirmwareUtils.removeErrorFile(allFiles);
        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv(false);

        APIFinder3 finder = new APIFinder3();
        HashMap<String,HashSet<String>> apiList1 = finder.collectAllClassApis(false);

        //Log all api
        int classCount = 0;
        int methodCount = 0;
        for (Map.Entry<String, HashSet<String>> entry : apiList1.entrySet()) {
            String className = entry.getKey();
            HashSet<String> methodList = entry.getValue();
            Log.info("------------------------------------ " + className + " -----------------------------------------------");
            classCount++;
            methodCount += methodList.size();
            for (String methodName : methodList) {
                Log.info("--" + methodName);
            }
        }
        Log.info("------------------------------------ Total -----------------------------------------------");
        Log.info("Class count: " + classCount);
        Log.info("Method count: " + methodCount);
    }


    public static void test_find(int APIversion,String inputPath){
        String androidJarPath = JimpleConverter.getAndroidJarpath(APIversion);
        List<String> allFiles = FirmwareUtils.findAllFiles(inputPath,false);
        FirmwareUtils.removeErrorFile(allFiles);
        

        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv(false);

        APIFinder2 finder = new APIFinder2();
        HashMap<String,HashSet<String>> apiList1 = finder.collectAllClassApis(false);

        //Log all api
        int classCount = 0;
        int methodCount = 0;
        for (Map.Entry<String, HashSet<String>> entry : apiList1.entrySet()) {
            String className = entry.getKey();
            HashSet<String> methodList = entry.getValue();
            Log.info("------------------------------------ " + className + " -----------------------------------------------");
            classCount++;
            methodCount += methodList.size();
            for (String methodName : methodList) {
                    Log.info("--" + methodName);
              
            }
        }

        Log.info("------------------------------------ Total -----------------------------------------------");
        Log.info("Class count: " + classCount);
        Log.info("Method count: " + methodCount);
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
                    int lastDotIndex = line.lastIndexOf('#');
                    if (lastDotIndex != -1) {
                        // 获取类名和方法名
                        String className = line.substring(0, lastDotIndex); // 类名
                        String methodName = line.substring(lastDotIndex + 1); // 方法名

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

    public static String aosp_inputPath_6 = "/mnt/hd1/devoke/AOSP6.0.1_r10/out/target/product/mini-emulator-armv7-a-neon/system/";
    public static String aosp_inputPath_7 = "/mnt/hd1/devoke/AOSP7.0/out/target/product/mini-emulator-armv7-a-neon/system/";
    public static int defaultAPIversion = 23;
    public static String defaultinputPath = aosp_inputPath_6;

    public static void main(String[] args) {
        // Config.logLevel = "INFO";
        init();
        // long startTime = System.currentTimeMillis();

        // test_arc_api(Config.AOSP_601_ARCADE, 23, inputPath_6);
        test_arc_api( 23, Config.AOSP_601_ARCADE, aosp_inputPath_6);
        // test_arc_api( 24, Config.AOSP_7_ARCADE,aosp_inputPath_7);
        // test_full_api(24, inputPath_7);
        // test_full_api(23, inputPath_6); 


        // testOneBySign("com.android.server.am.ActivityManagerService", "void updatePersistentConfiguration(android.content.res.Configuration)");
        // test_full_api(33,"/home/devoke/roms/samsung_a34x/");

        // test_arc_api(33,"/home/devoke/decheck/decheck_data/result/api_result.txt", 24, "/home/devoke/roms/xiaomi_babylon");
        // test_arc_api(33, "/home/devoke/decheck/decheck_data/result/api_result.txt","/home/devoke/roms/xiaomi_yuechu");

        // long endTime = System.currentTimeMillis();
        // Log.info("[-] Time cost: " + (endTime - startTime) + "ms");
    }

}