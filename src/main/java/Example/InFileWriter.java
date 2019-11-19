package Example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by itrusca on 5/7/2019.
 */
public class InFileWriter {

    public void writeFile(String pathToFile, String content) throws IOException {
        Path path = Paths.get(pathToFile);
        Files.write(path, content.getBytes());
    }

    public void writeLineToFile(String pathToFile, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile, true));
        writer.newLine();
        writer.write(content) ;
        writer.close() ;
    }

}
