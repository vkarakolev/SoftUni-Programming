import java.util.Scanner;

public class HousePainting_07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x = Double.parseDouble(input.nextLine()); // Широчина
        double y = Double.parseDouble(input.nextLine()); // Дължина
        double h = Double.parseDouble(input.nextLine()); // Височина
        double doorAndWindows = 1.2 * 2 + 2 * (1.5 * 1.5);
        double walls = 2 * (x * x) + 2 * (x * y) - doorAndWindows;
        double greenPaint = walls / 3.4;
        double roof = (x * h) + 2 * (x * y);
        double redPaint = roof / 4.3;
        System.out.printf("%.2f%n%.2f", greenPaint, redPaint);
    }
}
