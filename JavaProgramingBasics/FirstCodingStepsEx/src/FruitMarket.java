import java.util.Scanner;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double strawberriesValue = Double.parseDouble(input.nextLine());
        double bananasQuantity = Double.parseDouble(input.nextLine());
        double orangesQuantity = Double.parseDouble(input.nextLine());
        double raspberriesQuantity = Double.parseDouble(input.nextLine());
        double strawberriesQuantity = Double.parseDouble(input.nextLine());
        double raspberriesValue = strawberriesValue - strawberriesValue / 2;
        double orangesValue = raspberriesValue - 0.4 * raspberriesValue;
        double bananasValue = raspberriesValue / 5;
        double bill =strawberriesQuantity * strawberriesValue + bananasQuantity * bananasValue
                + orangesQuantity * orangesValue + raspberriesQuantity * raspberriesValue;
        System.out.printf("%.2f лв.", bill);
    }
}
