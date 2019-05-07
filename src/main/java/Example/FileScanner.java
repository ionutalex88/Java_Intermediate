package Example;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileScanner {

    public List<String> scanFile(String pathToFile) {

        Path path = Paths.get(pathToFile);
        List<String> words = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(path);
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return words;
    }

}
