import java.io.FileInputStream;
import java.io.IOException;

public class E01_ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectories\\resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int nextByte = inputStream.read();

        while (nextByte != -1) {
            System.out.print(Integer.toBinaryString(nextByte) + " ");
            nextByte = inputStream.read();
        }
    }
}
