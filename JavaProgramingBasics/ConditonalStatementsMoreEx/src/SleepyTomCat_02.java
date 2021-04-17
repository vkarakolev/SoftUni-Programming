import java.util.Scanner;

public class SleepyTomCat_02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int holidays = Integer.parseInt(input.nextLine());
        int norm = holidays * 127 + (365 - holidays) * 63;
        int hours = 0;
        int minutes = 0;

        if (norm > 30000){
            System.out.println("Tom will run away");
            hours = (norm - 30000) / 60;
            minutes = (norm - 30000) % 60;
            System.out.printf("%d hours and %d minutes more for play", hours, minutes);
        }else{
            System.out.println("Tom sleeps well");
            hours = (30000 - norm) / 60;
            minutes = (30000 - norm) % 60;
            System.out.printf("%d hours and %d minutes less for play", hours, minutes);
        }
    }
}
