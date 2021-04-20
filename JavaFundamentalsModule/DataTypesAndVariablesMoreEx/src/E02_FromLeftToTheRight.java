import java.util.Scanner;

public class E02_FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linesCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < linesCount; i++) {
            String[] numbers = scanner.nextLine().split(" ");
            long first = Long.parseLong(numbers[0]);
            long second = Long.parseLong(numbers[1]);

            long greater = Math.max(first, second);

            int sum = 0;

            while(greater != 0){
                sum += Math.abs(greater % 10);
                greater /= 10;
            }

            System.out.println(sum);
        }
    }
}
