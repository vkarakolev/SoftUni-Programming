import java.util.Scanner;

public class E05_EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arrAsString = input.split(" ");

        int[] arrAsInt = new int[arrAsString.length];
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < arrAsInt.length; i++) {
            arrAsInt[i] = Integer.parseInt(arrAsString[i]);
            if(arrAsInt[i] % 2 == 0){
                evenSum += arrAsInt[i];
            } else {
                oddSum += arrAsInt[i];
            }
        }
        int difference = evenSum - oddSum;
        System.out.println(difference);
    }
}
