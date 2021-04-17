import java.text.DecimalFormat;
import java.util.Scanner;

public class E08_MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();
        int power = scanner.nextInt();

        System.out.println(new DecimalFormat("0.####").format(mathPower(number, power)));
    }

    static double mathPower(double num, int power){
        double poweredNum = num;
        for (int i = 2; i <= power; i++) {
            poweredNum *= num;
        }
        return (poweredNum);
    }
}
