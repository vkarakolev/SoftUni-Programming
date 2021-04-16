import java.util.Scanner;

public class NewHouse_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String flowerType = input.nextLine();
        int count = Integer.parseInt(input.nextLine());
        int budget = Integer.parseInt(input.nextLine());
        double price = 0;

        switch (flowerType) {
            case "Roses":
                price = 5;
                break;
            case "Dahlias":
                price = 3.8;
                break;
            case "Tulips":
                price = 2.8;
                break;
            case "Narcissus":
                price = 3;
                break;
            case "Gladiolus":
                price = 2.5;
                break;
        }

        if (count > 80 && flowerType.equals("Roses")) {
            price *= 0.9;
        } else if (count > 90 && flowerType.equals("Dahlias")) {
            price *= 0.85;
        } else if (count > 80 && flowerType.equals("Tulips")) {
            price *= 0.85;
        } else if (count < 120 && flowerType.equals("Narcissus")) {
            price *= 1.15;
        } else if (count < 80 && flowerType.equals("Gladiolus")) {
            price *= 1.2;
        }

        price *= count;

        if (budget >= price) {
            double moneyLeft = budget - price;
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", count, flowerType, moneyLeft);
        } else {
            double lack = price - budget;
            System.out.printf("Not enough money, you need %.2f leva more.", lack);
        }
    }
}
