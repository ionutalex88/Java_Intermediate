package Example;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileRead {

    public static String pathToExternalSytemFolders = System.getProperty("user.dir") + "/externalFiles";

    public String readFile(String pathToFile) throws IOException {
        Path path = Paths.get(pathToFile);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public List<String> readFileLines(String pathToFile) throws IOException {
        Path path = Paths.get(pathToFile);
        byte[] bytes = Files.readAllBytes(path);
        return Files.readAllLines( path, StandardCharsets.UTF_8 );
    }

}
