import java.util.Scanner;

public class E12_RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input =  Integer.parseInt(scanner.nextLine());
        int sum = 0;
        String result = "";

        for (int i = 1; i <= input; i++) {
            int number = i;
            while(number > 0){
                sum += number % 10;
                number /= 10;
            }
            boolean isSpecialNum = (sum == 5) || (sum == 7) || (sum == 11);
            if (isSpecialNum){
                result = "True";
            } else {
                result = "False";
            }
            System.out.printf("%d -> %s%n", i, result);
            sum = 0;
        }
    }
}
