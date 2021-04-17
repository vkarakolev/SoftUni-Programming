import java.util.Scanner;

public class E02_BitAtPosition1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        inputNum >>= 1;
        int bitAt1 = inputNum & 1;
        System.out.println(bitAt1);
    }
}
