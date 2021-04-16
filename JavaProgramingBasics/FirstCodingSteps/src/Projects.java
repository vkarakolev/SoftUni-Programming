import java.util.Scanner;

public class Projects {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        int count = Integer.parseInt(input.nextLine());
        int hours = count * 3;
        System.out.printf("The architect %s will need %d hours to complete %d project/s.", name, hours, count);
    }
}
