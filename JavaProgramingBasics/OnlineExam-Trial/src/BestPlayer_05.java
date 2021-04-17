import java.util.Scanner;

public class BestPlayer_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxGoals = 0;
        String bestPlayer = null;

        while (true) {
            String name = scanner.nextLine();
            if (name.equals("END")) {
                break;
            }
            int goals = Integer.parseInt(scanner.nextLine());

            if (goals > maxGoals) {
                maxGoals = goals;
                bestPlayer = name;
            }

            if (maxGoals >= 10) {
                break;
            }
        }

        System.out.printf("%s is the best player!%n", bestPlayer);
        if (maxGoals >= 3) {
            System.out.printf("He has scored %d goals and made a hat-trick !!!", maxGoals);
        } else {
            System.out.printf("He has scored %d goals.", maxGoals);
        }
    }
}
