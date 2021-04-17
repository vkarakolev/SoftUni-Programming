import java.util.Arrays;
import java.util.Scanner;

public class E07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int counter = 1;
        int maxCount = 0;
        int sequenceValue = 0;
        for (int i = 1; i < input.length; i++) {
            int oldElement = input[i - 1];

            if(input[i] == oldElement){
                counter++;
                if(maxCount < counter){
                    maxCount = counter;
                    sequenceValue = input[i];
                }
            } else {
                counter = 1;
            }
        }

        for (int i = 0; i < maxCount; i++) {
            System.out.print(sequenceValue + " ");
        }
    }
}
