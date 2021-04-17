import java.util.Scanner;

public class E02_PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pounds  = scanner.nextDouble();
        System.out.printf("%.3f", pounds * 1.31);
    }
}
