package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
    static Properties properties = new Properties();

       public Properties getProperty(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/configuration.properties");
        properties.load(fileInputStream);
        return properties;
    }
}
