import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class E03_CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectories\\resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);

        PrintStream printStream = new PrintStream("copy_bytes_out.txt");

        int nextByte = inputStream.read();
        while (nextByte != -1){
            if(nextByte == ' ' || nextByte == '\n'){
                printStream.print((char) nextByte);
            } else {
                printStream.print(nextByte);
            }

            nextByte = inputStream.read();
        }

    }
}
