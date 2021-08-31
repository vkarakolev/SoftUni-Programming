import java.util.Scanner;

public class E01_SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println(calculateSqrt(scanner));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Good bye");
        }
    }

    private static double calculateSqrt(Scanner scanner) {
        String input = scanner.nextLine();

        for (char c : input.toCharArray()) {
            if(!Character.isDigit(c)) {
                throw new NumberFormatException("Invalid number");
            }
        }

        double result = Double.parseDouble(input);
        return Math.sqrt(result);
    }
}
