import java.util.Scanner;

public class E03_SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] numbersAsString = input.split(" ");

        int[] arr = new int[numbersAsString.length];
        int sumOfEven = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(numbersAsString[i]);
            if (arr[i] % 2 == 0){
                sumOfEven += arr[i];
            }
        }
        System.out.println(sumOfEven);
    }
}
