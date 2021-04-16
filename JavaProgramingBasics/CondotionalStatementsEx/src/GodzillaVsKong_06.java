import java.util.Scanner;

public class GodzillaVsKong_06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double budget = Double.parseDouble(input.nextLine());
        int countStatists = Integer.parseInt(input.nextLine());
        double pricePerStatist = Double.parseDouble(input.nextLine());

        double decorPrice = 0.1 * budget;
        double clothesPrice = countStatists * pricePerStatist;

        if (countStatists > 150){
            clothesPrice *= 0.9;
        }

        double expenses = decorPrice + clothesPrice;

        if (budget >= expenses){
            System.out.println("Action!");
            double moneyLeft = budget - expenses;
            System.out.printf("Wingard starts filming with %.2f leva left.", moneyLeft);
        }else {
            System.out.println("Not enough money!");
            double needMoney = expenses - budget;
            System.out.printf("Wingard needs %.2f leva more.", needMoney);
        }
    }
}
