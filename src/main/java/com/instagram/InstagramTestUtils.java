package com.instagram;
import java.util.Properties;

public class InstagramTestUtils {
    private static final String CONFIG_FILE = "config.properties";

    public static Properties loadConfig() {
        return Utils.loadProperties(CONFIG_FILE);
    }
}
