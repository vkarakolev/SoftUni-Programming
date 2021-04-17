import java.util.Scanner;

public class E07_WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int inputLitters = Integer.parseInt(scanner.nextLine());
            if (sum + inputLitters <= 255) {
                sum += inputLitters;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(sum);
    }
}
