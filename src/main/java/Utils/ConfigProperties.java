package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private static final String PROPERTIES_PATH = "src/main/java/resources/config.properties";

    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES_PATH));
        } catch (IOException e) {
            System.out.println("Bad Properties Path...");
            throw new RuntimeException(e);
        }
        return properties;
    }
}
