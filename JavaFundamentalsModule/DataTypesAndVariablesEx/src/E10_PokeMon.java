import java.util.Scanner;

public class E10_PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        short m = scanner.nextShort();
        byte y = scanner.nextByte();
        short targetCount = 0;
        int halfN = n / 2;

        while (n >= m) {
            n -= m;
            targetCount++;

            if (y > 0 && n == halfN && n % halfN == 0){
                n /= y;
            }
        }
        System.out.println(n);
        System.out.print(targetCount);
    }
}
