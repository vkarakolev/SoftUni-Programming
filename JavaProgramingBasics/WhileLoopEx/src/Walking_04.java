import java.util.Scanner;

public class Walking_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalSteps = 0;

        while (true) {
            String steps = scanner.nextLine();
            if (!steps.equals("Going home")) {
                totalSteps += Integer.parseInt(steps);
                if (totalSteps >= 10000) {
                    int moreSteps = totalSteps - 10000;
                    System.out.println("Goal reached! Good job!");
                    System.out.printf("%d steps over the goal!", moreSteps);
                    break;
                }
            } else {
                steps = scanner.nextLine();
                totalSteps += Integer.parseInt(steps);
                if (totalSteps >= 10000) {
                    int moreSteps = totalSteps - 10000;
                    System.out.println("Goal reached! Good job!");
                    System.out.printf("%d steps over the goal!", moreSteps);

                } else {
                    int lessSteps = 10000 - totalSteps;
                    System.out.printf("%d more steps to reach goal.", lessSteps);
                }
                break;
            }


        }
    }
}
