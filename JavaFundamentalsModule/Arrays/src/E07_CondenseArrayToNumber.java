import java.util.Scanner;

public class E07_CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbersAsString = scanner.nextLine();
        String[] stringArr = numbersAsString.split(" ");
        int[] intArr = new int[stringArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(stringArr[i]);
        }

        for (int i = intArr.length; i > 1; i--) {
            for (int j = 0; j < intArr.length - 1; j++) {
                intArr[j] += intArr[j + 1];
            }
        }
        System.out.println(intArr[0]);
        

    }
}
