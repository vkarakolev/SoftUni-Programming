import java.util.Scanner;

public class E03_PthBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        int position = scanner.nextInt();

        inputNum >>= position;
        int bitAtP = inputNum & 1;
        System.out.println(bitAtP);
    }
}
