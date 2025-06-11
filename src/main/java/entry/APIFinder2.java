package entry;

import soot.*;
import soot.jimple.*;
import soot.jimple.internal.*;
import soot.jimple.toolkits.ide.icfg.OnTheFlyJimpleBasedICFG;
import soot.options.Options;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.util.Chain;
import utils.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Future;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;

public class APIFinder2 {
    
    private Set<SootMethod> visitedMethods;
    private Map<SootClass, Set<SootMethod>> collectedServiceApis;
    private transient ExecutorService executorService;
    private final int numThreads = Runtime.getRuntime().availableProcessors();
    
    public APIFinder2() {
        // PackManager.v().runPacks();
        this.visitedMethods = Collections.synchronizedSet(new HashSet<>());
        this.collectedServiceApis = new ConcurrentHashMap<>();
        this.executorService = Executors.newFixedThreadPool(numThreads);
    }


    // format each line
    // com.android.phone.PhoneInterfaceManager: publish
    // className: methodName
    public HashSet<SootMethod> loadCacheFromFile(String cacheFilePath){
        HashSet<SootMethod> methods = new HashSet<>();
        try{
            File cacheFile = new File(cacheFilePath);
            if(cacheFile.exists()){
                BufferedReader reader = new BufferedReader(new FileReader(cacheFile));
                try {
                    // get each line
                    String line;
                    while((line = reader.readLine()) != null){
                        String[] parts = line.split(":");
                        if(parts.length == 2){
                            String className = parts[1].trim();
                            String signature = parts[0].trim();
                            //get sootclass
                            SootClass sootClass = getSootClassSafely(className);
                            if(sootClass != null){
                                // get class by signature
                                SootMethod sootMethod = sootClass.getMethod(signature);
                                if(sootMethod != null){
                                    methods.add(sootMethod);
                                } else {
                                    Log.warn("Method not found in class " + className + ": " + signature);
                                }
                            } else {
                                Log.warn("Class not found: " + className);
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
            Log.error("Error loading cache from file: " + e.getMessage());
        }
        return methods;
    }
    
    /**
     * Safely get SootClass, with special handling for inner classes
     * @param className Full class name (including inner classes like OuterClass$InnerClass)
     * @return SootClass if found, null otherwise
     */
    private SootClass getSootClassSafely(String className) {
        try {
            // First try direct lookup
            if (Scene.v().containsClass(className)) {
                return Scene.v().getSootClass(className);
            }
            
            // For inner classes, try alternative approaches
            if (className.contains("$")) {
                // Try to load the class first
                try {
                    Scene.v().loadClassAndSupport(className);
                    if (Scene.v().containsClass(className)) {
                        return Scene.v().getSootClass(className);
                    }
                } catch (Exception e) {
                    // Silent handling of inner class loading failures
                }
                
                // Try to find through outer class
                String outerClassName = className.substring(0, className.lastIndexOf('$'));
                try {
                    if (Scene.v().containsClass(outerClassName)) {
                        SootClass outerClass = Scene.v().getSootClass(outerClassName);
                        // Check if the inner class is available through the outer class
                        Scene.v().loadClassAndSupport(className);
                        if (Scene.v().containsClass(className)) {
                            return Scene.v().getSootClass(className);
                        }
                    }
                } catch (Exception e) {
                    // Silent handling of outer class resolution failures
                }
            }
            
            Log.warn("Class not found in Scene: " + className);
            return null;
            
        } catch (Exception e) {
            Log.error("Error getting SootClass for " + className + ": " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Find method in class with enhanced search including method signature matching
     * @param sootClass The class to search in
     * @param methodName Method name or simple signature to find
     * @return SootMethod if found, null otherwise
     */

    
    /**
     * Main entry method to collect all class APIs
     * @return HashMap with class names as keys and list of method signatures as values
     */
    public HashMap<String, HashSet<String>> collectAllClassApis(boolean useCache) {
        Log.info("Starting API collection process for Android server classes");
        
        this.visitedMethods.clear();
        this.collectedServiceApis.clear();
        if (this.executorService == null || this.executorService.isShutdown()) {
            this.executorService = Executors.newFixedThreadPool(numThreads);
        }
        HashSet<SootMethod> methodsWithPBS;
        if(useCache){
            methodsWithPBS = loadCacheFromFile("/home/devoke/decheck/decheck_data/cache/AOSP7.txt");

        }
        else{
            methodsWithPBS = collectMethodsWithPBS();
        }

        Log.info("Found " + methodsWithPBS.size() + " methods containing publishBinderService calls");
        collectServiceApis(methodsWithPBS);
        Log.info("Collected APIs from " + collectedServiceApis.size() + " service classes");
        
        HashMap<String, HashSet<String>> result = new HashMap<>();
        for (Map.Entry<SootClass, Set<SootMethod>> entry : collectedServiceApis.entrySet()) {
            String className = entry.getKey().getName();
            HashSet<String> methodSignatures = new HashSet<>();
            for (SootMethod method : entry.getValue()) {
                methodSignatures.add(method.getSubSignature());
            }
            result.put(className, methodSignatures);
        }
        
        Log.info("API collection completed successfully. Total classes: " + result.size());
        return result;
    }
    
    /**
     * Collect methods that contain publishBinderService or addService calls
     * @return HashSet of SootMethods that contain PBS calls
     */
    private HashSet<SootMethod> collectMethodsWithPBS() {
        Set<SootMethod> methodsWithPBS = Collections.synchronizedSet(new HashSet<>()); 
        List<Future<List<SootMethod>>> futures = new ArrayList<>();
        // int totalClassesScanned = 0; // These counters will be hard to maintain accurately in parallel
        // int totalMethodsScanned = 0;
        
        Chain<SootClass> allClasses = Scene.v().getApplicationClasses();
        for (SootClass sootClass : allClasses) {
            // totalClassesScanned++; // Avoid modifying shared counters in the loop dispatching part
            final SootClass currentClass = sootClass;
            Future<List<SootMethod>> future = executorService.submit(() -> {
                List<SootMethod> foundMethodsInClass = new ArrayList<>();
                List<SootMethod> methods = currentClass.getMethods();
                for (int i = 0; i < methods.size(); i++) {
                    SootMethod method = methods.get(i);
                    // totalMethodsScanned++; // This would need to be atomic if done here
                    
                    if (method.getName().equals("publishBinderService") || 
                        method.getName().equals("publishLocalService") || 
                        method.getName().equals("addService")) {
                        continue;
                    }

                    if (!method.hasActiveBody()) {
                        continue;
                    }

                    try {
                        Body body = method.retrieveActiveBody();
                        for (Unit unit : body.getUnits()) {
                            String StmtMethodName = ""; 
                            if(unit instanceof JInvokeStmt invokeStmt){
                                if(invokeStmt.containsInvokeExpr()){
                                    InvokeExpr invokeExpr = invokeStmt.getInvokeExpr();
                                    StmtMethodName = invokeExpr.getMethod().getName();
                                }
                            } else if(unit instanceof JAssignStmt assignStmt){
                                if(assignStmt.containsInvokeExpr()){
                                    InvokeExpr invokeExpr = assignStmt.getInvokeExpr();
                                    StmtMethodName = invokeExpr.getMethod().getName();
                                }
                            }
                            
                            if(StmtMethodName.equals("addService") || StmtMethodName.equals("publishBinderService")){
                                foundMethodsInClass.add(method);
                                break; 
                            }
                        }
                    } catch (Exception e) {
                        Log.warn("Error processing method " + method.getSignature() + " in parallel task (collectMethodsWithPBS): " + e.getMessage());
                    }
                }
                return foundMethodsInClass;
            });
            futures.add(future);
        }
        
        for (Future<List<SootMethod>> future : futures) {
            try {
                List<SootMethod> resultMethods = future.get();
                if (resultMethods != null && !resultMethods.isEmpty()) {
                    methodsWithPBS.addAll(resultMethods);
                }
            } catch (Exception e) {
                Log.error("Error retrieving PBS methods from future: " + e.getMessage());
            }
        }
        
        // Log.info("Scanned " + totalClassesScanned + " classes and " + totalMethodsScanned + " methods"); // Counts are not accurate anymore
        Log.info("Found " + methodsWithPBS.size() + " methods with PBS calls (processed in parallel)");
        return new HashSet<>(methodsWithPBS);
    }
    
    /**
     * Collect service APIs by analyzing call graphs of PBS methods
     * @param methodsWithPBS Methods that contain publishBinderService calls
     */
    private void collectServiceApis(HashSet<SootMethod> methodsWithPBS) {
        int processedMethods = 0;
        int successfulAnalyses = 0;
        
        for (SootMethod method : methodsWithPBS) {
            processedMethods++;
            boolean successCheck = false;
            
            if (method.getDeclaringClass().getName().equals("com.android.server.pm.ComponentResolver")) {
                continue;
            }
            
            try {
                int previousSize = this.collectedServiceApis.size();
                analyzeMethodCalls(method, method.getDeclaringClass());
                
                if (this.collectedServiceApis.size() > previousSize) {
                    successCheck = true;
                }
            } catch (Exception e) {
                Log.error("Error analyzing PBS method " + method.getSignature() + ": " + e.getMessage());
            }
            
            if (!successCheck) {
                SootClass declaringClass = method.getDeclaringClass();
                if (declaringClass.hasSuperclass() && 
                    declaringClass.getSuperclass().hasSuperclass() &&
                    declaringClass.getSuperclass().getSuperclass().getName().equals("android.os.Binder")) {
                    
                    SootClass serviceClass = declaringClass;
                    SootClass binderInterface = getBinderInterfaceFromServiceClass(serviceClass);
                    
                    if (binderInterface != null) {
                        Map.Entry<SootClass, Set<SootMethod>> resultEntry = getServiceAPIListWithClass(binderInterface, serviceClass);
                        if (!resultEntry.getValue().isEmpty()) {
                            // Ensure the Set value is thread-safe before putting into ConcurrentHashMap
                            this.collectedServiceApis.put(resultEntry.getKey(), Collections.synchronizedSet(new HashSet<>(resultEntry.getValue())));
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Analyze method calls using simple traversal (based on CheckFinder logic)
     * @param method Method to analyze
     * @param declaringClass Declaring class context
     */
    private void analyzeMethodCalls(SootMethod method, SootClass declaringClass) {
        OnTheFlyJimpleBasedICFG cfg = new OnTheFlyJimpleBasedICFG(method);
        
        if (!method.hasActiveBody()) {
            return;
        }
        
        try {
            Body body = method.retrieveActiveBody();
            Stack<SootMethod> callStack = new Stack<>();
            HashSet<SootMethod> localVisited = new HashSet<>();
            int pbsCallsFound = 0;
            
            // First pass: collect all method calls in current method and check for PBS calls
            for (Unit unit : body.getUnits()) {
                if (unit instanceof JAssignStmt) {
                    JAssignStmt assignStmt = (JAssignStmt) unit;
                    if (assignStmt.containsInvokeExpr()) {
                        InvokeExpr invokeExpr = assignStmt.getInvokeExpr();
                        SootMethod callee = invokeExpr.getMethod();
                        String methodName = callee.getName();
                        String declaringClassName = callee.getDeclaringClass().getName();
                        
                        // Check if this is a PBS call
                        if (methodName.equals("publishBinderService") || methodName.equals("addService")) {
                            pbsCallsFound++;
                            
                            if (!callee.getDeclaringClass().getName().contains("LocalServices")) {
                                // Analyze the second parameter (service class)
                                if (invokeExpr.getArgCount() >= 2) {
                                    Value secondParam = invokeExpr.getArg(1);
                                    analyzeServiceParameter(secondParam, body, declaringClass);
                                } else {
                                    Log.warn("PBS call has insufficient arguments: " + invokeExpr.getArgCount());
                                }
                            }
                        } else {
                            // Add to call stack for further analysis
                            callStack.push(callee);
                        }
                    }
                } else if (unit instanceof JInvokeStmt) {
                    JInvokeStmt invokeStmt = (JInvokeStmt) unit;
                    InvokeExpr invokeExpr = invokeStmt.getInvokeExpr();
                    SootMethod callee = invokeExpr.getMethod();
                    String methodName = callee.getName();
                    String declaringClassName = callee.getDeclaringClass().getName();
                    
                    // Check if this is a PBS call
                    if (methodName.equals("publishBinderService") || methodName.equals("addService")) {
                        pbsCallsFound++;
                        
                        if (!callee.getDeclaringClass().getName().contains("LocalServices")) {
                            // Analyze the second parameter (service class)
                            if (invokeExpr.getArgCount() >= 2) {
                                Value secondParam = invokeExpr.getArg(1);
                                analyzeServiceParameter(secondParam, body, declaringClass);
                            } else {
                                Log.warn("PBS call has insufficient arguments: " + invokeExpr.getArgCount());
                            }
                        }
                    } else {
                        // Add to call stack for further analysis
                        callStack.push(callee);
                    }
                }
            }
            
            // Second pass: recursively analyze called methods (similar to CheckFinder)
            while (!callStack.isEmpty()) {
                SootMethod callee = callStack.pop();
                
                // Avoid infinite loops
                if (localVisited.contains(callee) || this.visitedMethods.contains(callee)) {
                    continue;
                }
                
                localVisited.add(callee);
                this.visitedMethods.add(callee);
                
                // Only analyze methods from relevant classes (similar to StaticAPIs.shouldAnalyze)
                if (callee.getDeclaringClass().getName().startsWith("com.android.server.")) {
                    analyzeMethodCalls(callee, callee.getDeclaringClass());
                }
            }
            
        } catch (Exception e) {
            Log.error("Error analyzing method calls for " + method.getSignature() + ": " + e.getMessage());
        }
    }
    
    /**
     * Analyze service parameter to extract service class information
     */
    private void analyzeServiceParameter(Value secondParam, Body body, SootClass declaringClass) {
        // Use enhanced definition analysis for JimpleLocal variables
        int previousSize = this.collectedServiceApis.size();
        findServiceClassFromParameter(secondParam, body, declaringClass);
        
        if (this.collectedServiceApis.size() == previousSize) {
            // Try direct analysis if it's already a known type
            if (secondParam instanceof JInstanceFieldRef) {
                getInsResolution(secondParam, declaringClass);
            } else if (secondParam.getType() instanceof RefType) {
                RefType refType = (RefType) secondParam.getType();
                SootClass serviceClass = refType.getSootClass();
                if (serviceClass != null) {
                    if (serviceClass.getName().contains("$")) {
                        // Silent processing of inner class service
                    }
                    SootClass binderInterface = getBinderInterfaceFromServiceClass(serviceClass);
                    if (binderInterface != null) {
                        Map.Entry<SootClass, Set<SootMethod>> result = getServiceAPIListWithClass(binderInterface, serviceClass);
                        if (!result.getValue().isEmpty()) {
                            this.collectedServiceApis.put(result.getKey(), Collections.synchronizedSet(new HashSet<>(result.getValue())));
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Enhanced method to find service class from parameter using def-use analysis
     */
    private void findServiceClassFromParameter(Value param, Body body, SootClass declaringClass) {
        // Strategy 1: Direct type analysis
        if (param.getType() instanceof RefType) {
            RefType refType = (RefType) param.getType();
            SootClass paramClass = refType.getSootClass();
            analyzeServiceClass(paramClass);
        }
        
        // Strategy 2: Definition chain analysis for JimpleLocal
        if (param instanceof JimpleLocal) {
            analyzeLocalVariableDefinitions(param, body, declaringClass);
        }
        
        // Strategy 3: Field reference analysis
        if (param instanceof JInstanceFieldRef) {
            getInsResolution(param, declaringClass);
        }
    }
    
    /**
     * Analyze all definitions of a local variable to find service class
     */
    private void analyzeLocalVariableDefinitions(Value localVar, Body body, SootClass declaringClass) {
        // Find all assignments to this local variable
        for (Unit unit : body.getUnits()) {
            if (unit instanceof JAssignStmt) {
                JAssignStmt assignStmt = (JAssignStmt) unit;
                
                if (assignStmt.getLeftOp().equals(localVar)) {
                    Value rightOp = assignStmt.getRightOp();
                    analyzeDefinitionValue(rightOp, body, declaringClass);
                }
            }
        }
    }
    
    /**
     * Analyze a definition value (right-hand side of assignment)
     */
    private void analyzeDefinitionValue(Value value, Body body, SootClass declaringClass) {
        if (value instanceof JNewExpr) {
            newInsResolutionCase1((JNewExpr) value);
        } else if (value instanceof JInstanceFieldRef) {
            getInsResolution(value, declaringClass);
        } else if (value instanceof InvokeExpr) {
            invokeInsResolution((InvokeExpr) value, declaringClass);
        } else if (value instanceof JimpleLocal) {
            // Recursive analysis for chained assignments
            analyzeLocalVariableDefinitions(value, body, declaringClass);
        } else {
            Log.warn("Unknown definition value type: " + value.getClass().getSimpleName() + " - " + value);
        }
    }
    
    /**
     * Analyze a service class to extract APIs
     */
    private void analyzeServiceClass(SootClass serviceClass) {
        if (serviceClass == null) {
            return;
        }
        
        SootClass binderInterface = getBinderInterfaceFromServiceClass(serviceClass);
        if (binderInterface != null) {
            Map.Entry<SootClass, Set<SootMethod>> result = getServiceAPIListWithClass(binderInterface, serviceClass);
            if (!result.getValue().isEmpty()) {
                this.collectedServiceApis.put(result.getKey(), Collections.synchronizedSet(new HashSet<>(result.getValue())));
            }
        }
    }
    
    /**
     * Handle field reference resolution (combines WALA's getInsResolutionCase1 and Case2)
     */
    private void getInsResolution(Value fieldRef, SootClass declaringClass) {
        if (fieldRef instanceof JInstanceFieldRef) {
            JInstanceFieldRef instanceFieldRef = (JInstanceFieldRef) fieldRef;
            SootField field = instanceFieldRef.getField();
            Type fieldType = field.getType();
            
            // Case 2: Direct field type resolution
            if (fieldType instanceof RefType) {
                RefType refType = (RefType) fieldType;
                SootClass serviceClass = refType.getSootClass();
                
                if (serviceClass != null) {
                    SootClass binderInterface = getBinderInterfaceFromServiceClass(serviceClass);
                    if (binderInterface != null) {
                        Map.Entry<SootClass, Set<SootMethod>> result = getServiceAPIListWithClass(binderInterface, serviceClass);
                        if (!result.getValue().isEmpty()) {
                            this.collectedServiceApis.put(result.getKey(), Collections.synchronizedSet(new HashSet<>(result.getValue())));
                        }
                    }
                }
            }
            
            // Case 1: Field type is IBinder or Stub, need to find assignment in <init>
            if (fieldType.toString().equals("android.os.IBinder") || fieldType.toString().contains("$Stub")) {
                // Try to get all classes that might contain anonymous implementations
                if (fieldType.toString().equals("android.os.IBinder")) {
                    // Look for anonymous classes in the same package that might be the implementation
                    findAnonymousStubImplementations(field, declaringClass);
                }
                
                getInsResolutionCase1(field, declaringClass);
            }
        }
    }
    
    /**
     * Find anonymous Stub implementations for IBinder fields
     */
    private void findAnonymousStubImplementations(SootField targetField, SootClass declaringClass) {
        // Get all classes in the scene
        Chain<SootClass> allClasses = Scene.v().getApplicationClasses();
        String declaringClassName = declaringClass.getName();
        
        for (SootClass sootClass : allClasses) {
            String className = sootClass.getName();
            
            // Look for anonymous classes that belong to the declaring class
            // Pattern: com.android.server.trust.TrustManagerService$1, $2, etc.
            if (className.startsWith(declaringClassName + "$") && isAnonymousClass(sootClass)) {
                // Check if this anonymous class extends a Stub
                if (sootClass.hasSuperclass()) {
                    SootClass superClass = sootClass.getSuperclass();
                    
                    if (superClass.getName().contains("$Stub")) {
                        // Extract the interface from the Stub
                        SootClass binderInterface = extractInterfaceFromStubClass(superClass);
                        if (binderInterface != null) {
                            Map.Entry<SootClass, Set<SootMethod>> result = getServiceAPIListWithClass(binderInterface, sootClass);
                            if (!result.getValue().isEmpty()) {
                                this.collectedServiceApis.put(result.getKey(), Collections.synchronizedSet(new HashSet<>(result.getValue())));
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * GET INSTRUCTION RESOLUTION CASE 1 - Find assignment in <init> method
     */
    private void getInsResolutionCase1(SootField targetField, SootClass declaringClass) {
        // Look for <init> or <clinit> methods
        for (SootMethod method : declaringClass.getMethods()) {
            if (method.getName().equals("<init>") || method.getName().equals("<clinit>")) {
                if (!method.hasActiveBody()) {
                    continue;
                }
                
                Body body = method.retrieveActiveBody();
                int targetFieldAssignmentCount = 0;
                
                // Find assignment to target field
                for (Unit unit : body.getUnits()) {
                    if (unit instanceof JAssignStmt) {
                        JAssignStmt assignStmt = (JAssignStmt) unit;
                        Value leftOp = assignStmt.getLeftOp();
                        Value rightOp = assignStmt.getRightOp();
                        
                        if (leftOp instanceof JInstanceFieldRef) {
                            JInstanceFieldRef fieldRef = (JInstanceFieldRef) leftOp;
                            SootField field = fieldRef.getField();
                            
                            if (fieldRef.getField().equals(targetField)) {
                                targetFieldAssignmentCount++;
                                
                                // Handle different types of right-hand side expressions
                                if (rightOp instanceof JNewExpr) {
                                    newInsResolutionCase1((JNewExpr) rightOp);
                                } else if (rightOp instanceof JimpleLocal) {
                                    // Trace the local variable definition chain
                                    analyzeLocalVariableDefinitions(rightOp, body, declaringClass);
                                } else if (rightOp instanceof InvokeExpr) {
                                    invokeInsResolution((InvokeExpr) rightOp, declaringClass);
                                } else if (rightOp instanceof JInstanceFieldRef) {
                                    getInsResolution(rightOp, declaringClass);
                                } else {
                                    Log.warn("Unsupported field assignment type: " + rightOp.getClass().getSimpleName() + " - " + rightOp);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * NEW INSTRUCTION RESOLUTION CASE 1 - Extract service class from new expression
     */
    private void newInsResolutionCase1(JNewExpr newExpr) {
        RefType type = (RefType) newExpr.getType();
        SootClass serviceClass = type.getSootClass();
        
        if (serviceClass != null) {
            // Check if this is an anonymous inner class
            if (isAnonymousClass(serviceClass)) {
                // For anonymous classes, check if the superclass is a Stub class
                if (serviceClass.hasSuperclass()) {
                    SootClass superClass = serviceClass.getSuperclass();
                    
                    if (superClass.getName().contains("$Stub")) {
                        // Extract the interface from the Stub class
                        SootClass binderInterface = extractInterfaceFromStubClass(superClass);
                        if (binderInterface != null) {
                            Map.Entry<SootClass, Set<SootMethod>> result = getServiceAPIListWithClass(binderInterface, serviceClass);
                            if (!result.getValue().isEmpty()) {
                                this.collectedServiceApis.put(result.getKey(), Collections.synchronizedSet(new HashSet<>(result.getValue())));
                                return;
                            }
                        }
                    }
                    
                    // Fallback: try normal binder interface search on superclass
                    SootClass binderInterface = getBinderInterfaceFromServiceClass(superClass);
                    if (binderInterface != null) {
                        Map.Entry<SootClass, Set<SootMethod>> result = getServiceAPIListWithClass(binderInterface, serviceClass);
                        if (!result.getValue().isEmpty()) {
                            this.collectedServiceApis.put(result.getKey(), Collections.synchronizedSet(new HashSet<>(result.getValue())));
                            return;
                        }
                    }
                }
            }
            
            // Normal processing for non-anonymous classes
            SootClass binderInterface = getBinderInterfaceFromServiceClass(serviceClass);
            if (binderInterface != null) {
                Map.Entry<SootClass, Set<SootMethod>> result = getServiceAPIListWithClass(binderInterface, serviceClass);
                if (!result.getValue().isEmpty()) {
                    this.collectedServiceApis.put(result.getKey(), Collections.synchronizedSet(new HashSet<>(result.getValue())));
                }
            } else {
                Log.warn("No binder interface found for service class: " + serviceClass.getName());
            }
        }
    }
    
    /**
     * INVOKE INSTRUCTION RESOLUTION - Handle different invoke cases
     */
    private void invokeInsResolution(InvokeExpr invokeExpr, SootClass declaringClass) {
        // Case 1: Service class as declaring class
        SootClass serviceClass = invokeExpr.getMethod().getDeclaringClass();
        if (serviceClass != null) {
            SootClass binderInterface = getBinderInterfaceFromServiceClass(serviceClass);
            if (binderInterface != null) {
                Map.Entry<SootClass, Set<SootMethod>> result = getServiceAPIListWithClass(binderInterface, serviceClass);
                if (!result.getValue().isEmpty()) {
                    this.collectedServiceApis.put(result.getKey(), Collections.synchronizedSet(new HashSet<>(result.getValue())));
                }
            }
        }
        
        // Case 2: asBinder method call
        if (invokeExpr.getMethod().getName().equals("asBinder")) {
            invokeInsResolutionCase2(invokeExpr, declaringClass);
        }
        
        // Case 3: Method returns Stub type
        Type returnType = invokeExpr.getMethod().getReturnType();
        if (returnType.toString().contains("$Stub")) {
            invokeInsResolutionCase3(invokeExpr);
        }
    }
    
    /**
     * INVOKE INSTRUCTION RESOLUTION CASE 2 - asBinder calls
     */
    private void invokeInsResolutionCase2(InvokeExpr invokeExpr, SootClass declaringClass) {
        // Similar to getInsResolutionCase1, look for field assignments in <init>
        Type targetType = invokeExpr.getMethod().getDeclaringClass().getType();
        
        for (SootMethod method : declaringClass.getMethods()) {
            if (method.getName().equals("<init>") || method.getName().equals("<clinit>")) {
                if (!method.hasActiveBody()) {
                    continue;
                }
                
                Body body = method.retrieveActiveBody();
                
                for (Unit unit : body.getUnits()) {
                    if (unit instanceof JAssignStmt) {
                        JAssignStmt assignStmt = (JAssignStmt) unit;
                        
                        if (assignStmt.getLeftOp() instanceof JInstanceFieldRef) {
                            JInstanceFieldRef fieldRef = (JInstanceFieldRef) assignStmt.getLeftOp();
                            
                            if (fieldRef.getField().getType().equals(targetType)) {
                                Value rightOp = assignStmt.getRightOp();
                                
                                if (rightOp instanceof JNewExpr) {
                                    newInsResolutionCase1((JNewExpr) rightOp);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * INVOKE INSTRUCTION RESOLUTION CASE 3 - Method returns Stub class
     */
    private void invokeInsResolutionCase3(InvokeExpr invokeExpr) {
        Type returnType = invokeExpr.getMethod().getReturnType();
        if (returnType instanceof RefType) {
            SootClass stubClass = ((RefType) returnType).getSootClass();
            
            if (stubClass != null) {
                Log.debug("Found stub class: " + stubClass.getName());
                
                // Find service class that extends this stub
                Chain<SootClass> allClasses = Scene.v().getApplicationClasses();
                for (SootClass sootClass : allClasses) {
                    if (sootClass.hasSuperclass() && sootClass.getSuperclass().equals(stubClass)) {
                        SootClass serviceClass = sootClass;
                        SootClass binderInterface = getBinderInterfaceFromServiceClass(serviceClass);
                        
                        if (binderInterface != null) {
                            Map.Entry<SootClass, Set<SootMethod>> result = getServiceAPIListWithClass(binderInterface, serviceClass);
                            if (!result.getValue().isEmpty()) {
                                this.collectedServiceApis.put(result.getKey(), Collections.synchronizedSet(new HashSet<>(result.getValue())));
                                Log.info("Case 3 - Found service class from Stub return type: " + result.getKey().getName());
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Get service API method list by matching binder interface methods with service class methods
     * Returns a map entry where key is the actual service class to use, and value is the API methods
     */
    private Map.Entry<SootClass, Set<SootMethod>> getServiceAPIListWithClass(SootClass binderInterface, SootClass serviceClass) {
        Set<SootMethod> apiList = new HashSet<>();
        
        // Check if service class is abstract, find concrete implementation
        SootClass originalServiceClass = serviceClass;
        SootClass actualServiceClass = serviceClass; // This will be the class we use as key
        
        if (serviceClass.isAbstract()) {
            SootClass concreteImpl = findConcreteImplementation(serviceClass);
            if (concreteImpl != null) {
                serviceClass = concreteImpl; // Use for API extraction
                actualServiceClass = concreteImpl; // Use as key
            } else {
                Log.warn("No concrete implementation found for abstract class: " + originalServiceClass.getName());
                // Continue with abstract class, might still find some matches
                actualServiceClass = originalServiceClass;
            }
        }
        
        // Track matching statistics
        int exactMatches = 0;
        int nameParamMatches = 0;
        int nameOnlyMatches = 0;
        int typeCompatibleMatches = 0;
        int unmatched = 0;
        
        // Match methods between binder interface and service class
        for (SootMethod interfaceMethod : binderInterface.getMethods()) {
            // Skip synthetic methods and constructors
            if (interfaceMethod.getName().startsWith("<") || interfaceMethod.getName().equals("asBinder")) {
                continue;
            }
            
            boolean found = false;
            String matchType = "";
            
            // Collect all potential matches for this interface method
            List<SootMethod> potentialMatches = new ArrayList<>();
            
            for (SootMethod serviceMethod : serviceClass.getMethods()) {
                // Skip constructors and synthetic methods
                if (serviceMethod.getName().startsWith("<")) {
                    continue;
                }
                
                // Try multiple matching strategies
                boolean methodMatches = false;
                String currentMatchType = "";
                
                // Strategy 1: Exact signature match
                if (interfaceMethod.getName().equals(serviceMethod.getName()) &&
                    interfaceMethod.getSignature().equals(serviceMethod.getSignature())) {
                    methodMatches = true;
                    currentMatchType = "exact";
                }
                // Strategy 2: Name and parameter count match
                else if (interfaceMethod.getName().equals(serviceMethod.getName()) &&
                         interfaceMethod.getParameterCount() == serviceMethod.getParameterCount()) {
                    methodMatches = true;
                    currentMatchType = "name+paramcount";
                }
                // Strategy 3: Name match with compatible parameter types
                else if (interfaceMethod.getName().equals(serviceMethod.getName()) &&
                         areParameterTypesCompatible(interfaceMethod, serviceMethod)) {
                    methodMatches = true;
                    currentMatchType = "name+typecompat";
                }
                // Strategy 4: Just name match (for simple cases)
                else if (interfaceMethod.getName().equals(serviceMethod.getName())) {
                    methodMatches = true;
                    currentMatchType = "nameonly";
                }
                
                if (methodMatches) {
                    potentialMatches.add(serviceMethod);
                    if (matchType.isEmpty() || isHigherPriorityMatch(currentMatchType, matchType)) {
                        matchType = currentMatchType;
                    }
                    found = true;
                    // Don't break here - collect all potential matches to handle overloaded methods
                }
            }
            
            // Add all potential matches to API list
            if (!potentialMatches.isEmpty()) {
                for (SootMethod match : potentialMatches) {
                    apiList.add(match);
                }
                
                // Update statistics
                switch (matchType) {
                    case "exact": exactMatches++; break;
                    case "name+paramcount": nameParamMatches++; break;
                    case "name+typecompat": typeCompatibleMatches++; break;
                    case "nameonly": nameOnlyMatches++; break;
                }
            }
            
            if (!found) {
                unmatched++;
                Log.warn("No match found for interface method: " + interfaceMethod.getName());
            }
        }
        
        Log.info("API matching completed for " + actualServiceClass.getName() + ": " + 
                 apiList.size() + " total methods (" + exactMatches + " exact, " + 
                 nameParamMatches + " name+param, " + unmatched + " unmatched)");
        
        // Return both the actual service class and the API methods
        return new AbstractMap.SimpleEntry<>(actualServiceClass, apiList);
    }
    
    /**
     * Get service API method list by matching binder interface methods with service class methods
     * This is a wrapper method that maintains backward compatibility
     */
    private Set<SootMethod> getServiceAPIList(SootClass binderInterface, SootClass serviceClass) {
        Map.Entry<SootClass, Set<SootMethod>> result = getServiceAPIListWithClass(binderInterface, serviceClass);
        return result.getValue();
    }
    
    /**
     * Find concrete implementation of an abstract service class
     */
    private SootClass findConcreteImplementation(SootClass abstractClass) {
        Log.info("Searching for concrete implementation of: " + abstractClass.getName());
        
        Chain<SootClass> allClasses = Scene.v().getApplicationClasses();
        for (SootClass sootClass : allClasses) {
            if (sootClass.hasSuperclass() && sootClass.getSuperclass().equals(abstractClass)) {
                if (!sootClass.isAbstract()) {
                    Log.info("Found concrete implementation: " + sootClass.getName());
                    return sootClass;
                }
            }
        }
        
        // Try searching for classes that implement the same interface
        if (abstractClass.hasSuperclass()) {
            SootClass parentClass = abstractClass.getSuperclass();
            for (SootClass sootClass : allClasses) {
                if (sootClass.hasSuperclass() && 
                    sootClass.getSuperclass().equals(parentClass) && 
                    !sootClass.isAbstract() &&
                    !sootClass.equals(abstractClass)) {
                    Log.info("Found sibling concrete implementation: " + sootClass.getName());
                    return sootClass;
                }
            }
        }
        
        Log.warn("No concrete implementation found for: " + abstractClass.getName());
        return null;
    }
    
    /**
     * Check if parameter types between two methods are compatible
     */
    private boolean areParameterTypesCompatible(SootMethod interfaceMethod, SootMethod serviceMethod) {
        if (interfaceMethod.getParameterCount() != serviceMethod.getParameterCount()) {
            return false;
        }
        
        for (int i = 0; i < interfaceMethod.getParameterCount(); i++) {
            Type interfaceParamType = interfaceMethod.getParameterType(i);
            Type serviceParamType = serviceMethod.getParameterType(i);
            
            // Exact type match
            if (interfaceParamType.equals(serviceParamType)) {
                continue;
            }
            
            // Check if types are compatible (handling primitive vs wrapper types)
            if (areTypesCompatible(interfaceParamType, serviceParamType)) {
                continue;
            }
            
            // Types are not compatible
            Log.debug("Parameter type mismatch at index " + i + ": " + 
                     interfaceParamType + " vs " + serviceParamType);
            return false;
        }
        
        return true;
    }
    
    /**
     * Check if two types are compatible (including primitive/wrapper conversion)
     */
    private boolean areTypesCompatible(Type type1, Type type2) {
        if (type1.equals(type2)) {
            return true;
        }
        
        // Handle primitive and wrapper type conversions
        String type1Str = type1.toString();
        String type2Str = type2.toString();
        
        // Primitive to wrapper mappings
        if ((type1Str.equals("int") && type2Str.equals("java.lang.Integer")) ||
            (type1Str.equals("java.lang.Integer") && type2Str.equals("int")) ||
            (type1Str.equals("boolean") && type2Str.equals("java.lang.Boolean")) ||
            (type1Str.equals("java.lang.Boolean") && type2Str.equals("boolean")) ||
            (type1Str.equals("long") && type2Str.equals("java.lang.Long")) ||
            (type1Str.equals("java.lang.Long") && type2Str.equals("long")) ||
            (type1Str.equals("float") && type2Str.equals("java.lang.Float")) ||
            (type1Str.equals("java.lang.Float") && type2Str.equals("float")) ||
            (type1Str.equals("double") && type2Str.equals("java.lang.Double")) ||
            (type1Str.equals("java.lang.Double") && type2Str.equals("double"))) {
            return true;
        }
        
        // Check for inheritance relationship
        if (type1 instanceof RefType && type2 instanceof RefType) {
            try {
                SootClass class1 = ((RefType) type1).getSootClass();
                SootClass class2 = ((RefType) type2).getSootClass();
                
                // Check if one is a subclass of the other
                return isSubclassOf(class1, class2) || isSubclassOf(class2, class1);
            } catch (Exception e) {
                Log.debug("Error checking inheritance relationship: " + e.getMessage());
            }
        }
        
        return false;
    }
    
    /**
     * Check if class1 is a subclass of class2
     */
    private boolean isSubclassOf(SootClass class1, SootClass class2) {
        if (class1.equals(class2)) {
            return true;
        }
        
        try {
            if (class1.hasSuperclass()) {
                return isSubclassOf(class1.getSuperclass(), class2);
            }
        } catch (Exception e) {
            Log.debug("Error checking superclass relationship: " + e.getMessage());
        }
        
        return false;
    }
    
    /**
     * Determine if one match type has higher priority than another
     */
    private boolean isHigherPriorityMatch(String newMatchType, String currentMatchType) {
        // Priority order: exact > name+typecompat > name+paramcount > nameonly
        int newPriority = getMatchPriority(newMatchType);
        int currentPriority = getMatchPriority(currentMatchType);
        
        return newPriority > currentPriority;
    }
    
    /**
     * Get numeric priority for match types
     */
    private int getMatchPriority(String matchType) {
        switch (matchType) {
            case "exact": return 4;
            case "name+typecompat": return 3;
            case "name+paramcount": return 2;
            case "nameonly": return 1;
            default: return 0;
        }
    }
    
    /**
     * Get binder interface from service class by traversing inheritance hierarchy
     */
    private SootClass getBinderInterfaceFromServiceClass(SootClass serviceClass) {
        if (serviceClass == null) {
            Log.warn("Service class is null, cannot find binder interface");
            return null;
        }
        
        // Special handling for Stub classes - extract interface directly
        if (serviceClass.getName().contains("$Stub")) {
            SootClass extractedInterface = extractInterfaceFromStubClass(serviceClass);
            if (extractedInterface != null) {
                return extractedInterface;
            }
        }
        
        // Special handling for inner classes
        if (serviceClass.getName().contains("$")) {
            // First try to find interface in the inner class itself
            SootClass result = findBinderInterfaceInClass(serviceClass);
            if (result != null) {
                return result;
            }
            
            // If not found, try the outer class
            String outerClassName = serviceClass.getName().substring(0, serviceClass.getName().lastIndexOf('$'));
            SootClass outerClass = getSootClassSafely(outerClassName);
            if (outerClass != null) {
                result = findBinderInterfaceInClass(outerClass);
                if (result != null) {
                    return result;
                }
            }
        } else {
            // Regular class processing
            return findBinderInterfaceInClass(serviceClass);
        }
        
        Log.warn("No binder interface found for service class: " + serviceClass.getName());
        return null;
    }
    
    /**
     * Helper method to find binder interface in a specific class
     */
    private SootClass findBinderInterfaceInClass(SootClass serviceClass) {
        SootClass superClass = null;
        if (serviceClass.hasSuperclass()) {
            superClass = serviceClass.getSuperclass();
        }
        
        if (superClass != null && !superClass.getInterfaces().isEmpty()) {
            for (SootClass interfaceClass : superClass.getInterfaces()) {
                // Check if this interface extends IInterface
                if (!interfaceClass.getInterfaces().isEmpty()) {
                    for (SootClass superInterface : interfaceClass.getInterfaces()) {
                        if (superInterface.getName().equals("android.os.IInterface")) {
                            return interfaceClass;
                        }
                    }
                }
            }
        } else {
            Log.warn("Superclass is null or has no interfaces for class: " + serviceClass.getName());
        }
        
        return null;
    }
    
    /**
     * Extract AIDL interface from Stub class
     * For example: ITrustManager$Stub -> ITrustManager
     */
    private SootClass extractInterfaceFromStubClass(SootClass stubClass) {
        String stubClassName = stubClass.getName();
        
        // Check if this is actually a Stub class
        if (!stubClassName.contains("$Stub")) {
            Log.warn("Class is not a Stub class: " + stubClassName);
            return null;
        }
        
        // Extract interface name by removing $Stub suffix
        String interfaceName = stubClassName.replace("$Stub", "");
        
        // Try to get the interface class
        try {
            if (Scene.v().containsClass(interfaceName)) {
                SootClass interfaceClass = Scene.v().getSootClass(interfaceName);
                
                // Verify this is actually an AIDL interface (should extend IInterface)
                if (isAIDLInterface(interfaceClass)) {
                    return interfaceClass;
                } else {
                    Log.warn("Class exists but is not an AIDL interface: " + interfaceName);
                }
            } else {
                Log.warn("Interface class not found in scene: " + interfaceName);
            }
        } catch (Exception e) {
            Log.error("Error getting interface class: " + interfaceName + " - " + e.getMessage());
        }
        
        return null;
    }
    
    /**
     * Check if a class is an anonymous inner class
     * Anonymous classes typically have names like OuterClass$1, OuterClass$2, etc.
     */
    private boolean isAnonymousClass(SootClass sootClass) {
        String className = sootClass.getName();
        // Check if class name contains $ followed by digits (anonymous class pattern)
        if (className.contains("$")) {
            String innerPart = className.substring(className.lastIndexOf('$') + 1);
            try {
                Integer.parseInt(innerPart);
                return true; // Successfully parsed as number, it's an anonymous class
            } catch (NumberFormatException e) {
                return false; // Not a number, not an anonymous class
            }
        }
        return false;
    }
    
    /**
     * Check if a class is an AIDL interface (extends android.os.IInterface)
     */
    private boolean isAIDLInterface(SootClass sootClass) {
        try {
            // Check if the class implements IInterface directly or indirectly
            return implementsInterface(sootClass, "android.os.IInterface");
        } catch (Exception e) {
            // Silent handling of AIDL interface check failures
            return false;
        }
    }
    
    /**
     * Check if a class implements a specific interface (directly or indirectly)
     */
    private boolean implementsInterface(SootClass sootClass, String interfaceName) {
        // Check direct interfaces
        for (SootClass interfaceClass : sootClass.getInterfaces()) {
            if (interfaceClass.getName().equals(interfaceName)) {
                return true;
            }
            // Recursively check super interfaces
            if (implementsInterface(interfaceClass, interfaceName)) {
                return true;
            }
        }
        
        // Check superclass interfaces
        if (sootClass.hasSuperclass()) {
            return implementsInterface(sootClass.getSuperclass(), interfaceName);
        }
        
        return false;
    }

    public void shutdownExecutor() {
        if (this.executorService != null && !this.executorService.isShutdown()) {
            Log.info("Shutting down executor service for " + this.getClass().getSimpleName());
            this.executorService.shutdown();
            try {
                if (!this.executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    this.executorService.shutdownNow();
                    if (!this.executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                        Log.error("Executor service did not terminate for " + this.getClass().getSimpleName());
                    }
                }
            } catch (InterruptedException ie) {
                this.executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}