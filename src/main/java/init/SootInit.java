package init;
import soot.G;
import soot.Scene;
import soot.SootClass;
import soot.options.Options;

import java.util.Arrays;
import java.util.Collections;

public class SootInit {


    public static void init(String args) {
        G.reset();
        //Options.v().setPhaseOption("cg.spark", "on");
        Options.v().set_no_bodies_for_excluded(true);
        Options.v().set_prepend_classpath(true);
        Options.v().set_allow_phantom_refs(true);
        Options.v().set_output_format(Options.output_format_jimple);
        Options.v().set_whole_program(true); // 全程序分析
//        Options.v().set_main_class("p000.test");  // 替换为实际类名
//        SootClass mainClass = Scene.v().loadClassAndSupport("p000.test");
//        Scene.v().setMainClass(mainClass);
        Options.v().set_exclude(Arrays.asList("java.*", "javax.*", "sun.*"));
        Options.v().set_process_dir(Collections.singletonList(args));
        Scene.v().loadNecessaryClasses(); // 加载 Soot 依赖的类和命令行指定的类

    }
}
