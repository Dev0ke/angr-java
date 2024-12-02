package main;

import accessControl.CheckAppOpAPI;
import accessControl.CheckPermissionAPI;
import accessControl.CheckPidAPI;
import accessControl.CheckUidAPI;
import module.APIFinder;
import module.PathAnalyze;
import soot.SootMethod;
import utils.Log;
import init.Config;

import java.util.HashMap;
import java.util.List;

import static utils.Log.printTime;

public class Main {

    public static void preProcess() {

        Log.debug("preProcess");
        CGgen cg = new CGgen("com.android.server.audio.AudioService","setEncodedSurroundMode");
        try {
            cg.genCG();
        } catch (Exception e) {
            //get exception String
            String errorString = e.toString();
            //if 'but got:' in exception String
            if (errorString.contains("but got:")) {
                //print 'but got:' in exception String
                String wrongClass = errorString.substring(errorString.indexOf("but got:")+9);
                Log.error("[-] " + wrongClass);
                rmFilewithPrefix(Config.outputJimplePath,wrongClass);
            } else {
                //print exception String
                Log.error("[-] " + errorString);
            }

        }
        cg.traverseCG();
    }

    public static void init() {
        CheckPermissionAPI.init();
        CheckUidAPI.init();
        CheckPidAPI.init();
        CheckAppOpAPI.init();
    }


    public static void multi(){

        HashMap<String,List<String>> apiList = APIFinder.findAPI();
        int count = 0;
        int success = 0;

        for (String className : apiList.keySet()) {
            List<String> methodList = apiList.get(className);
            CGgen cg = new CGgen(className,methodList.get(0));
            cg.genCG();
            for (String methodName : methodList) {
                Log.info("---------------------------- " + className  + '.' + methodName + "---------------------------------------------");

                count++;
                try {
                    SootMethod m = cg.getMethodByName(className,methodName);
                    PathAnalyze pa = new PathAnalyze(m);
                    pa.startAnalyze();
                    success++;
                } catch (Exception e) {
                    Log.error("[-] Analyse error: " + e.toString());

                }

            }
            Log.info("Total API: " + count + " Success: " + success);
        }
        Log.info("Total API: " + count + " Success: " + success);

    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        init();


//        CGgen cg = new CGgen("com.android.server.pm.UserManagerService","setUserRestriction");
//        printTime("GenCG",startTime);
//        PathAnalyze pa = new PathAnalyze(cg.getMethodByName("com.android.server.audio.AudioService","forceVolumeControlStream")); //TODO FIX
       multi();
//        testOne("com.android.server.pm.dex.ArtManagerService","isRuntimeProfilingEnabled");
//        testOne("com.android.server.BinaryTransparencyService$UpdateMeasurementsJobService","onStartJob");
//        testOne("com.android.server.print.RemotePrintService.RemotePrintServiceClient","onPrintersAdded");
        //end ==========================================================================================================

    }



    public static void testOne(String className,String methodName){
        CGgen cg = new CGgen(className,methodName);
        cg.genCG();
        PathAnalyze pa = new PathAnalyze(cg.getMethodByName(className,methodName));
        pa.startAnalyze();
    }

    public static void rmFilewithPrefix(String path ,String prefix){
        java.io.File file = new java.io.File(path);
        java.io.File[] files = file.listFiles();
        for (java.io.File f: files){
            if(f.getName().startsWith(prefix)){
                f.delete();
            }
        }

    }


}