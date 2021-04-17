import java.util.Scanner;

public class VendingMachine_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double sum = 0;

        while(!input.equals("Start")){
            double currentCoins = Double.parseDouble(input);
            if(currentCoins == 0.1 || currentCoins == 0.2 || currentCoins == 0.5
                    || currentCoins == 1 || currentCoins == 2){
                sum += currentCoins;
            } else {
                System.out.println(String.format("Cannot accept %.2f", currentCoins));
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while(!input.equals("End")){
            switch(input){
                case "Nuts":
                    if(sum >= 2){
                        sum -= 2;
                        System.out.println("Purchased Nuts");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if(sum >= 0.7){
                        sum -= 0.7;
                        System.out.println("Purchased Water");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if(sum >= 1.5){
                        sum -= 1.5;
                        System.out.println("Purchased Crisps");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if(sum >= 0.8){
                        sum -= 0.8;
                        System.out.println("Purchased Soda");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if(sum >= 1){
                        sum -= 1;
                        System.out.println("Purchased Coke");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", sum);
    }
}
