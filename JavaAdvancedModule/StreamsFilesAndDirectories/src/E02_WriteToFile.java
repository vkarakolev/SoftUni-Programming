import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

public class E02_WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectories\\resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);

        Set<Character> separators = Set.of(',', '.', '!', '?');
        PrintStream printStream = new PrintStream("out.txt");

        int nextByte = inputStream.read();
        while (nextByte != -1){
            char symbol = (char) nextByte;

            if(!separators.contains(symbol)){
                printStream.print(symbol);
            }

            nextByte = inputStream.read();
        }
    }
}
