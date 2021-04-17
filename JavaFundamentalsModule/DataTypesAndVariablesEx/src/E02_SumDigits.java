import java.util.Scanner;

public class E02_SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputNum = scanner.nextLine();

        int sum = 0;
        for (int i = 0; i < inputNum.length(); i++) {
            int currentNum = inputNum.charAt(i) - 48;
            sum += currentNum;
        }
        System.out.println(sum);
    }
}
