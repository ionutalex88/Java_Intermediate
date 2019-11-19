import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by itrusca on 5/7/2019.
 */
public class MyPropertyReader {

    public Properties readProperties(String pathToFile) throws IOException {
        InputStream inputStream = new FileInputStream(pathToFile);
        Properties properties = new Properties();
        properties.load(inputStream);
        return  properties;
    }
}
