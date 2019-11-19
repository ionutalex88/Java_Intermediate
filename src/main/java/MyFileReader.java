import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by itrusca on 5/7/2019.
 */
public class MyFileReader {

    public static String externalFilesDir = System.getProperty("user.dir") + "/externalFiles";

    public String readFile (String pathToFile) throws IOException {
        Path path = Paths.get(pathToFile);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public List<String> readFileLines (String pathToFile) throws IOException {
        Path path = Paths.get(pathToFile);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}
