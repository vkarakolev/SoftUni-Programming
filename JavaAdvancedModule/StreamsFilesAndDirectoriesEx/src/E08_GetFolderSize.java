import java.io.File;

public class E08_GetFolderSize {
    public static void main(String[] args) {
        String path = "E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectoriesEx\\resources\\Exercises Resources";
        File folder = new File(path);

        int sum = 0;
        for (File file : folder.listFiles()) {
            sum += file.length();
        }

        System.out.println("Folder size: " + sum);
    }
}
