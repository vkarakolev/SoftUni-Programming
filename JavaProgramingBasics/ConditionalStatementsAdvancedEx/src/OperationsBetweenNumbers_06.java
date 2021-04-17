import java.util.Scanner;

public class OperationsBetweenNumbers_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        char symbol = scanner.nextLine().charAt(0);
        double result = 0;
        String isEven = null;

        switch (symbol) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '/':
                if (n2 == 0) {
                    break;
                } else {
                    result = n1 / (double) n2;
                }
                break;
            case '%':
                if (n2 == 0){
                    break;
                }else {
                    result = n1 % n2;
                }
                break;
        }

        if (result % 2 == 0) {
            isEven = "even";
        } else {
            isEven = "odd";
        }

        if (symbol == '/' && n2 != 0) {
            System.out.printf("%d %c %d = %.2f", n1, symbol, n2, result);
        } else if (symbol == '%' && n2 != 0) {
            System.out.printf("%d %c %d = %.0f", n1, symbol, n2, result);
        } else if (symbol == '/' ^ symbol == '%' && n2 == 0) {
            System.out.printf("Cannot divide %d by zero", n1);
        } else {
            System.out.printf("%d %c %d = %.0f - %s", n1, symbol, n2, result, isEven);
        }
    }
}
