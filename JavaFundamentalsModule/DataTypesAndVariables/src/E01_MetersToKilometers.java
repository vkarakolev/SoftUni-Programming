import java.util.Scanner;

public class E01_MetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double distance = scanner.nextDouble();
        System.out.printf("%.2f", distance / 1000);

    }
}
