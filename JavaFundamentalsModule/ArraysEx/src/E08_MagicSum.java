import java.util.Arrays;
import java.util.Scanner;

public class E08_MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int sum = scanner.nextInt();

        for (int i = 0; i < inputNumbers.length; i++) {
            for (int j = i + 1; j < inputNumbers.length; j++) {
                int currentSum = inputNumbers[i] + inputNumbers[j];
                if(currentSum == sum){
                    System.out.println(inputNumbers[i] + " " + inputNumbers[j]);
                }
            }
        }

    }
}
