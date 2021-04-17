import java.util.Scanner;

public class Journey_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String destination = null;
        String stay = null;
        double expenses = 0;

        if (budget <= 100) {
            destination = "Bulgaria";

            if (season.equals("summer")) {
                stay = "Camp";
                expenses = budget * 0.3;
            } else if (season.equals("winter")) {
                stay = "Hotel";
                expenses = budget * 0.7;
            }
        } else if (budget <= 1000) {
            destination = "Balkans";

            if (season.equals("summer")) {
                stay = "Camp";
                expenses = budget * 0.4;
            } else if (season.equals("winter")) {
                stay = "Hotel";
                expenses = budget * 0.8;
            }
        } else if (budget > 1000) {
            destination = "Europe";
            stay = "Hotel";
            expenses = budget * 0.9;
        }

        System.out.printf("Somewhere in %s%n%s - %.2f", destination, stay, expenses);
    }

}

