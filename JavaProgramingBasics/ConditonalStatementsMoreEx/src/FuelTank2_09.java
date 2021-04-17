import java.util.Scanner;

public class FuelTank2_09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fuelType = input.nextLine();
        double liters = Double.parseDouble(input.nextLine());
        String card = input.nextLine();
        double price = 0;

        if (card.equals("Yes")) {
            switch (fuelType) {
                case "Gasoline":
                    price = 2.22 - 0.18;
                    break;
                case "Diesel":
                    price = 2.33 - 0.12;
                    break;
                case "Gas":
                    price = 0.93 - 0.08;
                    break;
            }
        } else {
            switch (fuelType) {
                case "Gasoline":
                    price = 2.22;
                    break;
                case "Diesel":
                    price = 2.33;
                    break;
                case "Gas":
                    price = 0.93;
                    break;
            }
        }

        price *= liters;
        if(liters >= 20 && liters <= 25){
            price *= 0.92;
        } else if (liters > 25){
            price *= 0.9;
        }
        System.out.printf("%.2f lv.", price);

    }
}
