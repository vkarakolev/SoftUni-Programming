import java.util.Scanner;

public class E11_MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        int secondNum = Integer.parseInt(scanner.nextLine());

        System.out.println(calculate(firstNum, operator, secondNum));
    }

    static int calculate(int firstNum, char operator, int secondNum) {
        int result = 0;
        switch (operator) {
            case '/':
                result = firstNum / secondNum;
            break;
            case '*':
                result = firstNum * secondNum;
            break;
            case '+':
                result = firstNum + secondNum;
            break;
            case '-':
                result = firstNum - secondNum;
            break;
        }

        return result;
    }
}
