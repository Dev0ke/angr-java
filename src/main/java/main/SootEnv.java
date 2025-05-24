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

    public SootEnv(String jarPath, List<String> inputFile,int inputType) {
        this.androidJarPath = jarPath;
        this.inputFile = inputFile;
        this.inputType = inputType;
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

    public void initEnv() {
        // 设置 Soot 配置
        G.reset();
        Options.v().set_allow_phantom_refs(true);  // 允许使用虚拟引用
        Options.v().set_src_prec(this.inputType);  // 设置输入源为 APK 文件
        Options.v().set_process_dir(this.inputFile);  // APK 文件路径
        Options.v().set_force_android_jar(this.androidJarPath);  // 设置 Android SDK 的 android.jar 文件路径
        Options.v().set_process_multiple_dex(true);  // 处理多个 DEX 文件
        Options.v().set_whole_program(true);  // 启用整个程序分析
        Options.v().set_verbose(true);
        
        Options.v().set_wrong_staticness(Options.wrong_staticness_ignore);
        //call graph
        Options.v().setPhaseOption("cg.spark", "on");
        
        // 设置输出格式为 Jimple 格式
        // Options.v().set_output_format(Options.output_format_jimple);
        // Options.v().set_output_dir(Config.outputJimplePath);  // 设置输出目录

        // 加载必要的类
        try{
            Scene.v().loadNecessaryClasses();
            // 获取指定类，或者获取所有应用程序类
        //    Chain<SootClass> allClasses = Scene.v().getApplicationClasses();
        //    // 打印所有类名
        //    for (SootClass sc : allClasses) {
                
        //        if(sc.getName().contains("com.android.server.devicepolicy.DevicePolicyManagerService")){
        //           //print all method
        //           Log.info(sc.getName());
        //             for(SootMethod sm : sc.getMethods()){
        //                 Log.info("|-" +sm.getName());
        //        }
        //    }}
            // 执行 Soot 分析并写出 Jimple 文件
            // PackManager.v().writeOutput();
        } catch (RuntimeException e) {
            Log.error("Error processing file(s): " + this.inputFile);
            e.printStackTrace();
            // 可以在此处记录错误日志，或将失败的文件路径保存起来，以便进一步分析
        } catch (Exception e) {
            Log.error("Unexpected error: " + e.getMessage());
//            e.printStackTrace();
        }
    }
}
