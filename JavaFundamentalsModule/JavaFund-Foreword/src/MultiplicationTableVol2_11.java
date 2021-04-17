import java.util.Scanner;

public class MultiplicationTableVol2_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int startingPoint = scanner.nextInt();

        if (startingPoint > 10) {
            System.out.printf("%d X %d = %d", num, startingPoint, num * startingPoint);
        } else {
            for (int i = startingPoint; i <= 10; i++) {
                System.out.printf("%d X %d = %d%n", num, i, num * i);
            }
        }
    }
}
