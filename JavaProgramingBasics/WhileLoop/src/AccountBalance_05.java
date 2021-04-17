import java.util.Scanner;

public class AccountBalance_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalMoney = 0;

        while (true) {
            String input = scanner.nextLine();
            if (!input.equals("NoMoreMoney")) {
                double fee = Double.parseDouble(input);
                if (fee < 0) {
                    System.out.println("Invalid operation!");
                    System.out.printf("Total: %.2f", totalMoney);
                    break;
                }
                System.out.printf("Increase: %.2f%n", fee);
                totalMoney += fee;

            } else {
                System.out.printf("Total: %.2f", totalMoney);
                break;
            }
        }
    }
}
