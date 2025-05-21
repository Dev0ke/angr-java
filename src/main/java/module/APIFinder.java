package module;

import soot.*;
import soot.util.Chain;
import utils.Log;
import java.util.*;

public class APIFinder {
    
    public static HashMap<String,List<String>> findProviderAPI() {
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
            if ( superClassName.contains("android.content.ContentProvider")  ) {
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
                        // Log.debug("|-- Method: " + methodName);
                        methodList.add(method.getSubSignature());
                        method_count++;
                    }

                }
                if(method_count > 0)
                    result.put(sootClass.getName(),methodList);
                // Log.info("[+] Total Method: " + method_count);
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

    public static boolean checkClass(SootClass sootClass){
        String className = sootClass.getName();
        SootClass superClass = sootClass.hasSuperclass() ? sootClass.getSuperclass() : null;
        
        if(superClass != null){
            String superClassName =  superClass.getName() ;
            if(superClassName.contains("$Stub") || superClassName.contains("SystemService") || superClassName.contains("JobService"))
                return true;
        }

        if (!sootClass.isPublic()) {
            if(className.contains("$BinderService"))
                return true;
            else
                return false;
        }

        if( className.startsWith("java") || className.startsWith("sun") || className.contains("Exception")){
            return false;
        }
        //获取父类

        if(className.contains("Service"))
            return true;

        return false;
    }




    public static HashMap<String,List<String>> findServiceAPI() {
        HashMap<String,List<String>> result = new HashMap<>();
        Chain<SootClass> classes = Scene.v().getClasses();

        int exposedClass_count = 0;
        int exposedMethod_count = 0;
        for (SootClass sootClass : classes) {
            if (checkClass(sootClass)) {
                Log.info("Class: " + sootClass.getName());
                exposedClass_count++;
                // 获取 public method
                int method_count = 0;
                List<String> methodList = findMethod(sootClass);
                if(methodList.size() > 0)
                    result.put(sootClass.getName(),methodList);
                // Log.info("[+] Total Method: " + method_count);
                exposedMethod_count += methodList.size();
            }

            //get inner class
            // for (SootClass innerClass : sootClass.getInnerClasses()) {
            //     if (checkClass(innerClass)) {
            //         Log.info("Inner Class: " + innerClass.getName());
            //         exposedClass_count++;
            //         List<String> methodList = findMethod(innerClass);
            //         if(methodList.size() > 0)
            //             result.put(innerClass.getName(),methodList);
            //         exposedMethod_count += methodList.size();
            //     }
            // }

            // else if( superClassName.contains("com.android.server.SystemService") ){
            //     //TODO getImpl
            // }

        }
        Log.info("Total exposed Class: " + exposedClass_count);
        Log.info("Total exposed Method: " + exposedMethod_count);
        return result;
    }


    public static List<String> findMethod(SootClass sootClass){
        List<String> methodList = new ArrayList<>();
        for (SootMethod method : sootClass.getMethods()) {
            //  排除 init
            if (method.getName().equals("<init>") || method.getName().equals("<clinit>") || !method.isPublic() ||method.isNative() || method.isAbstract()) {
                continue;
            }
                String methodName = method.getName();
                if(methodName.contains("lambda$") || methodName.contains("$$Nest$"))
                    continue;
                // Log.debug("|-- Method: " + methodName);
                methodList.add(method.getSubSignature());
        
        }
        return methodList;
    }


}
