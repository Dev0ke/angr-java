package utils;
//import log4j
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
      
    private static final Logger logger = LogManager.getLogger(Log.class);

    // 记录不同级别的日志信息
    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void fatal(String message) {
        logger.fatal(message);
    }
}
