import java.util.Scanner;

public class E03_FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double first = Double.parseDouble(scanner.nextLine());
        double second = Double.parseDouble(scanner.nextLine());

        double epsilon = 0.000001;

        if(Math.abs(first - second) < epsilon){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
