package main;

import init.Config;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.jimple.InvokeStmt;
import soot.jimple.toolkits.ide.icfg.OnTheFlyJimpleBasedICFG;
import soot.options.Options;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.UnitGraph;
import utils.Log;

import java.util.Collections;
import java.util.List;


public class OnTheFlyICFGExample {

    public static void main(String[] args) {
        // 设置 Soot 环境
        String classPath = Config.testInput2;  // 替换为你的类路径
        String mainClass = "test1";      // 替换为你的主类
        setupSoot(classPath, mainClass);


        SootClass sootClass = Scene.v().getSootClass(mainClass);
        // 创建 OnTheFlyJimpleBasedICFG 实例


        SootMethod entryMethods = sootClass.getMethodByName( "check3");
        Log.info("entryMethods: " + entryMethods);
        OnTheFlyJimpleBasedICFG icfg = new OnTheFlyJimpleBasedICFG(entryMethods);
        analyzeMethodFlow(entryMethods, icfg);


    }

    // 设置 Soot 环境
    private static void setupSoot(String classPath, String mainClass) {
        Options.v().set_prepend_classpath(true);
        Options.v().set_whole_program(true);
        Options.v().set_process_dir(Collections.singletonList(classPath));
        Options.v().set_main_class(mainClass);
        Options.v().set_keep_line_number(true);
        Options.v().setPhaseOption("cg.spark", "on");  // 启用 Spark Call Graph 分析
        Scene.v().loadNecessaryClasses();
    }

    // 使用 OnTheFlyJimpleBasedICFG 获取指定方法的控制流图并分析
    private static void analyzeMethodFlow(SootMethod method, OnTheFlyJimpleBasedICFG icfg) {
        DirectedGraph<Unit> unitGraph = icfg.getOrCreateUnitGraph(method);

        System.out.println("Analyzing method: " + method.getSignature());
        for (Unit unit : unitGraph) {
            System.out.println("Unit: " + unit);
            unitGraph.getSuccsOf(unit).forEach(succ -> System.out.println("  Successor: " + succ));
            //invoke
            if(unit instanceof InvokeStmt){
                System.out.println("  Invoke: " + unit);
            }

            //unitGraph.getPredsOf(unit).forEach(pred -> System.out.println("  Predecessor: " + pred));
        }
    }
}

