import java.util.Scanner;

public class Balls_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int totalPoints = 0;
        int redBallsCount = 0;
        int orangeBallsCount = 0;
        int yellowBallsCount = 0;
        int whiteBallsCount = 0;
        int blackBallsCount = 0;
        int otherColorsCount = 0;

        for(int i = 1; i <= n; i++){
            String color = scanner.nextLine();

            switch(color){
                case "red":
                    totalPoints += 5;
                    redBallsCount++;
                    break;
                case "orange":
                    totalPoints += 10;
                    orangeBallsCount++;
                    break;
                case "yellow":
                    totalPoints += 15;
                    yellowBallsCount++;
                    break;
                case "white":
                    totalPoints += 20;
                    whiteBallsCount++;
                    break;
                case "black":
                    totalPoints /= 2;
                    blackBallsCount++;
                    break;
                default:
                    otherColorsCount++;
                    break;
            }
        }

        System.out.printf("Total points: %d%n",totalPoints);
        System.out.printf("Points from red balls: %d%n", redBallsCount);
        System.out.printf("Points from orange balls: %d%n", orangeBallsCount);
        System.out.printf("Points from yellow balls: %d%n", yellowBallsCount);
        System.out.printf("Points from white balls: %d%n", whiteBallsCount);
        System.out.printf("Other colors picked: %d%n", otherColorsCount);
        System.out.printf("Divides from black balls: %d", blackBallsCount);

    }
}
