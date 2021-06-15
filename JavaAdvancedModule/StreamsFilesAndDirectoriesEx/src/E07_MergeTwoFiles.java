import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E07_MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path inputOne = Path.of("E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectoriesEx\\resources\\inputOne.txt");
        Path inputTwo = Path.of("E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectoriesEx\\resources\\inputTwo.txt");

        List<String> fileOne = Files.readAllLines(inputOne);
        List<String> fileTwo = Files.readAllLines(inputTwo);

        BufferedWriter writer = new BufferedWriter(new FileWriter("merge-files-output.txt"));

        writeInFile(fileOne, writer);
        writeInFile(fileTwo, writer);
        writer.close();
    }

    private static void writeInFile(List<String> lines, BufferedWriter writer) throws IOException {
        for (String s : lines) {
            writer.write(s);
            writer.newLine();
        }
    }
}
