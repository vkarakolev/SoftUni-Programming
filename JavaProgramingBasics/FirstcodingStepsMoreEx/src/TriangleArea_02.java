import java.util.Scanner;

public class TriangleArea_02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = Double.parseDouble(input.nextLine());
        double h = Double.parseDouble(input.nextLine());
        double area = a * h / 2.0;
        System.out.printf("%.2f", area);
    }
}
