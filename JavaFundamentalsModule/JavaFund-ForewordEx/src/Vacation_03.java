import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String day = scanner.nextLine();

        double totalPrice = 0;

        switch (typeOfGroup) {
            case "Students":
                switch (day) {
                    case "Friday":
                        totalPrice = peopleCount * 8.45;
                        break;
                    case "Saturday":
                        totalPrice = peopleCount * 9.80;
                        break;
                    case "Sunday":
                        totalPrice = peopleCount * 10.46;
                        break;
                }
                if (peopleCount >= 30){
                    totalPrice *= 0.85;
                }
                break;
            case "Business":
                if (peopleCount >= 100){
                    peopleCount -= 10;
                }
                switch (day) {
                    case "Friday":
                        totalPrice = peopleCount * 10.90;
                        break;
                    case "Saturday":
                        totalPrice = peopleCount * 15.60;
                        break;
                    case "Sunday":
                        totalPrice = peopleCount * 16;
                        break;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        totalPrice = peopleCount * 15;
                        break;
                    case "Saturday":
                        totalPrice = peopleCount * 20;
                        break;
                    case "Sunday":
                        totalPrice = peopleCount * 22.50;
                        break;
                }
                if (10 <= peopleCount && peopleCount <= 20){
                    totalPrice *= 0.95;
                }
                break;
        }

        System.out.printf("Total price: %.2f", totalPrice);
    }
}
