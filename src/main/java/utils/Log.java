package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    public static void info(String message) {
        getLogger().info(message);
    }

    public static void debug(String message) {
        getLogger().debug(message);
    }

    public static void error(String message) {
        getLogger().error(message);
    }

    public static void errorStack(String message, Exception e) {
        getLogger().error(message, e);
    }
    public static void warn(String message) {
        getLogger().warn(message);
    }

    public static void fatal(String message) {
        getLogger().fatal(message);
    }

    // 动态获取调用此日志类的类名
    private static Logger getLogger() {
        String callingClassName = new Throwable().getStackTrace()[2].getClassName();
        return LogManager.getLogger(callingClassName);
    }

    public static void printTime(String message, long startTime) {
        long endTime = System.currentTimeMillis();
        info(message + "  " + (endTime - startTime) / 1000 + "s");
    }

}
