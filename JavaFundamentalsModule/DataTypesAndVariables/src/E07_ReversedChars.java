import java.util.Scanner;

public class E07_ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        char third = scanner.nextLine().charAt(0);

        String line = String.format("%c %c %c", third, second, first);
        System.out.println(line);
    }
}
