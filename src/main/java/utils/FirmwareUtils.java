package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import java.util.Iterator;

import init.Config;

public class FirmwareUtils {
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


    public static List<String> findApkFiles(String directoryPath) {
        List<String> apkFiles = new ArrayList<>();
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
                } 
            }
        }
        return apkFiles;
    }

    public static List<String> findJarFiles(String directoryPath) {
        List<String> jarFiles = new ArrayList<>();
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
                if (current.getName().endsWith(".jar")) {
                    jarFiles.add(current.getAbsolutePath());  // 将apk文件添加到apkFiles列表
                } 
            }
        }
        return jarFiles;
    }

    public static void convertJar(String jarPath) {
        String tempPath = Config.tempPath + File.separator + jarPath.substring(jarPath.lastIndexOf("/"));
        try {
            ZipUtils.unzip(jarPath, tempPath);
        } catch (IOException e) {
            Log.error("[-] Failed to unzip jar file: " + jarPath);
            e.printStackTrace();
            return ;
        }
   
    }


    public static List<String> findAllFiles(String directoryPath) {
        List<String> allFiles = new ArrayList<>();
        allFiles.addAll(findApkFiles(directoryPath));
        List<String> jarFiles = findJarFiles(directoryPath);
        //convert jar to dex
        for (String jarFile : jarFiles) {
            convertJar(jarFile);
        }
        allFiles.addAll(findDexfiles(Config.tempPath));
        return allFiles;
    }

    public static void removeErrorFile(List<String> allFiles) {
        Set<String> errorFiles = new HashSet<>(Arrays.asList("CtsShimPrebuilt.apk", "framework-res.apk","CtsShimPrivPrebuilt.apk"));
        Iterator<String> iterator = allFiles.iterator();
        while (iterator.hasNext()) {
            String file = iterator.next();
            // if file contains errorFiles, remove it
            for (String errorFile : errorFiles) {
                if (file.contains(errorFile)) {
                    iterator.remove();
                    break;
                }
            }
        }
    }


}
