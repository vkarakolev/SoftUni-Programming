import java.util.Scanner;

public class TimePlus15Min_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int startHour = Integer.parseInt(input.nextLine());
        int startMinutes = Integer.parseInt(input.nextLine());

        int startTimeMinutes = startHour * 60 + startMinutes;
        int timeAfter15Min = startTimeMinutes + 15;
        int finalHour = timeAfter15Min / 60;
        int finalMinutes = timeAfter15Min % 60;

        if(finalHour == 24){
            finalHour = 0;
        }

        System.out.printf("%d:%02d", finalHour, finalMinutes);
    }
}
