import java.util.Scanner;

public class TransportPrice_04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int km = Integer.parseInt(input.nextLine());
        String period = input.nextLine();
        double price = 0;

        if(km < 20){
            if (period.equals("day")){
                price = 0.7 + km * 0.79;
            } else if (period.equals("night")){
                price = 0.7 + km * 0.9;
            }
        } else if (km >= 20 && km < 100){
            price = 0.09 * km;
        } else if (km >= 100){
            price = 0.06 * km;
        }
        System.out.printf("%.2f", price);
    }
}
