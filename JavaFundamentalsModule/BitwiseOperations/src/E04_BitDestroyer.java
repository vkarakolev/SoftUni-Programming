import java.util.Scanner;

public class E04_BitDestroyer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        int position = scanner.nextInt();

        int mask = 1 << position;

        int result = inputNum & ~mask;
        System.out.println(result);
    }
}
