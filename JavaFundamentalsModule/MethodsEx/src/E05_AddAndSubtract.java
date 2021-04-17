import java.util.Scanner;

public class E05_AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        int thirdNum = scanner.nextInt();

        System.out.println(subtractNumberFromSum(sumOfFirstTwoNumbers(firstNum, secondNum), thirdNum));
    }

    static int sumOfFirstTwoNumbers(int first, int second){
        return first + second;
    }

    static int subtractNumberFromSum(int sum, int third){
        return sum - third;
    }
}
