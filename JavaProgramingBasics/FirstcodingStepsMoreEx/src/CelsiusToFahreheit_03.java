import java.util.Scanner;

public class CelsiusToFahreheit_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double celsius = Double.parseDouble(input.nextLine());
        double fahrenheit = 32 + celsius * 1.8;
        System.out.printf("%.2f", fahrenheit);
    }
}
