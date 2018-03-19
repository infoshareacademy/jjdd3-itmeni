package com.parawan.loginconfig;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class ConfigurationLoader {

    private static Configuration configuration;

    private static final String DEFAULT_CONFIG_FILE_PATH = "/config.json";
    private static final Logger logger = LoggerFactory.getLogger(ConfigurationLoader.class);

    public static void loadConfiguration() {
        loadConfiguration(DEFAULT_CONFIG_FILE_PATH);
    }

    public static void loadConfiguration(String path) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
            configuration = objectMapper.reader(Configuration.class).readValue(
                    Configuration.class.getResourceAsStream(path));
        } catch (IOException e) {
            logger.error("caught an exception during loading file", e);
            throw new RuntimeException(e);
        }
    }

    public static Configuration getConfiguration() {
        if (configuration == null) {
            loadConfiguration();
        }
        return configuration;
    }

    public static void clearConfiguration() {
        configuration = null;
    }
}