package cc.lasmgratel.opensimcity.common.util.logger;

import com.badlogic.gdx.ApplicationLogger;
import org.slf4j.Logger;

public class GdxLogger implements ApplicationLogger {
    private final Logger logger;

    public GdxLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String tag, String message) {
        logger.info(tag + ": " + message);
    }

    @Override
    public void log(String tag, String message, Throwable exception) {
        logger.info(tag + ": " + message, exception);
    }

    @Override
    public void error(String tag, String message) {
        logger.error(tag + ": " + message);
    }

    @Override
    public void error(String tag, String message, Throwable exception) {
        logger.error(tag + ": " + message, exception);
    }

    @Override
    public void debug(String tag, String message) {
        logger.debug(tag + ": " + message);
    }

    @Override
    public void debug(String tag, String message, Throwable exception) {
        logger.debug(tag + ": " + message, exception);
    }
}
