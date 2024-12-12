package main;

import accessControl.CheckPermissionAPI;
import init.Config;
import soot.*;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.options.Options;
import soot.util.queue.QueueReader;
import utils.Log;

import java.util.*;

import static init.StaticAPIs.EXCLUDE_API_FOR_ANALYSIS;

public class CGgen {
    public CallGraph cg;
    public String className;
    public String methodName;
    public String methodSignature;
    public HashSet<SootMethod> checkNode;
    public SootMethod entryMethod;

    public CGgen(String className, String methodSignature) {
        this.className = className;
        this.methodSignature = methodSignature;
        checkNode = new HashSet<>();
    }
    public static String getFullName(SootMethod method) {
        return method.getDeclaringClass().getName() + "." + method.getName();
    }

    public boolean isEntryMethod(SootMethod method){
        return method.equals(this.entryMethod);
    }


    public void markCheckNode(SootMethod method){
       if(checkNode.contains(method)){
           return;
       }
       if(isEntryMethod(method)){
            return;
       }
       checkNode.add(method);
        Log.info("|- Mark checkNode: " + getFullName(method));
       //get src method
        for (Iterator<Edge> it = this.cg.edgesInto(method); it.hasNext(); ) {
            Edge edge = it.next();
            SootMethod src = edge.src();
            markCheckNode(src);
        }
    }
    public SootMethod getMethodByName(String className, String methodName) {
        SootClass sootClass = Scene.v().getSootClass(className);
        return sootClass.getMethodByNameUnsafe(methodName);
    }
    public SootMethod getMethodBySignature(String className, String methodSignature) {
        SootClass sootClass = Scene.v().getSootClass(className);
        return sootClass.getMethod(methodSignature);
    }

    public SootMethod getMethodBySignature(String sign) {
        return Scene.v().getMethod(sign);
    }

    public void printCG() {
        QueueReader<Edge> edges = cg.listener();
        while (edges.hasNext()) {
            Edge edge = edges.next();
            SootMethod src = edge.src();
            SootMethod tgt = edge.tgt();
            Log.info("Call from " + getFullName(src) + " to " + getFullName(tgt));
        }
    }

    public void traverseCG(){
        QueueReader<Edge> edges = cg.listener();
        while(edges.hasNext()){
            Edge edge = edges.next();
            SootMethod src = edge.src();
            SootMethod tgt = edge.tgt();

            // ignore existing checkNode
            if(checkNode.contains(src) || checkNode.contains(tgt) ){
                continue;
            }
            String targetClassName = tgt.getDeclaringClass().getName();
            if(CheckPermissionAPI.getAllClassName().contains(targetClassName)){
                String targetMethodName = tgt.getName();
                if(CheckPermissionAPI.getAllMethodNameByClassName(targetClassName).contains(targetMethodName)){
                    Log.info("[+] Find checkAPI" + targetClassName + "." + targetMethodName);
                    markCheckNode(src);
                }
            }
        }
    }

    public void genCG(){

        G.reset();
        Options.v().set_num_threads(Config.threads);
        Options.v().set_output_format(Options.output_format_jimple); // 输出形式
        Options.v().set_output_dir(Config.outputJimplePath); // 输出目录
        Options.v().set_whole_program(true); // 全程序分析
        Options.v().set_verbose(true); // 显示详细信息
        Options.v().set_allow_phantom_refs(true); // 找不到对应的源代码就被称作是虚类（phantom class） 允许虚类存在 不报错
        Options.v().set_no_bodies_for_excluded(true); // 不加载被排除的类 callgraph边会减少很多
        Options.v().set_wrong_staticness(Options.wrong_staticness_ignore); // 忽略静态性错误
        if (Config.useExistJimple) {
            Options.v().set_prepend_classpath(true);
            Options.v().set_soot_classpath(Config.outputJimplePath);
            Options.v().set_src_prec(Options.src_prec_jimple);
            Options.v().set_process_dir(Collections.singletonList(Config.outputJimplePath));
        } else {
            Options.v().set_process_dir(Collections.singletonList(Config.testInput2)); // 处理目录中的所有类
        }



        List<String> modifiableExcludeList = new ArrayList<>(EXCLUDE_API_FOR_ANALYSIS);
        modifiableExcludeList.addAll(CheckPermissionAPI.getAllClassName());
        Options.v().set_exclude(modifiableExcludeList);
        SootClass targetClass = Scene.v().loadClassAndSupport(this.className);
        targetClass.setApplicationClass();

        Scene.v().loadNecessaryClasses();

        // 设置入口方法
        List<SootMethod> entryPoints = new ArrayList<>();
        
        this.entryMethod = targetClass.getMethod(methodSignature);
        this.methodName = this.entryMethod.getName();
        entryPoints.add(this.entryMethod);
        Scene.v().setEntryPoints(entryPoints);



        Options.v().setPhaseOption("cg.spark", "on"); // 启用 Spark 分析
        // 运行 Spark Pack 分析
//        Map<String, String> phaseOptions = new HashMap<>();
//        phaseOptions.put("enabled", "true");
//        phaseOptions.put("vta", "true");
//        phaseOptions.put("simple-edges-bidirectional", "true");
//        phaseOptions.put("ignore-types", "false");
//        phaseOptions.put("on-fly-cg", "true");
//
//        SparkTransformer.v().transform("cg.spark", phaseOptions);
//        PackManager.v().runPacks();
//        this.cg = Scene.v().getCallGraph();
           Log.info("[+] CallGraph generated successfully");

//        SootMethod src = Scene.v().getSootClass(this.className).getMethodByName(this.methodName);
//        Iterator<MethodOrMethodContext> targets = new Targets(cg.edgesOutOf(src));
//        while (targets.hasNext()) {
//            SootMethod tgt = (SootMethod)targets.next();
//            System.out.println(src + " may call " + tgt);
//        }
    }
}
