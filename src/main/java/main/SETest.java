package main;

import accessControl.CheckPermissionAPI;
import main.CGgen;
import module.PathAnalyze;
import utils.Log;
import init.Config;
import utils.ZipUtils;
import java.io.IOException;

public class SETest {


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // Start ========================================================================================================

        CheckPermissionAPI.init();
        CGgen cg = new CGgen("test1","check8");
        cg.genCG();
        cg.traverseCG();
        PathAnalyze pa = new PathAnalyze(cg.entryMethod);
        pa.startAnalyze();


        // End ==========================================================================================================
        long endTime =  System.currentTimeMillis();
        Log.info( "[+] Total time: " + (endTime - startTime)/1000 + "s");
    }



    public static void unzip(){
        String zipFilePath = "C:\\Users\\devoke\\Desktop\\service-bluetooth.jar"; // 替换为你的zip文件路径
        String destDirPath = Config.testInput; // 替换为你的解压目录路径

        try {
            ZipUtils.unzip(zipFilePath, destDirPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}