import java.util.Scanner;

public class SkiTrip_13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int days = Integer.parseInt(input.nextLine());
        String roomType = input.nextLine();
        String grade = input.nextLine();
        int nights = days - 1;
        double discount = 0;
        double price = 0;

        switch (roomType) {
            case "room for one person":
                price = nights * 18;
                break;
            case "apartment":
                price = nights * 25;
                if(days < 10){
                    discount = 0.3;
                } else if (days >= 10 && days <= 15){
                    discount = 0.35;
                } else if (days > 15){
                    discount = 0.5;
                }
                break;
            case "president apartment":
                price = nights * 35;
                if(days < 10){
                    discount = 0.1;
                } else if (days >= 10 && days <= 15){
                    discount = 0.15;
                } else if (days > 15){
                    discount = 0.2;
                }
                break;
        }

        price -= price * discount;
        if(grade.equals("positive")){
            price *= 1.25;
        } else if(grade.equals("negative")){
            price *= 0.9;
        }

        System.out.printf("%.2f", price);
    }
}
