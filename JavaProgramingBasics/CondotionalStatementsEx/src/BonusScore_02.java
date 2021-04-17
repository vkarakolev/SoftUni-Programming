import java.util.Scanner;

public class BonusScore_02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int points = Integer.parseInt(input.nextLine());
        double bonusPoints = 0;

        if (points <= 100) {
            bonusPoints = 5;
        } else if (points > 100 && points <= 1000) {
            bonusPoints = points * 0.2;
        } else if (points > 1000) {
            bonusPoints = points * 0.1;
        }

        if (points % 2 == 0) {
            bonusPoints += 1;
        } else if (points % 10 == 5) {
            bonusPoints += 2;
        }

        double totalPoints = points + bonusPoints;

        System.out.printf("%.1f%n", bonusPoints);
        System.out.printf("%.1f", totalPoints);
    }
}
