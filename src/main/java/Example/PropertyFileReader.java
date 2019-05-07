package Example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {

    public Properties readProperties(String pathToFile) throws IOException {
        InputStream inputStream = new FileInputStream(pathToFile);
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }

}
