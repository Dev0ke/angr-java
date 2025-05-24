package main;

import accessControl.CheckAppOpAPI;
import accessControl.EnforcePermissionAPI;
import entry.APIFinder;
import entry.APIFinder2;
import entry.APIFinder3;
import accessControl.CheckPidAPI;
import accessControl.CheckUidAPI;
import module.CheckFinder;
import module.JimpleConverter;
import module.PathAnalyze;

import soot.SootMethod;
import soot.options.Options;

import utils.FirmwareUtils;
import utils.Log;
import init.Config;
import utils.ResultExporter;


import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import java.util.List;
import java.util.concurrent.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import module.ClearDetector;
import accessControl.CheckPermissionAPI;
public class Main {

    public static void init() {
        EnforcePermissionAPI.init();
        CheckPermissionAPI.init();
        CheckUidAPI.init();
        CheckPidAPI.init();
        CheckAppOpAPI.init();
        Log.initLogLevel();
    }

    public static void test_full_api(int APIversion,String inputPath) {

        // 1. 预先加载API列表
        // HashMap<String, List<String>> apiList = readAPIfromFile(Config.AOSP_601_ARCADE);

        // 2. 使用计数器对象替代原始类型，避免并发问题
        AtomicInteger count = new AtomicInteger(0);
        AtomicInteger success = new AtomicInteger(0);
        AtomicInteger timeoutCount = new AtomicInteger(0);
        AtomicInteger errorCount = new AtomicInteger(0);

        
        // 3. 优化线程池配置
        int processors = Config.threads;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                processors, // 核心线程数
                processors * 2, // 最大线程数
                60L, TimeUnit.SECONDS, // 空闲线程存活时间
                new LinkedBlockingQueue<>(1000), // 使用有界队列
                new ThreadPoolExecutor.CallerRunsPolicy() // 队列满时的处理策略
        );

        // 4. 初始化环境

        String androidJarPath = JimpleConverter.getAndroidJarpath(APIversion);
        List<String> allFiles = FirmwareUtils.findAllFiles(inputPath);
        FirmwareUtils.removeErrorFile(allFiles);
        

        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv();

        // HashMap<String,List<String>> apiList2 = APIFinder.findServiceAPI();
        // HashMap<String,List<String>> apiList1 = APIFinder.findProviderAPI();
        // apiList2.putAll(apiList1);

        APIFinder3 finder = new APIFinder3();
        HashMap<String,HashSet<String>> apiList2 = finder.collectAllClassApis(false);


        APIFinder2 finder2 = new APIFinder2();
        HashMap<String,HashSet<String>> apiList3 = finder2.collectAllClassApis(true);
        
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

        // System.exit(0);

        // 5. 使用批处理方式处理任务
        ResultExporter resultExporter = new ResultExporter(Config.resultPath);
        List<Future<?>> futures = new ArrayList<>();

        for (Map.Entry<String, HashSet<String>> entry : apiList2.entrySet()) {
            String className = entry.getKey();
            HashSet<String> methodList = entry.getValue();

            // 6. 批量提交任务
            for (String methodSign : methodList) {
                // List<String> EXmethodSigns = apiList2.get(className);
                // if(EXmethodSigns != null && EXmethodSigns.contains(methodSign))
                //     continue;
                count.incrementAndGet();
                Future<?> future = executor.submit(() -> {
                    try {
                        SootMethod m = null;
                        try {
                            m = sootEnv.getMethodBySignature(className, methodSign);
                        } catch (Exception e) {
                            //convert sign to method name
                            String methodName = methodSign.substring(0, methodSign.indexOf('('));
                            methodName = methodName.substring(methodName.lastIndexOf(' ') + 1);
                            m = sootEnv.getMethodByName(className, methodName);
                        }
                        processMethod(m, className, methodSign, resultExporter, success);
                    } catch (TimeoutException e) {
                        timeoutCount.incrementAndGet();
                        handleTimeout(className, methodSign, resultExporter, e);
                    } catch (Exception e) {
                        errorCount.incrementAndGet();
                        handleError(className, methodSign, resultExporter, e);
                    }
                });
                futures.add(future);

            }
        }

        // 8. 等待所有任务完成
        for (Future<?> future : futures) {
            try {
                future.get(Config.timeout, TimeUnit.SECONDS);
            } catch (Exception e) {
                Log.error("Task completion error: " + e.getMessage());
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Log.error("Executor termination interrupted: " + e.getMessage());
        }

    }

    public static void test_arc_api(String arcade_api_path,int APIversion,String inputPath) {
  
        // 1. 预先加载API列表
        HashMap<String, List<String>> apiList = readAPIfromFile(arcade_api_path);

        // 2. 使用计数器对象替代原始类型，避免并发问题
        AtomicInteger count = new AtomicInteger(0);
        AtomicInteger success = new AtomicInteger(0);
        AtomicInteger timeoutCount = new AtomicInteger(0);
        AtomicInteger errorCount = new AtomicInteger(0);

        // 3. 优化线程池配置
        int processors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                processors, // 核心线程数
                processors * 2, // 最大线程数
                60L, TimeUnit.SECONDS, // 空闲线程存活时间
                new LinkedBlockingQueue<>(1000), // 使用有界队列
                new ThreadPoolExecutor.CallerRunsPolicy() // 队列满时的处理策略
        );

        // 4. 初始化环境

        String androidJarPath = JimpleConverter.getAndroidJarpath(APIversion);
        List<String> allFiles = FirmwareUtils.findAllFiles(inputPath);
        FirmwareUtils.removeErrorFile(allFiles);
        Log.info("[-] Total files: " + allFiles.size());
        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv();
        // 5. 使用批处理方式处理任务
        ResultExporter resultExporter = new ResultExporter(Config.resultPath);
        List<Future<?>> futures = new ArrayList<>();


        for (Map.Entry<String, List<String>> entry : apiList.entrySet()) {
            String className = entry.getKey();
            List<String> methodList = entry.getValue();

            // 6. 批量提交任务
            for (String methodSign : methodList) {
                count.incrementAndGet();
                Future<?> future = executor.submit(() -> {
                    try {
                        SootMethod m = null;
                        try {
                            m = sootEnv.getMethodBySignature(className, methodSign);
                        } catch (Exception e) {
                            //convert sign to method name
                            String methodName = methodSign.substring(0, methodSign.indexOf('('));
                            methodName = methodName.substring(methodName.lastIndexOf(' ') + 1);
                            m = sootEnv.getMethodByName(className, methodName);
                        }
                        processMethod(m, className, methodSign, resultExporter, success);
                    } catch (TimeoutException e) {
                        timeoutCount.incrementAndGet();
                        handleTimeout(className, methodSign, resultExporter, e);
                    } catch (Exception e) {
                        errorCount.incrementAndGet();
                        handleError(className, methodSign, resultExporter, e);
                    } 
                });
                futures.add(future);

            }
        }

        // 8. 等待所有任务完成
        for (Future<?> future : futures) {
            try {
                future.get(Config.timeout, TimeUnit.SECONDS);
            } catch (Exception e) {
                Log.error("Task completion error: " + e.getMessage());
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Log.error("Executor termination interrupted: " + e.getMessage());
        }

    }

    // 抽取的辅助方法
    private static void processMethod(SootMethod m, String className, String methodSignature,
            ResultExporter resultExporter, AtomicInteger success) throws TimeoutException {
        long paStartTime = System.currentTimeMillis();
        CheckFinder cf = new CheckFinder(m);
        HashSet<SootMethod> CheckNodes = cf.runFind();
        PathAnalyze pa = new PathAnalyze(m,CheckNodes);
        pa.startAnalyze();
        Set<List<String>> result = pa.getAnalyzeResult();
        // Set<List<String>> result = new HashSet<>();
        long paEndTime = System.currentTimeMillis();
        resultExporter.writeResult(ResultExporter.CODE_SUCCESS, className, methodSignature, result,
                paEndTime - paStartTime, "");
        success.incrementAndGet();
        // pa.close();
    }


    private static void find_clearAPI(SootMethod m, String className, String methodSignature,
            ResultExporter resultExporter, AtomicInteger success) throws TimeoutException {
        // long paStartTime = System.currentTimeMillis();
        ClearDetector cf2 = new ClearDetector(m);
        cf2.runFind();
        // long paEndTime = System.currentTimeMillis();
        // resultExporter.writeResult(ResultExporter.CODE_SUCCESS, className, methodSignature, ,
        //         paEndTime - paStartTime, "");
        success.incrementAndGet();
    }
    private static void handleTimeout(String className, String methodName,
            ResultExporter resultExporter, Exception e) {
        Log.error("[-] Analyse timeout: ");
        resultExporter.writeResult(ResultExporter.CODE_TIMEOUT, className, methodName, null, 0,
                e.toString());
    }

    private static void handleError(String className, String methodName,
            ResultExporter resultExporter, Exception e) {
        Log.errorStack("[-] Analyse error: ", e);
        resultExporter.writeResult(ResultExporter.CODE_ERROR, className, methodName, null, 0,
                e.toString());
    }



    public static void testByMethodName(String className, String methodName) {

        String androidJarPath = JimpleConverter.getAndroidJarpath(defaultAPIversion);
        List<String> allFiles = FirmwareUtils.findAllFiles(defaultinputPath);
        FirmwareUtils.removeErrorFile(allFiles);
        Log.info("[-] Total files: " + allFiles.size());
        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv();
        SootMethod m2 = sootEnv.getMethodByName(className, methodName);
        Log.info("[-] " + m2.getSubSignature());
        CheckFinder cf = new CheckFinder(m2);
        HashSet<SootMethod> result = cf.runFind();
        PathAnalyze pa = new PathAnalyze(m2,result);
        pa.startAnalyze();
        
    }

    public static void testOneBySign(String className, String signature) {

        String androidJarPath = JimpleConverter.getAndroidJarpath(defaultAPIversion);
        List<String> allFiles = FirmwareUtils.findAllFiles(defaultinputPath);
        FirmwareUtils.removeErrorFile(allFiles);
        Log.info("[-] Total files: " + allFiles.size());

        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv();

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
    
    }


    public static void test_oppo() {
        AtomicInteger count = new AtomicInteger(0);
        AtomicInteger success = new AtomicInteger(0);

        AtomicInteger errorCount = new AtomicInteger(0);
        // 3. 优化线程池配置
        int processors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                processors, // 核心线程数
                processors * 2, // 最大线程数
                60L, TimeUnit.SECONDS, // 空闲线程存活时间
                new LinkedBlockingQueue<>(1000), // 使用有界队列
                new ThreadPoolExecutor.CallerRunsPolicy() // 队列满时的处理策略
        );
        Log.info("load frim");
        // 4. 初始化环境
        String firmPath = "/public/CustomRoms/OPPO_RMX3888_C15_610/fs";
        // String firmPath = "/public/CustomRoms/xiaomi_yuechu";
        int APIV= 33;
        String androidJarPath = JimpleConverter.getAndroidJarpath(APIV);
        List<String> allFiles = FirmwareUtils.findAllFiles(firmPath);

        FirmwareUtils.removeErrorFile(allFiles);
        Log.info("FILES : " + allFiles.size());
        

        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv();

        HashMap<String,List<String>> apiList2 = APIFinder.findServiceAPI();
        Log.info("[-] Total API: " + apiList2.size());


        // 5. 使用批处理方式处理任务
        ResultExporter resultExporter = new ResultExporter(Config.resultPath);
        List<Future<?>> futures = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : apiList2.entrySet()) {
            String className = entry.getKey();
            List<String> methodList = entry.getValue();

            // 6. 批量提交任务
            for (String methodSign : methodList) {
                count.incrementAndGet();
                Future<?> future = executor.submit(() -> {
                    try {
                        SootMethod m = null;
                        try {
                            m = sootEnv.getMethodBySignature(className, methodSign);
                        } catch (Exception e) {
                            //convert sign to method name
                            String methodName = methodSign.substring(0, methodSign.indexOf('('));
                            methodName = methodName.substring(methodName.lastIndexOf(' ') + 1);
                            m = sootEnv.getMethodByName(className, methodName);
                        }
                        find_clearAPI(m, className, methodSign, resultExporter, success);
                        // Log.info(className + "\t\t" + methodSign);
                  
                    } catch (Exception e) {
                        errorCount.incrementAndGet();
                        handleError(className, methodSign, resultExporter, e);
                    }
                });
                futures.add(future);

            }
        }

        // 8. 等待所有任务完成
        for (Future<?> future : futures) {
            try {
                future.get(Config.timeout, TimeUnit.HOURS);
            } catch (Exception e) {
                Log.error("Task completion error: " + e.getMessage());
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Log.error("Executor termination interrupted: " + e.getMessage());
        }

    }

    public static void test_find3(int APIversion,String inputPath){
        String androidJarPath = JimpleConverter.getAndroidJarpath(APIversion);
        List<String> allFiles = FirmwareUtils.findAllFiles(inputPath);
        FirmwareUtils.removeErrorFile(allFiles);
        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv();

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
        List<String> allFiles = FirmwareUtils.findAllFiles(inputPath);
        FirmwareUtils.removeErrorFile(allFiles);
        

        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv();

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

    public static String inputPath_6 = "/mnt/hd1/devoke/AOSP6.0.1_r10/out/target/product/mini-emulator-armv7-a-neon/system/";
    public static String inputPath_7 = "/mnt/hd1/devoke/AOSP7.0/out/target/product/mini-emulator-armv7-a-neon/system/";
    public static int defaultAPIversion = 24;
    public static String defaultinputPath = inputPath_7;

    public static void main(String[] args) {
        // Config.logLevel = "INFO";
        Config.logLevel = "OFF";
        init();
        // test_oppo();
        // test_arc_api(Config.AOSP_601_ARCADE, 23, inputPath_6);
        // test_arc_api(Config.AOSP_7_ARCADE, 24, inputPath_7);
        test_full_api(24, inputPath_7);
        // test_full_api(23, inputPath_6); 
        // test_find3(24, inputPath_7);
        // testOneBySign("com.android.server.audio.AudioService","void reloadAudioSettings()");
    }

}