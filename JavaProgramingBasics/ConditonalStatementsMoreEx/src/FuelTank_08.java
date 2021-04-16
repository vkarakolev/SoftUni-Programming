import java.util.Scanner;

public class FuelTank_08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fuelType = input.nextLine();
        double litersInTank = Double.parseDouble(input.nextLine());

        if (!"Diesel".equals(fuelType) ^ !"Gasoline".equals(fuelType) ^ !"Gas".equals(fuelType)) {
            System.out.println("Invalid fuel!");
        }else if (litersInTank >= 25) {
            System.out.printf("You have enough %s.", fuelType.toLowerCase());
        }else if (litersInTank < 25){
            System.out.printf("Fill your tank with %s!", fuelType.toLowerCase());
        }
    }
}
