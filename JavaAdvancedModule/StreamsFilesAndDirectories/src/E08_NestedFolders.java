import java.io.File;

public class E08_NestedFolders {
    public static void main(String[] args) {
        File file = new File("E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectories\\resources\\Files-and-Streams");

        File[] files = file.listFiles();
        printNestedDirectories(files);
    }

    private static void printNestedDirectories (File[] files){
        for (File f : files) {
            if(f.isDirectory()){
                System.out.println(f.getName());
                printNestedDirectories(f.listFiles());
            }
        }
    }
}
