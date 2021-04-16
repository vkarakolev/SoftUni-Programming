import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double deposit = Double.parseDouble(input.nextLine());
        int months = Integer.parseInt(input.nextLine());
        double interest = Double.parseDouble(input.nextLine());
        double monthInterest = (deposit * (interest / 100)) / 12;
        double result = deposit + months * monthInterest;
        System.out.printf("%.2f", result);
    }
}
