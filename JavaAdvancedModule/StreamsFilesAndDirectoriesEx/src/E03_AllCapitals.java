import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class E03_AllCapitals {
    public static void main(String[] args) throws IOException {
        String fileName = "E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectoriesEx\\resources\\input.txt";
        BufferedReader reader = Files.newBufferedReader(Path.of(fileName));

        PrintWriter printWriter = new PrintWriter("output.txt");

        String line = reader.readLine();
        while (line != null){
            printWriter.println(line.toUpperCase());
            line = reader.readLine();
        }

        printWriter.close();
    }
}
