import java.util.Scanner;

public class E10_TopNumber {
    public static void main(String[] args) {
        int inputNum = new Scanner(System.in).nextInt();

        for (int i : checkDivisionBy8(inputNum)) {
            System.out.println(i);
        }

    }

    static int[] checkDivisionBy8(int num){
        int[] numbers = new int[num];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        int[] validNumbers = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int digitsSum = 0;
            while(numbers[i] != 0){
                digitsSum += numbers[i] % 10;
                numbers[i] /= 10;
            }

            int currentIndex = 0;

            if(digitsSum % 8 == 0){
                    validNumbers[currentIndex] = numbers[i];
                    currentIndex++;
            }
        }
        return validNumbers;
    }
}
