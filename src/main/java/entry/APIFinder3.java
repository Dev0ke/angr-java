package entry;

import soot.*;
import soot.jimple.*;
import soot.jimple.internal.*;
import soot.options.Options;
import soot.util.Chain;
import utils.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * APIFinder3 - 专门用于发现Android应用服务API的查找器
 * 主要针对应用层服务，如AccountAuthenticator、ContentProvider等
 * 与APIFinder2不同，本类关注通过抽象基类、内部Stub类、IBinder暴露等模式的服务
 */
public class APIFinder3 {
    
    private HashSet<SootMethod> visitedMethods;
    private HashMap<SootClass, HashSet<SootMethod>> collectedServiceApis;
    
    public APIFinder3() {
        this.visitedMethods = new HashSet<>();
        this.collectedServiceApis = new HashMap<>();
    }

    /**
     * 主入口方法 - 收集所有应用服务类的API
     * @param useCache 是否使用缓存
     * @return HashMap<String, List<String>> 类名到方法签名列表的映射
     */
    public HashMap<String, HashSet<String>> collectAllClassApis(boolean useCache) {
        Log.info("Starting Android application service API collection");
        
        // 重置状态
        this.visitedMethods.clear();
        this.collectedServiceApis.clear();
        
        // 如果使用缓存，从文件加载
        HashSet<SootClass> applicationServiceClasses;
        if (useCache) {
            applicationServiceClasses = loadCacheFromFile("/home/devoke/decheck/decheck_data/cache/AppServices.txt");
        } else {
            // 收集应用服务类
            applicationServiceClasses = collectApplicationServiceClasses();
        }
        
        Log.info("Found " + applicationServiceClasses.size() + " application service classes");
        
        // 提取服务API
        extractServiceAPIs(applicationServiceClasses);
        
        Log.info("Collected APIs from " + collectedServiceApis.size() + " service classes");
        
        // 转换结果格式
        HashMap<String, HashSet<String>> result = new HashMap<>();
        for (Map.Entry<SootClass, HashSet<SootMethod>> entry : collectedServiceApis.entrySet()) {
            String className = entry.getKey().getName();
            HashSet<String> methodSignatures = new HashSet<>();
            for (SootMethod method : entry.getValue()) {
                methodSignatures.add(method.getSubSignature());
            }
            result.put(className, methodSignatures);
            Log.debug("Application service class: " + className + " contains " + methodSignatures.size() + " API methods");
        }
        
        Log.info("API collection completed. Total classes: " + result.size());
        return result;
    }

    /**
     * 收集应用服务类 - 使用多种识别策略
     * @return 识别出的服务类集合
     */
    private HashSet<SootClass> collectApplicationServiceClasses() {
        HashSet<SootClass> serviceClasses = new HashSet<>();
        
        Log.info("Starting multi-strategy service class identification");
        
        // 策略1: 基于抽象基类模式识别
        HashSet<SootClass> abstractBaseServices = findServiceClassesByAbstractBase();
        serviceClasses.addAll(abstractBaseServices);
        Log.info("Strategy 1 - Abstract base pattern: found " + abstractBaseServices.size() + " service classes");
        
        // 策略2: 基于内部Stub类模式识别
        HashSet<SootClass> stubPatternServices = findServiceClassesByStubPattern();
        serviceClasses.addAll(stubPatternServices);
        Log.info("Strategy 2 - Stub pattern: found " + stubPatternServices.size() + " service classes");
        
        // 策略3: 基于IBinder暴露模式识别
        HashSet<SootClass> binderPatternServices = findServiceClassesByIBinderPattern();
        serviceClasses.addAll(binderPatternServices);
        Log.info("Strategy 3 - IBinder pattern: found " + binderPatternServices.size() + " service classes");
        
        // 策略4: 基于直接继承Stub类模式识别（新增）
        HashSet<SootClass> directStubServices = findServiceClassesByDirectStubInheritance();
        serviceClasses.addAll(directStubServices);
        Log.info("Strategy 4 - Direct Stub inheritance: found " + directStubServices.size() + " service classes");
        
        // 过滤和验证
        HashSet<SootClass> validServiceClasses = new HashSet<>();
        for (SootClass serviceClass : serviceClasses) {
            if (isApplicationServiceClass(serviceClass)) {
                validServiceClasses.add(serviceClass);
            }
        }
        
        Log.info("Valid service classes after verification: " + validServiceClasses.size());
        return validServiceClasses;
    }

    /**
     * 策略1: 基于抽象基类模式识别服务类
     * 查找继承特定抽象基类且包含getIBinder方法的类
     */
    private HashSet<SootClass> findServiceClassesByAbstractBase() {
        HashSet<SootClass> serviceClasses = new HashSet<>();
        
        Chain<SootClass> allClasses = Scene.v().getApplicationClasses();
        for (SootClass sootClass : allClasses) {
            try {
                // 检查是否继承了应用服务相关的抽象基类
                if (extendsApplicationServiceBase(sootClass) && hasIBinderMethod(sootClass)) {
                    serviceClasses.add(sootClass);
                    Log.info("Abstract base pattern found service: " + sootClass.getName());
                }
            } catch (Exception e) {
                Log.warn("Error processing class " + sootClass.getName() + ": " + e.getMessage());
            }
        }
        
        return serviceClasses;
    }

    /**
     * 策略2: 基于内部Stub类模式识别服务类
     * 查找包含继承$Stub类的内部类的外部类
     */
    private HashSet<SootClass> findServiceClassesByStubPattern() {
        HashSet<SootClass> serviceClasses = new HashSet<>();
        
        Chain<SootClass> allClasses = Scene.v().getApplicationClasses();
        for (SootClass sootClass : allClasses) {
            String className = sootClass.getName();
            
            // 查找内部类，检查是否继承了Stub
            if (className.contains("$")) {
                try {
                    if (sootClass.hasSuperclass()) {
                        SootClass superClass = sootClass.getSuperclass();
                        if (superClass.getName().contains("$Stub")) {
                            // 找到Stub实现，获取外部类
                            String outerClassName = className.substring(0, className.lastIndexOf('$'));
                            SootClass outerClass = getSootClassSafely(outerClassName);
                            if (outerClass != null) {
                                serviceClasses.add(outerClass);
                                Log.info("Stub pattern found service: " + outerClassName + " (via inner class " + className + ")");
                            }
                        }
                    }
                } catch (Exception e) {
                    Log.warn("Error processing Stub class " + className + ": " + e.getMessage());
                }
            }
        }
        
        return serviceClasses;
    }

    /**
     * 策略3: 基于IBinder暴露模式识别服务类
     * 查找具有IBinder相关方法的服务类
     */
    private HashSet<SootClass> findServiceClassesByIBinderPattern() {
        HashSet<SootClass> serviceClasses = new HashSet<>();
        
        Chain<SootClass> allClasses = Scene.v().getApplicationClasses();
        for (SootClass sootClass : allClasses) {
            try {
                // 检查是否有IBinder相关方法
                if (hasIBinderMethod(sootClass) || hasOnBindMethod(sootClass)) {
                    // 进一步验证是否为服务类
                    if (isLikelyServiceClass(sootClass)) {
                        serviceClasses.add(sootClass);
                        Log.info("IBinder pattern found service: " + sootClass.getName());
                    }
                }
            } catch (Exception e) {
                Log.warn("Error processing IBinder pattern for " + sootClass.getName() + ": " + e.getMessage());
            }
        }
        
        return serviceClasses;
    }

    /**
     * 策略4: 基于直接继承Stub类模式识别服务类
     * 查找直接继承*.Stub类的具体服务实现
     */
    private HashSet<SootClass> findServiceClassesByDirectStubInheritance() {
        HashSet<SootClass> serviceClasses = new HashSet<>();
        
        Chain<SootClass> allClasses = Scene.v().getApplicationClasses();
        for (SootClass sootClass : allClasses) {
            try {
                // 检查是否直接继承了Stub类
                if (sootClass.hasSuperclass()) {
                    SootClass superClass = sootClass.getSuperclass();
                    String superClassName = superClass.getName();
                    
                    // 检查父类是否是AIDL Stub类
                    if (superClassName.contains("$Stub") && isValidStubClass(superClass)) {
                        // 确保这是一个具体的服务实现类，不是抽象类或接口
                        if (!sootClass.isAbstract() && !sootClass.isInterface()) {
                            serviceClasses.add(sootClass);
                            Log.info("Direct Stub inheritance found service: " + sootClass.getName() + 
                                   " extends " + superClassName);
                        }
                    }
                }
            } catch (Exception e) {
                Log.warn("Error processing direct Stub inheritance for " + sootClass.getName() + ": " + e.getMessage());
            }
        }
        
        return serviceClasses;
    }

    /**
     * 从识别的服务类中提取API方法
     */
    private void extractServiceAPIs(HashSet<SootClass> serviceClasses) {
        for (SootClass serviceClass : serviceClasses) {
            try {
                Log.info("Extracting service APIs from: " + serviceClass.getName());
                
                HashSet<SootMethod> serviceApiMethods = new HashSet<>();
                
                // 检查服务类型并采用相应的API提取策略
                if (isDirectStubServiceImplementation(serviceClass)) {
                    // 对于直接继承Stub的服务实现
                    Log.info("Processing direct Stub service implementation: " + serviceClass.getName());
                    serviceApiMethods.addAll(extractAPIsFromDirectStubService(serviceClass));
                } else {
                    // 对于抽象基类服务
                    Log.info("Processing abstract base service: " + serviceClass.getName());
                    
                    // 方法1: 从抽象方法提取API（仅针对主服务类的真正抽象API）
                    HashSet<SootMethod> abstractApis = extractAPIsFromAbstractMethods(serviceClass);
                    serviceApiMethods.addAll(abstractApis);
                    
                    // 重要改进：为每个内部Transport类单独提取和记录API
                    HashSet<SootClass> transportClasses = findAllTransportClasses(serviceClass);
                    for (SootClass transportClass : transportClasses) {
                        try {
                            Log.info("Extracting APIs for individual transport class: " + transportClass.getName());
                            
                            HashSet<SootMethod> transportSpecificApis = new HashSet<>();
                            
                            // 主要通过AIDL接口匹配方法（这是最准确的API提取方式）
                            SootClass aidlInterface = findAIDLInterfaceFromTransport(transportClass);
                            if (aidlInterface != null) {
                                Log.info("Matching AIDL interface " + aidlInterface.getName() + " for transport " + transportClass.getName());
                                
                                for (SootMethod interfaceMethod : aidlInterface.getMethods()) {
                                    if (!interfaceMethod.getName().startsWith("<") && 
                                        !interfaceMethod.getName().equals("asBinder")) {
                                        
                                        // 在Transport类中查找实现
                                        SootMethod implMethod = findMatchingImplementation(transportClass, interfaceMethod);
                                        if (implMethod != null) {
                                            transportSpecificApis.add(implMethod);
                                            Log.debug("Matched AIDL method for transport " + transportClass.getName() + ": " + interfaceMethod.getName() + " -> " + implMethod.getSubSignature());
                                        }
                                    }
                                }
                            }
                            
                            // 补充：如果AIDL接口匹配不够，添加Transport类中真正的API方法（经过过滤）
                            for (SootMethod method : transportClass.getMethods()) {
                                if (isValidPublicAPI(method)) {
                                    transportSpecificApis.add(method);
                                    Log.debug("Extracted validated API from transport " + transportClass.getName() + ": " + method.getSubSignature());
                                }
                            }
                            
                            // 将Transport类作为独立的服务类添加到结果中
                            if (!transportSpecificApis.isEmpty()) {
                                this.collectedServiceApis.put(transportClass, transportSpecificApis);
                                Log.info("Successfully extracted " + transportSpecificApis.size() + " API methods from transport service " + transportClass.getName());
                            } else {
                                Log.warn("No APIs found for transport class: " + transportClass.getName());
                            }
                            
                        } catch (Exception e) {
                            Log.error("Error extracting APIs from transport class " + transportClass.getName() + ": " + e.getMessage());
                        }
                    }
                }
                
                // 将主服务类的API添加到结果中（如果有的话）
                if (!serviceApiMethods.isEmpty()) {
                    this.collectedServiceApis.put(serviceClass, serviceApiMethods);
                    Log.info("Successfully extracted " + serviceApiMethods.size() + " API methods from main service " + serviceClass.getName());
                }
                
            } catch (Exception e) {
                Log.error("Error extracting APIs from " + serviceClass.getName() + ": " + e.getMessage());
            }
        }
    }
    
    /**
     * 从直接继承Stub的服务实现中提取API方法
     */
    private HashSet<SootMethod> extractAPIsFromDirectStubService(SootClass serviceClass) {
        HashSet<SootMethod> apiMethods = new HashSet<>();
        
        try {
            Log.info("Extracting APIs from direct Stub service: " + serviceClass.getName());
            
            // 方法1: 从AIDL接口提取API方法
            SootClass aidlInterface = findAIDLInterfaceFromDirectStub(serviceClass);
            if (aidlInterface != null) {
                Log.info("Found AIDL interface for direct Stub service: " + aidlInterface.getName());
                
                for (SootMethod interfaceMethod : aidlInterface.getMethods()) {
                    if (!interfaceMethod.getName().startsWith("<") && 
                        !interfaceMethod.getName().equals("asBinder")) {
                        
                        // 在服务类中查找实现
                        SootMethod implMethod = findMatchingImplementation(serviceClass, interfaceMethod);
                        if (implMethod != null) {
                            apiMethods.add(implMethod);
                            Log.debug("Matched AIDL method: " + interfaceMethod.getName() + " -> " + implMethod.getSubSignature());
                        }
                    }
                }
            }
            
            // 方法2: 从服务类的公共方法中提取API（经过过滤）
            for (SootMethod method : serviceClass.getMethods()) {
                if (isValidPublicAPI(method)) {
                    apiMethods.add(method);
                    Log.debug("Extracted validated API from direct Stub service: " + method.getSubSignature());
                }
            }
            
        } catch (Exception e) {
            Log.error("Error extracting APIs from direct Stub service " + serviceClass.getName() + ": " + e.getMessage());
        }
        
        return apiMethods;
    }
    
    /**
     * 从直接继承Stub的服务类查找对应的AIDL接口
     */
    private SootClass findAIDLInterfaceFromDirectStub(SootClass serviceClass) {
        try {
            if (serviceClass.hasSuperclass()) {
                SootClass stubClass = serviceClass.getSuperclass();
                String stubClassName = stubClass.getName();
                
                if (stubClassName.contains("$Stub")) {
                    // 提取AIDL接口名
                    String interfaceName = stubClassName.replace("$Stub", "");
                    SootClass aidlInterface = getSootClassSafely(interfaceName);
                    if (aidlInterface != null) {
                        Log.debug("Found AIDL interface from direct Stub: " + interfaceName);
                        return aidlInterface;
                    }
                }
            }
        } catch (Exception e) {
            Log.debug("Error finding AIDL interface from direct Stub " + serviceClass.getName() + ": " + e.getMessage());
        }
        return null;
    }

    // 辅助方法实现
    
    /**
     * 从缓存文件加载服务类
     */
    private HashSet<SootClass> loadCacheFromFile(String cacheFilePath) {
        HashSet<SootClass> serviceClasses = new HashSet<>();
        try {
            File cacheFile = new File(cacheFilePath);
            if (cacheFile.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(cacheFile));
                try {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        line = line.trim();
                        if (!line.isEmpty()) {
                            SootClass sootClass = getSootClassSafely(line);
                            if (sootClass != null) {
                                serviceClasses.add(sootClass);
                                Log.debug("Loaded service class from cache: " + line);
                            } else {
                                Log.warn("Class not found in cache: " + line);
                            }
                        }
                    }
                } finally {
                    reader.close();
                }
            } else {
                Log.warn("Cache file does not exist: " + cacheFilePath);
            }
        } catch (Exception e) {
            Log.error("Error loading from cache file: " + e.getMessage());
        }
        return serviceClasses;
    }
    
    /**
     * 检查类是否继承应用服务相关的抽象基类
     */
    private boolean extendsApplicationServiceBase(SootClass sootClass) {
        try {
            String className = sootClass.getName();
            
            // 直接检查已知的重要抽象服务基类
            String[] serviceBaseClasses = {
                "android.accounts.AbstractAccountAuthenticator",
                "android.content.ContentProvider",
                "android.inputmethodservice.AbstractInputMethodService",
                "android.accessibilityservice.AbstractAccessibilityService", 
                "android.service.dreams.AbstractDreamService",
                "android.service.wallpaper.AbstractWallpaperService",
                "android.media.browse.MediaBrowserService",
                "android.service.notification.NotificationListenerService",
                "android.net.VpnService"
            };
            
            for (String baseClass : serviceBaseClasses) {
                if (className.equals(baseClass)) {
                    Log.debug("Direct match for service base class: " + className);
                    return true;
                }
            }
            
            if (!sootClass.hasSuperclass()) {
                return false;
            }
            
            SootClass superClass = sootClass.getSuperclass();
            String superClassName = superClass.getName();
            
            // 检查已知的应用服务抽象基类模式
            String[] serviceBasePatterns = {
                "AbstractAccountAuthenticator",
                "ContentProvider", 
                "AbstractInputMethodService",
                "AbstractAccessibilityService",
                "AbstractDreamService",
                "MediaBrowserService",
                "NotificationListenerService",
                "VpnService",
                "AbstractWallpaperService",
                "BroadcastReceiver",
                "Service"  // 基本的Service类
            };
            
            for (String pattern : serviceBasePatterns) {
                if (superClassName.contains(pattern)) {
                    Log.debug("Found service base class inheritance: " + className + " extends " + superClassName);
                    return true;
                }
            }
            
            // 递归检查父类
            return extendsApplicationServiceBase(superClass);
            
        } catch (Exception e) {
            Log.debug("Error checking service base class inheritance: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * 检查类是否有IBinder相关方法
     */
    private boolean hasIBinderMethod(SootClass sootClass) {
        try {
            for (SootMethod method : sootClass.getMethods()) {
                String methodName = method.getName();
                Type returnType = method.getReturnType();
                
                // 检查常见的IBinder返回方法
                if ((methodName.equals("getIBinder") || methodName.equals("getBinder") || 
                     methodName.equals("asBinder")) && 
                    returnType.toString().equals("android.os.IBinder")) {
                    Log.debug("Found IBinder method: " + sootClass.getName() + "." + methodName);
                    return true;
                }
            }
        } catch (Exception e) {
            Log.debug("Error checking IBinder methods: " + e.getMessage());
        }
        return false;
    }
    
    /**
     * 检查类是否有onBind方法
     */
    private boolean hasOnBindMethod(SootClass sootClass) {
        try {
            for (SootMethod method : sootClass.getMethods()) {
                if (method.getName().equals("onBind") && 
                    method.getReturnType().toString().equals("android.os.IBinder")) {
                    Log.debug("Found onBind method: " + sootClass.getName());
                    return true;
                }
            }
        } catch (Exception e) {
            Log.debug("Error checking onBind method: " + e.getMessage());
        }
        return false;
    }
    
    /**
     * 判断是否可能是服务类
     */
    private boolean isLikelyServiceClass(SootClass sootClass) {
        String className = sootClass.getName();
        
        // 基于类名模式的快速判断
        if (className.contains("Service") || className.contains("Provider") || 
            className.contains("Authenticator") || className.contains("Receiver")) {
            return true;
        }
        
        // 检查是否继承Android Service相关类
        try {
            if (sootClass.hasSuperclass()) {
                String superClassName = sootClass.getSuperclass().getName();
                if (superClassName.contains("Service") || superClassName.contains("Provider") ||
                    superClassName.contains("BroadcastReceiver")) {
                    return true;
                }
            }
        } catch (Exception e) {
            Log.debug("Error checking service class inheritance: " + e.getMessage());
        }
        
        return false;
    }
    
    /**
     * 验证是否为有效的应用服务类
     */
    private boolean isApplicationServiceClass(SootClass sootClass) {
        try {
            String className = sootClass.getName();
            
            // 排除系统类和框架类
            if (className.startsWith("java.") || className.startsWith("javax.") ||
                className.startsWith("android.") || className.startsWith("com.android.internal.")) {
                
                // 特殊例外：允许重要的抽象基类和硬件服务实现
                if (className.equals("android.accounts.AbstractAccountAuthenticator") ||
                    className.contains("AbstractAccount") || 
                    className.contains("AbstractInputMethod") ||
                    className.contains("AbstractAccessibility") ||
                    className.contains("AbstractDream") ||
                    className.contains("AbstractWallpaper") ||
                    // 新增：允许硬件服务实现
                    className.contains("hardware.") ||
                    className.contains("Hardware") ||
                    className.contains("Service") ||
                    className.contains("Provider")) {
                    Log.info("Allowing important service class: " + className);
                } else {
                    return false;
                }
            }
            
            // 排除测试类
            if (className.contains("Test") || className.contains("Mock")) {
                return false;
            }
            
            // 对于抽象类，需要特殊处理
            if (sootClass.isAbstract()) {
                // 检查是否是重要的抽象服务基类模式
                if (isImportantAbstractServiceBase(sootClass)) {
                    Log.info("Validated abstract service base class: " + className);
                    return true;
                } else {
                    Log.debug("Filtering out non-service abstract class: " + className);
                    return false;
                }
            }
            
            // 排除接口
            if (sootClass.isInterface()) {
                return false;
            }
            
            // 新增：检查是否是直接继承Stub的服务实现
            if (isDirectStubServiceImplementation(sootClass)) {
                Log.info("Validated direct Stub service implementation: " + className);
                return true;
            }
            
            // 必须有公共构造函数或者是内部类
            boolean hasValidConstructor = false;
            for (SootMethod method : sootClass.getMethods()) {
                if (method.getName().equals("<init>") && 
                    (method.isPublic() || method.isProtected())) {
                    hasValidConstructor = true;
                    break;
                }
            }
            
            return hasValidConstructor || className.contains("$");
            
        } catch (Exception e) {
            Log.debug("Error validating application service class: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * 检查是否为直接继承Stub的服务实现
     */
    private boolean isDirectStubServiceImplementation(SootClass sootClass) {
        try {
            if (!sootClass.hasSuperclass()) {
                return false;
            }
            
            SootClass superClass = sootClass.getSuperclass();
            String superClassName = superClass.getName();
            
            // 检查是否直接继承Stub类
            if (superClassName.contains("$Stub") && isValidStubClass(superClass)) {
                Log.debug("Found direct Stub inheritance: " + sootClass.getName() + " extends " + superClassName);
                
                // 额外验证：检查是否有典型的服务实现特征
                if (hasServiceImplementationCharacteristics(sootClass)) {
                    return true;
                }
            }
            
        } catch (Exception e) {
            Log.debug("Error checking direct Stub service implementation: " + e.getMessage());
        }
        
        return false;
    }
    
    /**
     * 检查是否具有服务实现的特征
     */
    private boolean hasServiceImplementationCharacteristics(SootClass sootClass) {
        try {
            String className = sootClass.getName();
            
            // 检查类名模式
            if (className.contains("Service") || className.contains("Hardware") || 
                className.contains("Manager") || className.contains("Provider")) {
                return true;
            }
            
            // 检查是否有getInstance方法（单例模式）
            for (SootMethod method : sootClass.getMethods()) {
                String methodName = method.getName();
                if (methodName.equals("getInstance") && method.isStatic()) {
                    Log.debug("Found getInstance method in " + className);
                    return true;
                }
            }
            
            // 检查是否有权限检查相关方法
            for (SootMethod method : sootClass.getMethods()) {
                String methodName = method.getName();
                if (methodName.contains("Permission") || methodName.contains("enforce") ||
                    methodName.contains("check")) {
                    Log.debug("Found permission-related method in " + className);
                    return true;
                }
            }
            
            // 检查是否有Context成员变量（服务通常需要Context）
            try {
                for (SootField field : sootClass.getFields()) {
                    String fieldType = field.getType().toString();
                    if (fieldType.contains("Context")) {
                        Log.debug("Found Context field in " + className);
                        return true;
                    }
                }
            } catch (Exception e) {
                Log.debug("Error checking fields: " + e.getMessage());
            }
            
        } catch (Exception e) {
            Log.debug("Error checking service implementation characteristics: " + e.getMessage());
        }
        
        return false;
    }
    
    /**
     * 检查是否为重要的抽象服务基类
     * 主要识别像AbstractAccountAuthenticator这样的模式
     */
    private boolean isImportantAbstractServiceBase(SootClass sootClass) {
        try {
            String className = sootClass.getName();
            
            // 基于类名的快速识别
            String[] importantAbstractPatterns = {
                "AbstractAccountAuthenticator",
                "AbstractInputMethodService", 
                "AbstractAccessibilityService",
                "AbstractDreamService",
                "AbstractWallpaperService",
                "ContentProvider"  // ContentProvider也是抽象基类
            };
            
            for (String pattern : importantAbstractPatterns) {
                if (className.contains(pattern)) {
                    Log.debug("Found important abstract service pattern: " + className + " matches " + pattern);
                    return true;
                }
            }
            
            // 检查是否有Transport内部类且有getIBinder方法
            if (hasTransportInnerClass(sootClass) && hasIBinderMethod(sootClass)) {
                Log.debug("Found abstract service with Transport pattern: " + className);
                return true;
            }
            
            // 检查是否有多个抽象方法且继承特定基类
            if (hasMultipleAbstractMethods(sootClass) && extendsApplicationServiceBase(sootClass)) {
                Log.debug("Found abstract service with multiple abstract APIs: " + className);
                return true;
            }
            
        } catch (Exception e) {
            Log.debug("Error checking abstract service base: " + e.getMessage());
        }
        
        return false;
    }
    
    /**
     * 检查是否有Transport内部类
     */
    private boolean hasTransportInnerClass(SootClass sootClass) {
        String serviceClassName = sootClass.getName();
        
        try {
            // 查找Transport内部类
            String transportClassName = serviceClassName + "$Transport";
            SootClass transportClass = getSootClassSafely(transportClassName);
            if (transportClass != null && transportClass.hasSuperclass()) {
                String superClassName = transportClass.getSuperclass().getName();
                if (superClassName.contains("$Stub")) {
                    return true;
                }
            }
            
            // 也查找其他可能的内部Stub类
            HashSet<SootClass> transportClasses = findAllTransportClasses(sootClass);
            return !transportClasses.isEmpty();
            
        } catch (Exception e) {
            Log.debug("Error checking Transport inner class: " + e.getMessage());
        }
        
        return false;
    }
    
    /**
     * 检查是否有多个抽象方法（表明这是一个API服务基类）
     */
    private boolean hasMultipleAbstractMethods(SootClass sootClass) {
        try {
            int abstractMethodCount = 0;
            for (SootMethod method : sootClass.getMethods()) {
                if (method.isAbstract() && !method.getName().startsWith("<")) {
                    abstractMethodCount++;
                }
            }
            // 至少有3个抽象方法才认为是服务API基类
            return abstractMethodCount >= 3;
            
        } catch (Exception e) {
            Log.debug("Error counting abstract methods: " + e.getMessage());
        }
        
        return false;
    }
    
    /**
     * 安全获取SootClass
     */
    private SootClass getSootClassSafely(String className) {
        try {
            if (Scene.v().containsClass(className)) {
                return Scene.v().getSootClass(className);
            }
            
            // 尝试加载类
            try {
                Scene.v().loadClassAndSupport(className);
                if (Scene.v().containsClass(className)) {
                    return Scene.v().getSootClass(className);
                }
            } catch (Exception e) {
                Log.debug("Unable to load class: " + className + " - " + e.getMessage());
            }
            
        } catch (Exception e) {
            Log.debug("Error getting SootClass: " + className + " - " + e.getMessage());
        }
        return null;
    }
    
    /**
     * 从Transport内部类提取API方法
     */
    private HashSet<SootMethod> extractAPIsFromTransportClass(SootClass serviceClass) {
        HashSet<SootMethod> apiMethods = new HashSet<>();
        
        try {
            // 查找所有继承Stub的内部类
            HashSet<SootClass> transportClasses = findAllTransportClasses(serviceClass);
            
            for (SootClass transportClass : transportClasses) {
                Log.info("Found Transport class: " + transportClass.getName());
                
                // 提取Transport类中的所有非系统方法
                for (SootMethod method : transportClass.getMethods()) {
                    if (!method.getName().startsWith("<") && // 排除构造函数
                        !method.getName().equals("asBinder") && // 排除系统方法
                        method.isPublic()) { // 只要公共方法
                        
                        apiMethods.add(method);
                        Log.debug("Extracted API from Transport: " + method.getSubSignature());
                    }
                }
            }
        } catch (Exception e) {
            Log.warn("Error extracting APIs from Transport class: " + e.getMessage());
        }
        
        return apiMethods;
    }
    
    /**
     * 查找所有Transport内部类 - 新的实现，支持多个内部Stub类
     */
    private HashSet<SootClass> findAllTransportClasses(SootClass serviceClass) {
        HashSet<SootClass> transportClasses = new HashSet<>();
        String serviceClassName = serviceClass.getName();
        
        try {
            // 方法1: 扫描所有应用类，查找属于此服务的内部Stub类
            Chain<SootClass> allClasses = Scene.v().getApplicationClasses();
            for (SootClass sootClass : allClasses) {
                String className = sootClass.getName();
                
                // 检查是否是此服务的内部类
                if (className.startsWith(serviceClassName + "$") && 
                    className.contains("$") && 
                    !className.equals(serviceClassName)) {
                    
                    try {
                        // 检查是否继承了Stub类
                        if (sootClass.hasSuperclass()) {
                            SootClass superClass = sootClass.getSuperclass();
                            if (superClass.getName().contains("$Stub")) {
                                transportClasses.add(sootClass);
                                Log.debug("Found inner Stub class: " + className + " extends " + superClass.getName());
                            }
                        }
                    } catch (Exception e) {
                        Log.debug("Error checking inner class " + className + ": " + e.getMessage());
                    }
                }
            }
            
            // 方法2: 尝试传统的命名模式（作为备用）
            if (transportClasses.isEmpty()) {
                SootClass traditionalTransport = findTransportClass(serviceClass);
                if (traditionalTransport != null) {
                    transportClasses.add(traditionalTransport);
                }
            }
            
        } catch (Exception e) {
            Log.warn("Error finding transport classes for " + serviceClassName + ": " + e.getMessage());
        }
        
        Log.info("Found " + transportClasses.size() + " transport classes for service: " + serviceClassName);
        return transportClasses;
    }
    
    /**
     * 从抽象方法提取API
     */
    private HashSet<SootMethod> extractAPIsFromAbstractMethods(SootClass serviceClass) {
        HashSet<SootMethod> apiMethods = new HashSet<>();
        
        try {
            // 查找服务类中的抽象方法（只有抽象方法才是真正需要实现的API）
            for (SootMethod method : serviceClass.getMethods()) {
                if (method.isAbstract() && isValidPublicAPI(method)) {
                    apiMethods.add(method);
                    Log.debug("Extracted API from abstract method: " + method.getSubSignature());
                }
            }
            
            // 如果是抽象类，也检查父类的抽象方法
            if (serviceClass.hasSuperclass()) {
                SootClass superClass = serviceClass.getSuperclass();
                if (superClass.isAbstract()) {
                    HashSet<SootMethod> parentApis = extractAPIsFromAbstractMethods(superClass);
                    apiMethods.addAll(parentApis);
                }
            }
            
        } catch (Exception e) {
            Log.warn("Error extracting APIs from abstract methods: " + e.getMessage());
        }
        
        return apiMethods;
    }
    
    /**
     * 匹配AIDL接口方法
     */
    private HashSet<SootMethod> matchAIDLInterfaceMethods(SootClass serviceClass) {
        HashSet<SootMethod> apiMethods = new HashSet<>();
        
        try {
            // 查找所有相关的Transport类
            HashSet<SootClass> transportClasses = findAllTransportClasses(serviceClass);
            
            for (SootClass transportClass : transportClasses) {
                // 查找每个Transport类对应的AIDL接口
                SootClass aidlInterface = findAIDLInterfaceFromTransport(transportClass);
                if (aidlInterface != null) {
                    Log.info("Found AIDL interface: " + aidlInterface.getName() + " for transport: " + transportClass.getName());
                    
                    // 匹配接口方法与服务实现
                    for (SootMethod interfaceMethod : aidlInterface.getMethods()) {
                        if (!interfaceMethod.getName().startsWith("<") && 
                            !interfaceMethod.getName().equals("asBinder")) {
                            
                            // 首先在Transport类中查找实现
                            SootMethod implMethod = findMatchingImplementation(transportClass, interfaceMethod);
                            if (implMethod != null) {
                                apiMethods.add(implMethod);
                                Log.debug("Matched AIDL method in transport: " + interfaceMethod.getName() + " -> " + implMethod.getSubSignature());
                            } else {
                                // 如果在Transport类中没找到，尝试在服务类中查找
                                implMethod = findMatchingImplementation(serviceClass, interfaceMethod);
                                if (implMethod != null) {
                                    apiMethods.add(implMethod);
                                    Log.debug("Matched AIDL method in service: " + interfaceMethod.getName() + " -> " + implMethod.getSubSignature());
                                }
                            }
                        }
                    }
                }
            }
            
            // 如果没有找到Transport类，尝试传统方法
            if (transportClasses.isEmpty()) {
                SootClass aidlInterface = findAIDLInterface(serviceClass);
                if (aidlInterface != null) {
                    Log.info("Found AIDL interface: " + aidlInterface.getName());
                    
                    for (SootMethod interfaceMethod : aidlInterface.getMethods()) {
                        if (!interfaceMethod.getName().startsWith("<") && 
                            !interfaceMethod.getName().equals("asBinder")) {
                            
                            SootMethod implMethod = findMatchingImplementation(serviceClass, interfaceMethod);
                            if (implMethod != null) {
                                apiMethods.add(implMethod);
                                Log.debug("Matched AIDL method: " + interfaceMethod.getName() + " -> " + implMethod.getSubSignature());
                            }
                        }
                    }
                }
            }
            
        } catch (Exception e) {
            Log.warn("Error matching AIDL interface methods: " + e.getMessage());
        }
        
        return apiMethods;
    }
    
    /**
     * 从Transport类查找对应的AIDL接口
     */
    private SootClass findAIDLInterfaceFromTransport(SootClass transportClass) {
        try {
            if (transportClass.hasSuperclass()) {
                SootClass stubClass = transportClass.getSuperclass();
                return extractAIDLInterfaceFromStub(stubClass);
            }
        } catch (Exception e) {
            Log.debug("Error finding AIDL interface from transport " + transportClass.getName() + ": " + e.getMessage());
        }
        return null;
    }
    
    /**
     * 查找Transport内部类
     */
    private SootClass findTransportClass(SootClass serviceClass) {
        String serviceClassName = serviceClass.getName();
        
        // 查找命名模式为 OuterClass$Transport 的内部类
        String[] transportPatterns = {"$Transport", "$Stub", "$Binder", "$ServiceImpl"};
        
        for (String pattern : transportPatterns) {
            String transportClassName = serviceClassName + pattern;
            SootClass transportClass = getSootClassSafely(transportClassName);
            if (transportClass != null) {
                // 验证是否继承了Stub类
                if (transportClass.hasSuperclass() && 
                    transportClass.getSuperclass().getName().contains("$Stub")) {
                    return transportClass;
                }
            }
        }
        
        return null;
    }
    
    /**
     * 查找AIDL接口
     */
    private SootClass findAIDLInterface(SootClass serviceClass) {
        try {
            String className = serviceClass.getName();
            
            // 首先通过Transport类查找
            SootClass transportClass = findTransportClass(serviceClass);
            if (transportClass != null && transportClass.hasSuperclass()) {
                SootClass stubClass = transportClass.getSuperclass();
                SootClass aidlInterface = extractAIDLInterfaceFromStub(stubClass);
                if (aidlInterface != null) {
                    Log.debug("Found AIDL interface via Transport: " + aidlInterface.getName());
                    return aidlInterface;
                }
            }
            
            // 通过已知的服务类到AIDL接口的映射
            String[][] serviceToAidlMappings = {
                {"AbstractAccountAuthenticator", "android.accounts.IAccountAuthenticator"},
                {"ContentProvider", "android.content.IContentProvider"},
                {"AbstractInputMethodService", "com.android.internal.view.IInputMethodService"},
                {"AbstractAccessibilityService", "android.accessibilityservice.IAccessibilityServiceConnection"},
                {"MediaBrowserService", "android.media.browse.IMediaBrowserService"},
                {"NotificationListenerService", "android.service.notification.INotificationListener"},
                {"VpnService", "android.net.IVpnService"}
            };
            
            for (String[] mapping : serviceToAidlMappings) {
                if (className.contains(mapping[0])) {
                    SootClass aidlInterface = getSootClassSafely(mapping[1]);
                    if (aidlInterface != null) {
                        Log.debug("Found AIDL interface via mapping: " + mapping[0] + " -> " + mapping[1]);
                        return aidlInterface;
                    }
                }
            }
            
            // 尝试通过命名模式推断
            if (className.contains("Authenticator")) {
                return getSootClassSafely("android.accounts.IAccountAuthenticator");
            } else if (className.contains("Provider")) {
                return getSootClassSafely("android.content.IContentProvider");
            } else if (className.contains("InputMethod")) {
                return getSootClassSafely("com.android.internal.view.IInputMethodService");
            }
            
        } catch (Exception e) {
            Log.debug("Error finding AIDL interface: " + e.getMessage());
        }
        
        return null;
    }
    
    /**
     * 从Stub类提取AIDL接口 - 增强版本
     */
    private SootClass extractAIDLInterfaceFromStub(SootClass stubClass) {
        try {
            String stubClassName = stubClass.getName();
            Log.debug("Extracting AIDL interface from stub: " + stubClassName);
            
            if (stubClassName.contains("$Stub")) {
                String interfaceName = stubClassName.replace("$Stub", "");
                Log.debug("Trying to find interface: " + interfaceName);
                SootClass aidlInterface = getSootClassSafely(interfaceName);
                if (aidlInterface != null) {
                    Log.debug("Successfully found AIDL interface: " + interfaceName);
                    return aidlInterface;
                }
            }
            
            // 如果直接替换不行，尝试查找父接口
            try {
                if (stubClass.getInterfaceCount() > 0) {
                    for (SootClass iface : stubClass.getInterfaces()) {
                        String ifaceName = iface.getName();
                        if (ifaceName.startsWith("android.") && ifaceName.contains("I") && !ifaceName.contains("$")) {
                            Log.debug("Found potential AIDL interface via implemented interface: " + ifaceName);
                            return iface;
                        }
                    }
                }
            } catch (Exception e) {
                Log.debug("Error checking implemented interfaces: " + e.getMessage());
            }
            
        } catch (Exception e) {
            Log.debug("Error extracting AIDL interface from stub: " + e.getMessage());
        }
        
        return null;
    }
    
    /**
     * 查找匹配的实现方法 - 增强版本，支持更好的方法匹配
     */
    private SootMethod findMatchingImplementation(SootClass serviceClass, SootMethod interfaceMethod) {
        try {
            Log.debug("Searching for implementation of " + interfaceMethod.getName() + " in class " + serviceClass.getName());
            
            // 精确匹配
            for (SootMethod method : serviceClass.getMethods()) {
                if (method.getName().equals(interfaceMethod.getName()) &&
                    method.getParameterCount() == interfaceMethod.getParameterCount()) {
                    
                    // 检查参数类型匹配
                    boolean parametersMatch = true;
                    for (int i = 0; i < method.getParameterCount(); i++) {
                        Type methodParamType = method.getParameterType(i);
                        Type interfaceParamType = interfaceMethod.getParameterType(i);
                        
                        if (!methodParamType.equals(interfaceParamType)) {
                            // 尝试类型兼容性检查
                            if (!areTypesCompatible(methodParamType, interfaceParamType)) {
                                parametersMatch = false;
                                break;
                            }
                        }
                    }
                    
                    if (parametersMatch) {
                        Log.debug("Found exact match: " + method.getSubSignature());
                        return method;
                    } else {
                        Log.debug("Method name matches but parameters don't: " + method.getSubSignature());
                    }
                }
            }
            
            // 如果当前类中没找到，而且当前类是服务类，则查找其Transport类
            if (!serviceClass.getName().contains("$")) {
                // 这是主服务类，查找其Transport类
                HashSet<SootClass> transportClasses = findAllTransportClasses(serviceClass);
                for (SootClass transportClass : transportClasses) {
                    SootMethod implMethod = findMatchingImplementation(transportClass, interfaceMethod);
                    if (implMethod != null) {
                        return implMethod;
                    }
                }
            }
            
            Log.debug("No implementation found for " + interfaceMethod.getName() + " in " + serviceClass.getName());
            
        } catch (Exception e) {
            Log.debug("Error finding matching implementation: " + e.getMessage());
        }
        
        return null;
    }
    
    /**
     * 检查两个类型是否兼容
     */
    private boolean areTypesCompatible(Type type1, Type type2) {
        if (type1.equals(type2)) {
            return true;
        }
        
        // 基本类型兼容性检查
        String type1Str = type1.toString();
        String type2Str = type2.toString();
        
        // Android特有的类型兼容性
        if ((type1Str.equals("android.os.IBinder") && type2Str.contains("Binder")) ||
            (type2Str.equals("android.os.IBinder") && type1Str.contains("Binder"))) {
            return true;
        }
        
        // 检查继承关系
        if (type1 instanceof RefType && type2 instanceof RefType) {
            try {
                SootClass class1 = ((RefType) type1).getSootClass();
                SootClass class2 = ((RefType) type2).getSootClass();
                return isSubclassOf(class1, class2) || isSubclassOf(class2, class1);
            } catch (Exception e) {
                Log.debug("Error checking type compatibility: " + e.getMessage());
            }
        }
        
        return false;
    }
    
    /**
     * 检查类的继承关系
     */
    private boolean isSubclassOf(SootClass subClass, SootClass superClass) {
        if (subClass.equals(superClass)) {
            return true;
        }
        
        try {
            if (subClass.hasSuperclass()) {
                return isSubclassOf(subClass.getSuperclass(), superClass);
            }
        } catch (Exception e) {
            Log.debug("Error checking inheritance: " + e.getMessage());
        }
        
        return false;
    }

    /**
     * 判断方法是否为有效的公开API
     * 过滤掉Android框架方法和不应该暴露的方法
     */
    private boolean isValidPublicAPI(SootMethod method) {
        String methodName = method.getName();
        String declaringClassName = method.getDeclaringClass().getName();
        
        // 排除构造函数和初始化方法
        if (methodName.startsWith("<")) {
            return false;
        }
        
        // 对于重要的抽象服务基类，采用更宽松的策略
        boolean isImportantServiceBase = declaringClassName.contains("AbstractAccountAuthenticator") ||
                                        declaringClassName.contains("ContentProvider") ||
                                        declaringClassName.contains("AbstractInputMethod") ||
                                        declaringClassName.contains("AbstractAccessibility") ||
                                        declaringClassName.contains("AbstractDream") ||
                                        declaringClassName.contains("AbstractWallpaper");
        
        // 排除Android框架的生命周期方法和内部方法
        String[] frameworkMethods = {
            "onCreate", "onDestroy", "onStart", "onStop", "onResume", "onPause",
            "onBind", "onUnbind", "onRebind", "onStartCommand", "onConfigurationChanged",
            "onTaskRemoved", "onTrimMemory", "onLowMemory", "onHandleIntent",
            "asBinder", "getIBinder", "getBinder", "onTransact", "dump",
            "attachBaseContext", "onCreateApplication", "getApplication",
            "equals", "hashCode", "toString", "getClass", "notify", "notifyAll", "wait",
            "clone", "finalize", "registerReceiver", "unregisterReceiver",
            "startService", "stopService", "bindService", "unbindService",
            "getSystemService", "getBaseContext", "getApplicationContext"
        };
        
        for (String frameworkMethod : frameworkMethods) {
            if (methodName.equals(frameworkMethod)) {
                Log.debug("Filtering out framework method: " + methodName);
                return false;
            }
        }
        
        // 对重要服务基类的抽象方法，直接认为是API
        if (isImportantServiceBase && method.isAbstract()) {
            Log.debug("Keeping abstract API method from important service base: " + methodName);
            return true;
        }
        
        // 排除以"on"开头的回调方法（但对重要服务基类更宽松）
        if (methodName.startsWith("on") && Character.isUpperCase(methodName.charAt(2))) {
            // 对于重要服务基类，保留更多可能的API方法
            if (isImportantServiceBase) {
                // AbstractAccountAuthenticator等可能有oneway等特殊方法
                if (methodName.equals("oneway") || methodName.startsWith("onGet") || 
                    methodName.startsWith("onSet") || methodName.startsWith("onEnable") ||
                    methodName.startsWith("onDisable") || methodName.startsWith("onResult")) {
                    return true;
                }
            } else {
                // 保留一些可能是API的"on"方法
                if (!methodName.equals("oneway") && !methodName.startsWith("onGet") && 
                    !methodName.startsWith("onSet") && !methodName.startsWith("onEnable") &&
                    !methodName.startsWith("onDisable")) {
                    Log.debug("Filtering out callback method: " + methodName);
                    return false;
                }
            }
        }
        
        // 排除以"set"和"get"开头但没有参数或返回值的简单访问器方法
        if ((methodName.startsWith("set") && method.getParameterCount() == 0) ||
            (methodName.startsWith("get") && method.getReturnType().toString().equals("void"))) {
            Log.debug("Filtering out invalid accessor method: " + methodName);
            return false;
        }
        
        // 排除非公共方法（但抽象方法可能是protected）
        if (!method.isPublic() && !method.isAbstract()) {
            return false;
        }
        
        // 排除静态方法（通常不是实例API）
        if (method.isStatic()) {
            Log.debug("Filtering out static method: " + methodName);
            return false;
        }
        
        // 对于重要服务基类，放宽void无参方法的限制
        if (method.getReturnType().toString().equals("void") && method.getParameterCount() == 0) {
            if (isImportantServiceBase) {
                // 允许一些重要的无参操作方法
                if (methodName.startsWith("enable") || methodName.startsWith("disable") || 
                    methodName.startsWith("start") || methodName.startsWith("stop") ||
                    methodName.startsWith("clear") || methodName.startsWith("reset") ||
                    methodName.startsWith("init") || methodName.startsWith("sync")) {
                    return true;
                }
            } else {
                // 排除返回类型为void且无参数的简单方法（通常是内部方法）
                if (!methodName.startsWith("enable") && !methodName.startsWith("disable") && 
                    !methodName.startsWith("start") && !methodName.startsWith("stop") &&
                    !methodName.startsWith("clear") && !methodName.startsWith("reset")) {
                    Log.debug("Filtering out void no-args method: " + methodName);
                    return false;
                }
            }
        }
        
        // 排除package-private或protected的内部方法（除了抽象方法）
        try {
            if (declaringClassName.contains("$") && !declaringClassName.contains("Stub")) {
                // 内部类的方法，需要更严格的检查
                if (!methodName.matches("^[a-z][a-zA-Z0-9]*$") && !method.isAbstract()) {
                    // 方法名不符合标准API命名规范
                    Log.debug("Filtering out non-API method from inner class: " + methodName);
                    return false;
                }
            }
        } catch (Exception e) {
            Log.debug("Error checking method declaring class: " + e.getMessage());
        }
        
        Log.debug("Validated as API method: " + methodName + " from " + declaringClassName);
        return true;
    }

    /**
     * 验证是否为有效的Stub类
     */
    private boolean isValidStubClass(SootClass stubClass) {
        try {
            String stubClassName = stubClass.getName();
            
            // 基本检查：类名必须包含$Stub
            if (!stubClassName.contains("$Stub")) {
                return false;
            }
            
            // 检查是否是AIDL接口的Stub实现
            String expectedInterfaceName = stubClassName.replace("$Stub", "");
            SootClass aidlInterface = getSootClassSafely(expectedInterfaceName);
            if (aidlInterface != null && aidlInterface.isInterface()) {
                Log.debug("Found valid AIDL Stub: " + stubClassName + " for interface " + expectedInterfaceName);
                return true;
            }
            
            // 检查Stub类是否实现了相应的接口
            try {
                if (stubClass.getInterfaceCount() > 0) {
                    for (SootClass iface : stubClass.getInterfaces()) {
                        String ifaceName = iface.getName();
                        // 检查是否实现了相应的AIDL接口
                        if (ifaceName.equals(expectedInterfaceName) || 
                            (ifaceName.startsWith("android.") && ifaceName.contains("I") && !ifaceName.contains("$"))) {
                            Log.debug("Stub class " + stubClassName + " implements valid interface: " + ifaceName);
                            return true;
                        }
                    }
                }
            } catch (Exception e) {
                Log.debug("Error checking Stub interfaces: " + e.getMessage());
            }
            
            // 检查是否有典型的Stub类方法
            for (SootMethod method : stubClass.getMethods()) {
                String methodName = method.getName();
                if (methodName.equals("asInterface") || methodName.equals("asBinder") || 
                    methodName.equals("onTransact")) {
                    Log.debug("Found valid Stub class methods in: " + stubClassName);
                    return true;
                }
            }
            
        } catch (Exception e) {
            Log.debug("Error validating Stub class: " + e.getMessage());
        }
        
        return false;
    }
} 