import java.util.Scanner;

public class AddBags_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moreThan20LuggagePrice = Double.parseDouble(scanner.nextLine());
        double luggageKg = Double.parseDouble(scanner.nextLine());
        int remainingDays = Integer.parseInt(scanner.nextLine());
        int luggageCount = Integer.parseInt(scanner.nextLine());
        double luggagePrice = 0;

        if(luggageKg > 20){
            luggagePrice = moreThan20LuggagePrice;
        } else if (luggageKg >= 10){
            luggagePrice = moreThan20LuggagePrice * 0.5;
        } else if (luggageKg < 10){
            luggagePrice = moreThan20LuggagePrice * 0.2;
        }

        if(remainingDays > 30){
            luggagePrice *= 1.1;
        } else if (remainingDays >= 7){
            luggagePrice *= 1.15;
        } else if (remainingDays < 7){
            luggagePrice *= 1.4;
        }

        double totalPrice = luggagePrice * luggageCount;

        System.out.printf("The total price of bags is: %.2f lv.", totalPrice);
    }
}
