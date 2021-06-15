import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class E05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String fileName = "E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectories\\resources\\input.txt";

        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);

        for (int i = 2; i < lines.size(); i += 3) {
            System.out.println(lines.get(i));
        }
    }
}
