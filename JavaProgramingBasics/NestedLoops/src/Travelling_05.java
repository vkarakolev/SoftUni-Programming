import java.util.Scanner;

public class Travelling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalSavings = 0;

        while(true){
            String destination = scanner.nextLine();
            if(destination.equals("End")){
                break;
            }
            double budget = Double.parseDouble(scanner.nextLine());

            while(true){
                double savings = Double.parseDouble(scanner.nextLine());
                totalSavings += savings;
                if(totalSavings >= budget){
                    System.out.printf("Going to %s!%n", destination);
                    totalSavings = 0;
                    break;
                }
            }


        }
    }
}
