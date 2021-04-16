import java.util.Scanner;

public class PassengersPerFlight_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int companiesCount = Integer.parseInt(scanner.nextLine());
        int totalPassengers = 0;
        double avgPassengers = 0;
        int flightCount = 0;
        double maxPassengers = Integer.MIN_VALUE;
        String maxPassengersCompany = null;

        for (int i = 0; i < companiesCount; i++) {
            String name = scanner.nextLine();

            while (true) {
                String input = scanner.nextLine();
                if (input.equals("Finish")) {
                    avgPassengers = Math.floor(totalPassengers / flightCount);
                    System.out.printf("%s: %.0f passengers.%n", name, avgPassengers);
                    if(avgPassengers > maxPassengers) {
                        maxPassengers = avgPassengers;
                        maxPassengersCompany = name;
                    }
                    totalPassengers = 0;
                    flightCount = 0;
                    break;
                } else {
                    int passengers = Integer.parseInt(input);
                    totalPassengers += passengers;
                    flightCount++;
                }
            }
        }
        System.out.printf("%s has most passengers per flight: %.0f", maxPassengersCompany, maxPassengers);
    }
}
