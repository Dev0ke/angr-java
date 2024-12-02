package module;

import init.Config;
import soot.*;
import soot.options.Options;
import soot.util.Chain;
import utils.Log;

import java.util.*;

public class APIFinder {


    public static HashMap<String,List<String>> findAPI() {
        HashMap<String,List<String>> result = new HashMap<>();

        G.reset();
        Options.v().set_prepend_classpath(true);
        Options.v().set_whole_program(true); // 启用全程序分析
        Options.v().set_allow_phantom_refs(true); // 允许虚引用，避免找不到类时报错
        if (Config.useExistJimple) {
            Options.v().set_soot_classpath(Config.outputJimplePath);
            Options.v().set_src_prec(Options.src_prec_jimple);
            Options.v().set_process_dir(Collections.singletonList(Config.outputJimplePath));
        } else {
            Options.v().set_process_dir(Collections.singletonList(Config.testInput2)); // 处理目录中的所有类
        }


        Chain<SootClass> classes = Scene.v().getClasses();
        Options.v().set_no_bodies_for_excluded(true);
        Options.v().set_exclude(Arrays.asList("java.*", "javax.*", "sun.*"));

        Scene.v().loadNecessaryClasses();
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
                    if (method.getName().equals("<init>") || method.getName().equals("<clinit>")) {
                        continue;
                    }

                    if (method.isPublic() && !method.isNative() && !method.isAbstract()) {
                        String methodName = method.getName();
                        if(methodName.contains("lambda$") || methodName.contains("$$Nest$"))
                            continue;
                        Log.debug("|-- Method: " + methodName);
                        methodList.add(methodName);
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
}
