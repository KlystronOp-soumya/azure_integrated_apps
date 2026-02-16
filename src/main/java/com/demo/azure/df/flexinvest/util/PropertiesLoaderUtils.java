package com.demo.azure.df.flexinvest.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public final class PropertiesLoaderUtils {

    public static final PropertiesLoaderUtils INSTANCE = new PropertiesLoaderUtils();

    private final Properties props;

    private PropertiesLoaderUtils() {
        this.props = new Properties();
        loadProperties();
    }

    private void loadProperties() {

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {

            if (inputStream != null) {
                this.props.load(Objects.requireNonNull(inputStream));
            } else {
                throw new RuntimeException("application.properties file not found");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }

    public String getProperty(String key) {
        return this.props.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return this.props.getProperty(key, defaultValue);
    }

}
