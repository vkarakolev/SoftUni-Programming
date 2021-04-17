import java.util.Scanner;

public class E01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagonCount = scanner.nextInt();

        int[] train = new int[wagonCount];
        int sum = 0;
        for (int i = 0; i < train.length; i++) {
            train[i] = scanner.nextInt();
            sum += train[i];
        }

        for (int i = 0; i < train.length; i++) {
            System.out.print(train[i] + " ");
        }

        System.out.println();
        System.out.println(sum);
    }
}
