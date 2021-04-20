import java.util.Scanner;

public class E05_DecryptingMessages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char letter = scanner.nextLine().charAt(0);
            result.append((char)(letter + key));
        }

        System.out.println(result);
    }
}
