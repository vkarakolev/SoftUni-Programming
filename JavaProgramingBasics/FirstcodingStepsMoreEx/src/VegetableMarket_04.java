import java.util.Scanner;

public class VegetableMarket_04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double vegetablesValue = Double.parseDouble(input.nextLine());
        double fruitsValue = Double.parseDouble(input.nextLine());
        int soldVegetables = Integer.parseInt(input.nextLine());
        int soldFruits = Integer.parseInt(input.nextLine());
        double turnover = (soldVegetables * vegetablesValue + soldFruits * fruitsValue) / 1.94;
        System.out.printf("%.2f", turnover);
    }
}
