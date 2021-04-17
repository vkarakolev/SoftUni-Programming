import java.util.Scanner;

public class E10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        System.out.println(getAndMultiplyEvensAndOdds(number));
    }

    static int getAndMultiplyEvensAndOdds(int numbers){
        int evenSum = 0;
        int oddSum = 0;

        while(numbers != 0){
            int currentNum = numbers % 10;
            if (currentNum % 2 != 0){
                oddSum += currentNum;
            } else {
                evenSum += currentNum;
            }
            numbers /= 10;
        }

        return (evenSum * oddSum);
    }
}
