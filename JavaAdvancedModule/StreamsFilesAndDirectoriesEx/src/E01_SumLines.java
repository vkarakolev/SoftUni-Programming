import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class E01_SumLines {
    public static void main(String[] args) throws IOException {
        String fileName = "E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectoriesEx\\resources\\input.txt";
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);

        for (String line : lines) {
            int sum = 0;

            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }

            System.out.println(sum);
        }
    }
}
