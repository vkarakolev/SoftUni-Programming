import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class E02_SymBytes {
    public static void main(String[] args) throws IOException {
        String fileName = "E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectoriesEx\\resources\\input.txt";

        BufferedReader reader = Files.newBufferedReader(Paths.get(fileName));
        int sum = 0;

        String line = reader.readLine();
        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }

            line = reader.readLine();
        }

        System.out.println(sum);
    }
}
