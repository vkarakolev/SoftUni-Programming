import java.util.Scanner;

public class E03_PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linesCount = scanner.nextInt();

        for (int i = 1; i <= linesCount; i++) {
            printLine(i);
            System.out.println();
        }

        for (int i = linesCount - 1; i > 0; i--) {
            printLine(i);
            System.out.println();
        }
    }

    static void printLine(int count) {

        for (int i = 1; i <= count; i++) {
            System.out.print(i + " ");
        }

    }
}
