import java.util.Scanner;

public class WorkingHours_07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int hour = Integer.parseInt(input.nextLine());
        String day = input.nextLine();
        if(hour >= 10 && hour < 18){
            switch(day){
                case "Monday":
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "friday":
                case "Saturday":
                    System.out.println("open");
                    break;
                case "Sunday":
                    System.out.println("closed");
                    break;
            }
        } else {
            System.out.println("closed");
        }
    }
}
