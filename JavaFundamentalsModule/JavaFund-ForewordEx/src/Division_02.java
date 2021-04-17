import java.util.Scanner;

public class Division_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int divider;

        if (input % 10 == 0) {
            divider = 10;
        } else if (input % 7 == 0) {
            divider = 7;
        } else if (input % 6 == 0) {
            divider = 6;
        } else if (input % 3 == 0) {
            divider = 3;
        } else if (input % 2 == 0) {
            divider = 2;
        } else {
            divider = 0;
        }

        if (divider == 0){
            System.out.println("Not divisible");
        } else {
            System.out.printf("The number is divisible by %d", divider);
        }
    }
}
