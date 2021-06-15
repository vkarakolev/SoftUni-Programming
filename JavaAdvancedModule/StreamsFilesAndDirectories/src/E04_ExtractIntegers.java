import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class E04_ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectories\\resources\\input.txt";
        FileReader reader = new FileReader(path);
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                System.out.println(scanner.nextInt());
            }

            scanner.next();
        }
    }
}
