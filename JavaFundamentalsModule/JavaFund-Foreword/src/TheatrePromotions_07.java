import java.util.Scanner;

public class TheatrePromotions_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dayType = scanner.nextLine().toLowerCase();
        int age = scanner.nextInt();
        int price = 0;

        switch (dayType) {
            case "weekday":
                if (0 <= age && age <= 18) {
                    price = 12;
                } else if (18 < age && age <= 64) {
                    price = 18;
                } else if (64 < age && age <= 122) {
                    price = 12;
                }
                break;
            case "weekend":
                if (0 <= age && age <= 18) {
                    price = 15;
                } else if (18 < age && age <= 64) {
                    price = 20;
                } else if (64 < age && age <= 122) {
                    price = 15;
                }
                break;
            case "holiday":
                if (0 <= age && age <= 18) {
                    price = 5;
                } else if (18 < age && age <= 64) {
                    price = 12;
                } else if (64 < age && age <= 122) {
                    price = 10;
                }
                break;
        }

        if (0 > age ^ age > 122) {
            System.out.println("Error!");
        } else {
            System.out.println(price + "$");
        }
    }
}
