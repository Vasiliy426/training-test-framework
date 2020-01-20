package logger;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import static util.Constants.LOG4J_CONFIG_PATH;

public class LoggerTool {
    private static final Logger LOGGER = Logger.getLogger(LoggerTool.class);

    public static void logSetUp() {
        DOMConfigurator.configure(LOG4J_CONFIG_PATH);
    }

    public static void logInfo(String message) {
        LOGGER.info(message);
        // todo - add reporter event
    }

    public static void logWarning(String message) {
        LOGGER.warn(message);
        // todo - add reporter event
    }

    public static void logError(String message) {
        LOGGER.error(message);
        // todo - add reporter event
    }
}
