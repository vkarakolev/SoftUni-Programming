import java.util.Scanner;

public class Firm_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int necessaryHours = Integer.parseInt(input.nextLine());
        int deadline = Integer.parseInt(input.nextLine());
        int employees = Integer.parseInt(input.nextLine());

        double workingHours = Math.floor(0.9 * deadline * 8 + employees * 2 * deadline);

        if (workingHours >= necessaryHours){
            double hoursLeft = workingHours - necessaryHours;
            System.out.printf("Yes!%.0f hours left.", hoursLeft);
        } else {
            double hoursLack = necessaryHours - workingHours;
            System.out.printf("Not enough time!%.0f hours needed.", hoursLack);
        }
    }
}
