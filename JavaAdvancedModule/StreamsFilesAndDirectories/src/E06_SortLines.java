import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class E06_SortLines {
    public static void main(String[] args) throws IOException {
        String fileName = "E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectories\\resources\\input.txt";
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);

        Collections.sort(lines);

        for (String line : lines) {
            System.out.println(line);
        }

        Files.write(Path.of("sorted-lines-out.txt"), lines);
    }
}
