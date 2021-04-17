import java.util.Scanner;

public class E03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputLines = scanner.nextInt();

        int[] firstArr = new int[inputLines];
        int[] secondArr = new int[inputLines];

        for (int i = 0; i < inputLines; i++) {
            if (i % 2 == 0) {
                firstArr[i] = scanner.nextInt();
                secondArr[i] = scanner.nextInt();
            } else {
                secondArr[i] = scanner.nextInt();
                firstArr[i] = scanner.nextInt();
            }
        }

        for (int i: firstArr) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : secondArr) {
            System.out.print(i + " ");
        }

    }
} 
