import java.util.Scanner;

public class E03_ExtractFile {
    public static void main(String[] args) {
        String path =new Scanner(System.in).nextLine();

        String[] nameAndExtension = path.substring(path.lastIndexOf("\\") + 1).split("\\.");

        System.out.printf("File name: %s%nFile extension: %s", nameAndExtension[0], nameAndExtension[1]);
    }
}
