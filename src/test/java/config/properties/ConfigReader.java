package config.properties;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try (InputStream input = Files.newInputStream(Paths.get("src\\test\\resources\\config.properties"))) {
            properties.load(input);
        } catch (IOException e) {
            e.getMessage();
            System.out.println(e.getMessage());
            // Handle file loading exception here
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
