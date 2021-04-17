import java.util.Scanner;

public class E10_LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] field = new int[n];

        String[] bugIndexes = scanner.nextLine().split(" ");
        for (int i = 0; i < bugIndexes.length; i++) {
            field[i] = 1;
        }
    }
}
