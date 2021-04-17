import java.util.Scanner;

public class E09_CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int centuries = Integer.parseInt(scanner.nextLine());;
        int years = centuries * 100;
        int days = (int)(years * 365.2422);
        int hours = days * 24;
        long minutes = (long)hours * 60;

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes",
                centuries, years, days, hours, minutes);
    }
}
