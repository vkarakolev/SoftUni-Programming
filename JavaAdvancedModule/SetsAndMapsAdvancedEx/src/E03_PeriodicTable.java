import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class E03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> elements = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0){
            String[] compound = scanner.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(compound));
        }

        System.out.println(String.join(" ", elements));
    }
}
