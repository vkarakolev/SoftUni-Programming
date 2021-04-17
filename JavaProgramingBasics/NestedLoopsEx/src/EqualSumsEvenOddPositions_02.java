import java.util.Scanner;

public class EqualSumsEvenOddPositions_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int sumEvenPosition = 0;
        int sumOddPosition = 0;

        int firstDigit = 0;
        int secondDigit = 0;
        int thirdDigit = 0;
        int fourthDigit = 0;
        int fifthDigit = 0;
        int sixthDigit = 0;

        for (int num = firstNumber; num <= secondNumber; num++) {

            firstDigit = num / 100000;
            secondDigit = num / 10000 % 10;
            thirdDigit = num / 1000 % 10;
            fourthDigit = num / 100 % 10;
            fifthDigit = num / 10 % 10;
            sixthDigit = num % 10;

            sumEvenPosition = secondDigit + fourthDigit + sixthDigit;
            sumOddPosition = firstDigit + thirdDigit + fifthDigit;
            if (sumEvenPosition == sumOddPosition) {
                System.out.print(num + " ");
            }
        }
    }
}

