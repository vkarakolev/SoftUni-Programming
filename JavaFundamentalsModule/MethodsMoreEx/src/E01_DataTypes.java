import java.text.DecimalFormat;
import java.util.Scanner;

public class E01_DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();

        switch (type){
            case "int":
                int n = Integer.parseInt(scanner.nextLine());
                System.out.println(readingInput(n));
                break;
            case "real":
                double d = Double.parseDouble(scanner.nextLine());
                System.out.printf("%.2f", readingInput(d));
                break;
            case "string":
                String input = scanner.nextLine();
                System.out.println(readingInput(input));
                break;
        }
    }

    static int readingInput (int n) {
        return n * 2;
    }

    static double readingInput (double n){
        return n * 1.5;
    }

    static String readingInput (String input) {
        return("$" + input + "$");
    }
}
