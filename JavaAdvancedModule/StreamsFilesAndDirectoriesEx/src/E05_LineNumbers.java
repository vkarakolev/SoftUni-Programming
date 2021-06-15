import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E05_LineNumbers {
    public static void main(String[] args) throws IOException {
        String fileName = "E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectoriesEx\\resources\\inputLineNumbers.txt";
        Path path = Path.of(fileName);
        List<String> lines = Files.readAllLines(path);

        PrintWriter writer = new PrintWriter("line-numbers-output.txt");

        for (int i = 0; i < lines.size(); i++) {
            writer.printf("%d. %s%n", i + 1, lines.get(i));
        }

        writer.close();
    }
}
