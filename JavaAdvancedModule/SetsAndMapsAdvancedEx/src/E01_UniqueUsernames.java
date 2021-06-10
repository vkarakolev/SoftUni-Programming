import java.util.LinkedHashSet;
import java.util.Scanner;

public class E01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashSet<String> usernames = new LinkedHashSet<>();
        while (n-- > 0){
            usernames.add (scanner.nextLine());
        }

        for (String name : usernames) {
            System.out.println(name);
        }
    }
}
