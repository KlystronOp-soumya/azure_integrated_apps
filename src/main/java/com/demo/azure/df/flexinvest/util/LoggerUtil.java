package com.demo.azure.df.flexinvest.util;

import java.util.logging.Logger;

public final class LoggerUtil {

    private static Logger LOGGER;

    private LoggerUtil() {}

    public static void init(Logger logger) {
        LOGGER = logger;
    }

    public static void dfInfo(String message) {
        LOGGER.info("[INFO] " + message);
    }

    public static void dfWarn(String message) {
        LOGGER.warning("[WARN] " + message);
    }

    public static void dfError(String message) {
        LOGGER.severe("[ERROR] " + message);
    }
}