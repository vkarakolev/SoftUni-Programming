import java.util.Scanner;

public class Sequence2k1_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;

        while(count <= n) {
            count *= 2;
            count++;
            if (count <= n) {
                System.out.println(count);
            }
        }
    }
}
