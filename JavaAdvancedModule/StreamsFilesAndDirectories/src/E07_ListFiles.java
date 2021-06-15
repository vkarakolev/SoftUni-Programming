import java.io.File;

public class E07_ListFiles {
    public static void main(String[] args) {
        File file = new File("E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectories\\resources\\Files-and-Streams");

        File[] files = file.listFiles();

        for (File f : files) {
            if(!f.isDirectory()){
                System.out.printf("%s: [%d]%n", f.getName(), f.length());
            }
        }
    }
}
