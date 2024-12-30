// package Engine;
// import java.lang.reflect.Method;
// import java.util.*;
// public class HookManager {

//     private static final Map<String, Map<String, Method>> hookMap = new HashMap<>();
//     /**
//      * 注册Hook方法
//      * @param className 目标类名
//      * @param methodName 目标方法名
//      * @param hookMethod Hook方法
//      */
//     public static void registerHook(String className, String methodName, Method hookMethod) {
//         hookMap.computeIfAbsent(className, k -> new HashMap<>())
//                .put(methodName, hookMethod);
//     }

//     /**
//      * 获取Hook方法
//      * @param className 目标类名
//      * @param methodName 目标方法名
//      * @return 对应的Hook方法，如果不存在则返回null
//      */
//     public static Method getHookMethod(String className, String methodName) {
//         Map<String, Method> classHooks = hookMap.get(className);
//         if (classHooks != null) {
//             return classHooks.get(methodName);
//         }
//         return null;
//     }

//     /**
//      * 执行Hook
//      * @param target 目标对象
//      * @param methodName 目标方法名
//      * @param args 方法参数
//      * @return Hook方法的执行结果
//      * @throws Exception 如果执行过程中出现异常
//      */
//     public static Expr invokeHook(Object target, String methodName, Object... args) {
//         String className = target.getClass().getName();
//         Method hookMethod = getHookMethod(className, methodName);
//         if (hookMethod != null) {
//             return hookMethod.invoke(null, args);
//         }
      
//     }
// }