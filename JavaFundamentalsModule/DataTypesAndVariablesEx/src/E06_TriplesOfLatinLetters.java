import java.util.Scanner;

public class E06_TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (char i = 97; i < 97 + n; i++) {
            for (char j = 97; j < 97 + n; j++) {
                for (char k = 97; k < 97 + n; k++) {
                    char thirdChar = (char)('a' + k);
                    System.out.printf("%c%c%c%n", i, j, k);
                }
            }
        }
    }
}
