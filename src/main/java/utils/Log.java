package utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import init.Config;

public class Log {

    // 使用 ThreadLocal 来确保每个线程都有自己的 Logger 实例
    private static final ThreadLocal<Logger> loggerThreadLocal = new ThreadLocal<>();

    public static void info(String message) {
        getLogger().info(message);
    }

    public static void debug(String message) {
        getLogger().debug(message);
    }

    public static void error(String message) {
        // 获取调用者的类名、方法名、文件名和行号
        StackTraceElement caller = new Throwable().getStackTrace()[1];
        String callingClassName = caller.getClassName();
        String callingMethodName = caller.getMethodName();
        int callingLineNumber = caller.getLineNumber();
        String callingFileName = caller.getFileName();

        // 格式化输出
        getLogger().error(callingClassName + "." + callingMethodName + "(" + callingFileName + ":" + callingLineNumber + ")" + " " + message);
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
        Logger logger = loggerThreadLocal.get();
        if (logger == null) {
            String callingClassName = new Throwable().getStackTrace()[2].getClassName();
            logger = LogManager.getLogger(callingClassName);
            loggerThreadLocal.set(logger);
        }
        return logger;
    }

    public static void printTime(String message, long startTime) {
        long endTime = System.currentTimeMillis();
        info(message + "  " + (endTime - startTime) / 1000 + "s");
    }

    public static void setLogLevel(String level) {
        org.apache.logging.log4j.core.config.Configurator.setLevel(LogManager.getRootLogger().getName(), Level.toLevel(level));
    }

    public static void initLogLevel() {
        setLogLevel(Config.logLevel);
    }
}