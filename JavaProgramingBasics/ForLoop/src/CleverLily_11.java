import java.util.Scanner;

public class CleverLily_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int years = Integer.parseInt(scanner.nextLine());
        double laundryPrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());
        int moneyGift = 0;
        int moneySum = 0;
        int toyCount = 0;

        for(int i = 1; i <= years; i++){
            if(i % 2 == 0){
                moneyGift += 10;
                moneySum += moneyGift -1;
            } else {
                toyCount++;
            }
        }

        moneySum += toyCount * toyPrice;

        if(moneySum >= laundryPrice){
            double moneyMore = moneySum - laundryPrice;
            System.out.printf("Yes! %.2f", moneyMore);
        } else {
            double moneyLess = laundryPrice - moneySum;
            System.out.printf("No! %.2f", moneyLess);
        }
    }
}
