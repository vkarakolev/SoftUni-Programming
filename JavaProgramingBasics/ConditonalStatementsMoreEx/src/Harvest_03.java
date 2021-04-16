import java.util.Scanner;

public class Harvest_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int vineyardArea = Integer.parseInt(input.nextLine());
        double grapesKg = Double.parseDouble(input.nextLine());
        int goal = Integer.parseInt(input.nextLine());
        int workers = Integer.parseInt(input.nextLine());
        double grapesForWine = (vineyardArea * grapesKg) * 0.4;
        double liters = grapesForWine / 2.5;

        if (liters < goal){
            double lack = Math.floor(goal - liters);
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", lack);
        }else{
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", Math.floor(liters));
            double surplus = Math.ceil(liters - goal);
            double share =Math.ceil (surplus / workers);
            System.out.printf("%.0f liters left -> %.0f liters per person.", surplus, share);
        }
    }
}
