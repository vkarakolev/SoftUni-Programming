import java.util.Scanner;

public class CircleAreaAndPerimeter_08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double r = Double.parseDouble(input.nextLine());
        double perimeter = 2 * Math.PI * r;
        double area = Math.PI * r * r;
        System.out.printf("%.2f%n%.2f", area, perimeter);
    }
}
