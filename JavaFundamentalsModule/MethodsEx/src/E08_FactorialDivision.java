import java.util.Scanner;

public class E08_FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();

        double result = (double) getFactorial(firstNum) / getFactorial(secondNum);
        System.out.printf("%.2f", result);

    }

    static long getFactorial(int number) {
        long factorial = number;
        if(number == 0){
            factorial = 1;
        } else if (number == 1) {
            factorial = 1;
        } else {
            for (int i = 1; i < number; i++) {
                factorial *= number - i;
            }
        }

        return factorial;
    }
}
