import java.util.Scanner;

public class ExcursionSale_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seaTrips = Integer.parseInt(scanner.nextLine());
        int mountainTrips = Integer.parseInt(scanner.nextLine());
        int profit = 0;

        while (true) {
            if (seaTrips == 0 && mountainTrips == 0) {
                System.out.println("Good job! Everything is sold.");
                break;
            }
            String destination = scanner.nextLine();
            if (destination.equals("Stop")) {
                break;
            }
            if (destination.equals("sea")) {
                if (seaTrips == 0) {
                    continue;
                }
                profit += 680;
                seaTrips--;
            } else if (destination.equals("mountain")) {
                if (mountainTrips == 0) {
                    continue;
                }
                profit += 499;
                mountainTrips--;
            }
        }
        System.out.printf("Profit: %d leva.", profit);
    }
}
