package main;

import init.Config;
import soot.G;
import soot.PackManager;
import soot.Scene;
import soot.options.Options;
import utils.Log;
import utils.ZipUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class JimpleConverter {
    public static int getAPIVersion(String buildPropPath) {
        String apiKey = "ro.build.version.sdk";
        try (BufferedReader reader = new BufferedReader(new FileReader(buildPropPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(apiKey)) {
                    String[] parts = line.split("=");
                    if (parts.length > 1) {
                        Log.info("[+] API Version: " + parts[1]);
                        return Integer.parseInt(parts[1].trim());
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            Log.error("[-] Failed to read API version from build.prop");
            e.printStackTrace();
        }
        return -1; // 返回-1表示读取失败或未找到API版本信息
    }

    public static void main(String[] args) {
        int apiVersion = getAPIVersion("E:\\decheck_data\\system\\build.prop");
        String androidJarpath = getAndroidJarpath(apiVersion);
        String directoryPath = "E:\\decheck_data\\system\\";

        List<String> apkFiles = new ArrayList<>();
        List<String> jarFiles = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        findApkAndJarFiles(directoryPath, apkFiles, jarFiles);
//        for(String apk : apkFiles){
//            convert(jarPath,apk);
//        }
        convertJar("E:\\decheck_data\\system\\framework\\services.jar",androidJarpath);
        //convert jar
//        for(String jar : jarFiles){
//            convertJar(jar,androidJarpath);
//        }


        Log.info("Time: " + (System.currentTimeMillis() - startTime)/1000 + "s");
    }

    public static String getAndroidJarpath(int apiVersion){
        return Config.androidJarPath + "\\android-" + apiVersion + "\\android.jar";
    }

    public static void convertJar(String jarPath,String androidJarPath) {
        String tempPath = Config.tempPath + File.separator + jarPath.substring(jarPath.lastIndexOf("\\"));
        try {
            ZipUtils.unzip(jarPath, tempPath);
        } catch (IOException e) {
            Log.error("[-] Failed to unzip jar file: " + jarPath);
            e.printStackTrace();
            return;
        }

        List<String> dexFiles = new ArrayList<>();
        //find file end with dex
        findDexfiles(tempPath, dexFiles);
        for(String dex : dexFiles){
            convert(androidJarPath,dex);
        }
        //del  tempPath
        File tempDir = new File(tempPath);
        if (tempDir.exists()) {
            tempDir.delete();
        }
    }


    public static void findDexfiles(String directoryPath, List<String> dexFiles) {
        Queue<File> queue = new LinkedList<>();
        queue.add(new File(directoryPath));

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
    }

    public static void findApkAndJarFiles(String directoryPath, List<String> apkFiles, List<String> jarFiles) {
        Queue<File> queue = new LinkedList<>();
        queue.add(new File(directoryPath));

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
                if (current.getName().endsWith(".apk")) {
                    apkFiles.add(current.getAbsolutePath());  // 将apk文件添加到apkFiles列表
                } else if (current.getName().endsWith(".jar")) {
                    jarFiles.add(current.getAbsolutePath());  // 将jar文件添加到jarFiles列表
                }
            }
        }
    }

    public static void convert(String jarPath,String files) {
        // 设置 Soot 配置
        G.reset();
        Options.v().set_allow_phantom_refs(true);  // 允许使用虚拟引用
        Options.v().set_src_prec(Options.src_prec_apk);  // 设置输入源为 APK 文件
        Options.v().set_process_dir(Arrays.asList(files));  // APK 文件路径
        Options.v().set_force_android_jar(jarPath);  // 设置 Android SDK 的 android.jar 文件路径
        Options.v().set_process_multiple_dex(true);  // 处理多个 DEX 文件
        Options.v().set_whole_program(true);  // 启用整个程序分析
        Options.v().set_verbose(true);
        // 设置输出格式为 Jimple 格式
        Options.v().set_output_format(Options.output_format_jimple);
        Options.v().set_output_dir(Config.outputJimplePath);  // 设置输出目录

        // 加载必要的类
        try{
            Scene.v().loadNecessaryClasses();
            // 获取指定类，或者获取所有应用程序类
//            Chain<SootClass> allClasses = Scene.v().getApplicationClasses();
//            // 打印所有类名
//            for (SootClass sc : allClasses) {
//                System.out.println(sc.getName());
//            }
            // 执行 Soot 分析并写出 Jimple 文件
            PackManager.v().writeOutput();
        } catch (RuntimeException e) {
            Log.error("Error processing file(s): " + files);
            e.printStackTrace();
            // 可以在此处记录错误日志，或将失败的文件路径保存起来，以便进一步分析
        } catch (Exception e) {
            Log.error("Unexpected error: " + e.getMessage());
//            e.printStackTrace();
        }
    }
}