import java.util.Scanner;

public class E10_SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        String result = "";

        for (int i = 1; i <= n; i++) {
            int num = i;
            while(num > 0){
                sum += num % 10;
                num /= 10;
            }

            if(sum == 5 || sum == 7 || sum == 11){
                result = "True";
            } else {
                result = "False";
            }
            System.out.printf("%d -> %s%n", i, result);
            sum = 0;
        }
    }
}
