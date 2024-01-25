package org.labs.logger.factory;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;

public class LoggerFactory {
    private static final Map<String, Logger> LOGGER_MAP = new HashMap<>();

    private LoggerFactory(){
        LOGGER_MAP.put("info_log", org.slf4j.LoggerFactory.getLogger("info_log"));
        LOGGER_MAP.put("error_log", org.slf4j.LoggerFactory.getLogger("error_log"));
    }

    public static LoggerFactory getLogger(){
        return new LoggerFactory();
    }

    public void info(String message){
        LOGGER_MAP.get("info_log").info(message);
    }

    public void error(String message){
        LOGGER_MAP.get("error_log").info(message);
    }

    public void error(String message, Throwable exception){
        LOGGER_MAP.get("error_log").error(message,exception);
    }
}
