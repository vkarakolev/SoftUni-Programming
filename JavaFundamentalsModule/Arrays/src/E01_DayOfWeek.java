import java.util.Scanner;

public class E01_DayOfWeek {
    public static void main(String[] args) {
        String[] daysOfWeek = new String[]{
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };

        int day = new Scanner(System.in).nextInt();
        if (0 < day && day < 8) {
            System.out.println(daysOfWeek[day - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
