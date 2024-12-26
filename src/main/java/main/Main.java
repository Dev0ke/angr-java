package main;

import accessControl.CheckAppOpAPI;
import accessControl.CheckPermissionAPI;
import accessControl.CheckPidAPI;
import accessControl.CheckUidAPI;
import module.APIFinder;
import module.JimpleConverter;
import module.PathAnalyze;
import soot.G;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.ArithmeticConstant;
import soot.options.Options;
import soot.util.Chain;
import utils.FirmwareUtils;
import utils.Log;
import init.Config;
import utils.ResultExporter;
import utils.ZipUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void init() {
        CheckPermissionAPI.init();
        CheckUidAPI.init();
        CheckPidAPI.init();
        CheckAppOpAPI.init();
    }

    public static HashMap<String,List<String>> findAPI() {
        HashMap<String,List<String>> result = new HashMap<>();
        Chain<SootClass> classes = Scene.v().getClasses();

        int exposedClass_count = 0;
        int exposedMethod_count = 0;
        for (SootClass sootClass : classes) {
            if (!sootClass.isPublic()) {
                continue;
            }

            //获取父类
            SootClass superClass = sootClass.hasSuperclass() ? sootClass.getSuperclass() : null;
            if(superClass == null)
                continue;

            // 检查父类名称是否包含 "Stub"
            String superClassName =  superClass.getName() ;
            //TO REMOVE
            if (superClassName.contains("$Stub") || superClassName.contains("com.android.server.SystemService") ||superClassName.contains("JobService") ) {
                // 检查类是否为public

                Log.info("Class: " + sootClass.getName() + " extends " + superClass.getName());
                exposedClass_count++;
                // 获取 public method
                int method_count = 0;
                List<String> methodList = new ArrayList<>();
                for (SootMethod method : sootClass.getMethods()) {
                    //  排除 init
                    if (method.getName().equals("<init>") || method.getName().equals("<clinit>") || !method.isPublic()) {
                        continue;
                    }

                    if (!method.isNative() && !method.isAbstract()) {
                        String methodName = method.getName();
                        if(methodName.contains("lambda$") || methodName.contains("$$Nest$"))
                            continue;
                        Log.debug("|-- Method: " + methodName);
                        methodList.add(method.getSubSignature());
                        method_count++;
                    }

                }
                if(method_count > 0)
                    result.put(sootClass.getName(),methodList);
                Log.info("[+] Total Method: " + method_count);
                exposedMethod_count += method_count;


            }
            else if( superClassName.contains("com.android.server.SystemService") ){
                //TODO getImpl
            }

        }
        Log.info("Total exposed Class: " + exposedClass_count);
        Log.info("Total exposed Method: " + exposedMethod_count);
        return result;
    }
    public static void multi3() {
        long startTime = System.currentTimeMillis();
        // 1. 预先加载API列表
        HashMap<String, List<String>> apiList = readAPIfromFile(Config.apiListPath2);

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
        int APIversion = 24;
        String androidJarPath = JimpleConverter.getAndroidJarpath(APIversion);
        List<String> allFiles = FirmwareUtils.findAllFiles("/public/AOSP24/out/target/product/mini-emulator-armv7-a-neon/system/");
        FirmwareUtils.removeErrorFile(allFiles);
        

        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv();

        HashMap<String,List<String>> apiList2= findAPI();
        Log.info("[-] Total API: " + apiList2.size());


        // 5. 使用批处理方式处理任务
        ResultExporter resultExporter = new ResultExporter(Config.resultPath);
        List<Future<?>> futures = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : apiList2.entrySet()) {
            String className = entry.getKey();
            List<String> methodList = entry.getValue();

            // 6. 批量提交任务
            for (String methodSign : methodList) {
                List<String> EXmethodSigns = apiList.get(className);
                if(EXmethodSigns != null && EXmethodSigns.contains(methodSign))
                    continue;
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

                // // 7. 定期输出状态
                // if (count.get() % 100 == 0) {
                // printStatus(startTime, count, success, timeoutCount, errorCount);
                // }
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

        // 9. 最终状态输出
        printStatus(startTime, count, success, timeoutCount, errorCount);
    }

    public static void multi2() {
        long startTime = System.currentTimeMillis();
        // 1. 预先加载API列表
        HashMap<String, List<String>> apiList = readAPIfromFile(Config.apiListPath2);

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
        int APIversion = 24;
        String androidJarPath = JimpleConverter.getAndroidJarpath(APIversion);
        List<String> allFiles = FirmwareUtils.findAllFiles("/public/AOSP24/out/target/product/mini-emulator-armv7-a-neon/system/");
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

                // // 7. 定期输出状态
                // if (count.get() % 100 == 0) {
                // printStatus(startTime, count, success, timeoutCount, errorCount);
                // }
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

        // 9. 最终状态输出
        printStatus(startTime, count, success, timeoutCount, errorCount);
    }

    // 抽取的辅助方法
    private static void processMethod(SootMethod m, String className, String methodSignature,
            ResultExporter resultExporter, AtomicInteger success) throws TimeoutException {
        long paStartTime = System.currentTimeMillis();
        PathAnalyze pa = new PathAnalyze(m);
        pa.startAnalyze();
        Set<List<String>> result = pa.getAnalyzeResult();
        long paEndTime = System.currentTimeMillis();
        resultExporter.writeResult(ResultExporter.CODE_SUCCESS, className, methodSignature, result,
                paEndTime - paStartTime, "");
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

    private static void printStatus(long startTime, AtomicInteger count, AtomicInteger success,
            AtomicInteger timeoutCount, AtomicInteger errorCount) {
        Log.printTime("[+] Status", startTime);
        Log.info("Total API: " + count.get() + " Success: " + success.get() +
                " Timeout: " + timeoutCount.get() + " Errors: " + errorCount.get());
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        init();
        multi2();
        // testOneBySign("com.android.phone.PhoneInterfaceManager","int getDataNetworkType(java.lang.String)");
        // multi2();


    }

    public static void testByMethodName(String className, String methodName) {
        int APIversion = 24;
        String androidJarPath = JimpleConverter.getAndroidJarpath(APIversion);
        // String inputJarPath =
        // "/public/AOSP25/out/target/product/generic_arm64/system/framework/services.jar";
        List<String> allFiles = FirmwareUtils.findAllFiles("/public/AOSP24/out/target/product/mini-emulator-armv7-a-neon/system/");
        FirmwareUtils.removeErrorFile(allFiles);
        Log.info("[-] Total files: " + allFiles.size());
        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv();
        SootMethod m2 = sootEnv.getMethodByName(className, methodName);
        Log.info("[-] " + m2.getSubSignature());
    }

    public static void testOneBySign(String className, String signature) {
        int APIversion = 24;
        String androidJarPath = JimpleConverter.getAndroidJarpath(APIversion);
        List<String> allFiles = FirmwareUtils.findAllFiles("/public/AOSP24/out/target/product/mini-emulator-armv7-a-neon/system/");
        FirmwareUtils.removeErrorFile(allFiles);
        Log.info("[-] Total files: " + allFiles.size());
        SootEnv sootEnv = new SootEnv(androidJarPath, allFiles, Options.src_prec_apk);
        sootEnv.initEnv();
        SootMethod m2 = sootEnv.getMethodBySignature(className, signature);
        PathAnalyze pa = new PathAnalyze(m2);
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