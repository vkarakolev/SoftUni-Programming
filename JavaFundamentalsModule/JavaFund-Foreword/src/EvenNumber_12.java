import java.util.Scanner;

public class EvenNumber_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        while (num % 2 != 0) {
            System.out.println("Please write an even number.");
            num = scanner.nextInt();
        }

        System.out.printf("The number is: %d", Math.abs(num));
    }
}
