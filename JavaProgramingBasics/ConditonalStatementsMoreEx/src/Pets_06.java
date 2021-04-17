import java.util.Scanner;

public class Pets_06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int days = Integer.parseInt(input.nextLine());
        int foodKg = Integer.parseInt(input.nextLine());
        double dailyDogfood = Double.parseDouble(input.nextLine());
        double dailyCatFood = Double.parseDouble(input.nextLine());
        double dailyTurtleFoodG = Double.parseDouble(input.nextLine());

        double totalEatenFood = days * (dailyDogfood + dailyCatFood + dailyTurtleFoodG / 1000);

        if (foodKg >= totalEatenFood){
            double foodLeft = foodKg - totalEatenFood;
            System.out.printf("%.0f kilos of food left.", Math.floor(foodLeft));
        } else {
            double foodNeeded = totalEatenFood - foodKg;
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(foodNeeded));
        }
    }
}
