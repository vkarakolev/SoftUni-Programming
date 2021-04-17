import java.util.Scanner;

public class E01_Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int playersCount = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double waterPerDayForPerson = Double.parseDouble(scanner.nextLine());
        double foodPerDayForPerson = Double.parseDouble(scanner.nextLine());

        double foodAmount = foodPerDayForPerson * playersCount * days;
        double waterAmount = waterPerDayForPerson * playersCount * days;

        for (int i = 1; i <= days; i++) {
            double energyLost = Double.parseDouble(scanner.nextLine());
            groupEnergy -= energyLost;

            if (groupEnergy > 0) {
                if (i % 2 == 0){
                    groupEnergy *= 1.05;
                    waterAmount *= 0.7;
                }

                if (i % 3 == 0){
                    groupEnergy *= 1.1;
                    foodAmount -= foodAmount / playersCount;
                }
            } else {
                break;
            }
        }

        if(groupEnergy > 0){
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);
        } else {
            System.out.printf("You will run out of energy. " +
                    "You will be left with %.2f food and %.2f water.", foodAmount, waterAmount);
        }
    }
}
