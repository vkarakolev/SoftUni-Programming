import java.util.Scanner;

public class PrintAndSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNum = scanner.nextInt();
        int endNum = scanner.nextInt();
        int sum = 0;

        for (int i = startNum; i <= endNum; i++) {
            System.out.printf("%d ", i);
            sum += i;
        }
        System.out.printf("%nSum: %d", sum);
    }
}
