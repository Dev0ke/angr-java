package main;

import soot.G;
import soot.PackManager;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.options.Options;
import utils.Log;
import java.util.*;

import init.Config;

public class SootEnv {

    public String androidJarPath;
    public List<String> inputFile;
    public int inputType;
    
    // 添加成功和失败文件的跟踪列表
    private List<String> successfulFiles;
    private List<String> failedFiles;

    public SootEnv(String jarPath, List<String> inputFile,int inputType) {
        this.androidJarPath = jarPath;
        this.inputFile = inputFile;
        this.inputType = inputType;
        this.successfulFiles = new ArrayList<>();
        this.failedFiles = new ArrayList<>();
    }

    public SootMethod getMethodByName(String className, String methodName) {
        SootClass sootClass = Scene.v().getSootClass(className);
        return sootClass.getMethodByName(methodName);
    }

    public SootMethod getMethodBySignature(String className, String methodSignature) {
        SootClass sootClass = Scene.v().getSootClass(className);
        return sootClass.getMethod(methodSignature);
    }

    public SootMethod getMethodBySignature(String methodSignature) {
        return Scene.v().getMethod(methodSignature);
    }

    public Set<SootClass> getAllClass() {
        Set<SootClass> allClass = new HashSet<>();
        for (SootClass sc : Scene.v().getApplicationClasses()) {
            allClass.add(sc);
        }
        return allClass;
    }

    public List<SootMethod> getAllMethod(String className){
        SootClass sootClass = Scene.v().getSootClass(className);
        return sootClass.getMethods();
    }

    /**
     * 单独处理每个文件的私有方法
     */
    private boolean processFileIndividually(String filePath) {
        Log.info("Attempting to process file: " + filePath);
        
        try {
            // 重置Soot环境
            G.reset();
            
            // 设置基本Soot配置
            Options.v().set_allow_phantom_refs(true);
            Options.v().set_src_prec(this.inputType);
            Options.v().set_force_android_jar(this.androidJarPath);
            Options.v().set_process_multiple_dex(true);
            Options.v().set_whole_program(true);
            Options.v().set_verbose(false); // 减少单文件处理的详细输出
            Options.v().set_wrong_staticness(Options.wrong_staticness_ignore);
            Options.v().set_ignore_resolution_errors(true);
            Options.v().set_no_bodies_for_excluded(true);
            Options.v().set_keep_line_number(false);
            Options.v().set_keep_offset(false);
            
            // 设置当前单个文件
            List<String> singleFile = Arrays.asList(filePath);
            Options.v().set_process_dir(singleFile);
            
            // 尝试加载必要的类
            Scene.v().loadNecessaryClasses();
            
            Log.info("Successfully processed file: " + filePath);
            return true;
            
        } catch (RuntimeException e) {
            Log.error("Failed to process file [" + filePath + "]: " + e.getMessage());
            return false;
        } catch (Exception e) {
            Log.error("Unexpected error while processing file [" + filePath + "]: " + e.getMessage());
            return false;
        }
    }

    public void initEnv(boolean checkMode) {
        Log.info("Starting individual file processing, total files: " + inputFile.size());
        
        successfulFiles.clear();
        failedFiles.clear();
        
        // 逐个处理每个文件
        if(checkMode){
            for (String filePath : inputFile) {
                if (processFileIndividually(filePath)) {
                    successfulFiles.add(filePath);
                } else {
                    failedFiles.add(filePath);
                }
            }
        } else {
            successfulFiles = inputFile;
        }
            
        // 如果有成功处理的文件，进行最终的统一初始化
        if (!successfulFiles.isEmpty()) {
            try {
                System.out.println("Final initialization for successfully processed files, count: " + successfulFiles.size());
                
                // 重置Soot环境准备最终处理
                G.reset();
                Options.v().set_allow_phantom_refs(true);
                Options.v().set_src_prec(this.inputType);
                Options.v().set_process_dir(successfulFiles);
                Options.v().set_force_android_jar(this.androidJarPath);
                Options.v().set_process_multiple_dex(true);
                Options.v().set_whole_program(true);
                Options.v().set_verbose(true);
                Options.v().set_wrong_staticness(Options.wrong_staticness_ignore);
                Options.v().set_ignore_resolution_errors(true);
                Options.v().set_no_bodies_for_excluded(true);
                Options.v().set_keep_line_number(false);
                Options.v().set_keep_offset(false);
                
                // 最终加载所有成功验证的文件
                Scene.v().loadNecessaryClasses();
                
                Log.info("Final initialization completed");
                
            } catch (RuntimeException e) {
                Log.error("Final initialization failed: " + e.getMessage());
                // 如果最终初始化也失败，尝试只用第一个成功的文件
            } catch (Exception e) {
                Log.error("Unexpected error during final initialization: " + e.getMessage());
            }
        } else {
            Log.error("No files processed successfully, unable to initialize Soot environment");
        }
        
        // 输出处理统计信息
        System.out.println("=== File Processing Statistics ===");
        System.out.println("Total files: " + inputFile.size());
        System.out.println("Successfully processed: " + successfulFiles.size());
        System.out.println("Failed to process: " + failedFiles.size());
        
        if (!failedFiles.isEmpty()) {
            Log.info("Failed files list:");
            for (String failedFile : failedFiles) {
                Log.info("  - " + failedFile);
            }
        }
    }
    
    /**
     * 获取成功处理的文件列表
     */
    public List<String> getSuccessfulFiles() {
        return new ArrayList<>(successfulFiles);
    }
    
    /**
     * 获取处理失败的文件列表
     */
    public List<String> getFailedFiles() {
        return new ArrayList<>(failedFiles);
    }
}
