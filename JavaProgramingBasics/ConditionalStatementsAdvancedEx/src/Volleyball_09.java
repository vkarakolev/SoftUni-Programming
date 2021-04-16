import java.util.Scanner;

public class Volleyball_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine();
        int p = Integer.parseInt(scanner.nextLine());
        int h = Integer.parseInt(scanner.nextLine());

        double sofiaPlay = (48 - h) * 0.75;
        double holidayPlay = (double) p * 2/3;
        double playingDaysSum = sofiaPlay + holidayPlay + h;

        if (year.equals("leap")){
            playingDaysSum *= 1.15;
        }
        System.out.printf("%.0f", Math.floor(playingDaysSum));
    }
}
