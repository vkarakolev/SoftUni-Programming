import java.util.Scanner;

public class E05_MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];
        String result = null;
        int count = 0;

        for (int i = 0; i < 3; i++) {
            numbers[i] = scanner.nextInt();

            if (numbers[i] == 0){
                result = "zero";
            } else if(numbers[i] < 0){
                count++;
                if(count % 2 == 0){
                    result = "positive";
                } else {
                    result = "negative";
                }
            }
        }

        if(result == null){
            result = "positive";
        }
        System.out.println(result);
    }
}
