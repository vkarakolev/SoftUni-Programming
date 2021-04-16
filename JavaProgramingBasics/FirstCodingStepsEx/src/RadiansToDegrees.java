import java.util.Scanner;

public class RadiansToDegrees {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double radians = Double.parseDouble(input.nextLine());
        double degrees = radians * 180 / Math.PI;
        System.out.printf("%.0f", degrees);
    }
}
