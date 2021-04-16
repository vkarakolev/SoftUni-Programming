import java.util.Scanner;

public class OnTime_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinute = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinute = Integer.parseInt(scanner.nextLine());

        int examTimeInMin = examHour * 60 + examMinute;
        int arrivalTimeInMin = arrivalHour * 60 + arrivalMinute;
        int minutesDiff = examTimeInMin - arrivalTimeInMin;
        int hoursDiff = 0;

        if(arrivalTimeInMin <= examTimeInMin && arrivalTimeInMin >= examTimeInMin - 30){
            System.out.println("On time");
        }else if (arrivalTimeInMin < examTimeInMin - 30){
            System.out.println("Early");
        }else if (arrivalTimeInMin > examTimeInMin){
            System.out.println("Late");
        }

        if(minutesDiff > 0 && minutesDiff < 60){
            System.out.printf("%d minutes before the start", minutesDiff);
        } else if (minutesDiff > 0 && minutesDiff >= 60){
            hoursDiff = minutesDiff / 60;
            minutesDiff %= 60;
            System.out.printf("%d:%02d hours before the start", hoursDiff, minutesDiff);
        } else if (minutesDiff < 0 && minutesDiff > -60){
            System.out.printf("%d minutes after the start", Math.abs(minutesDiff));
        } else if (minutesDiff < 0 && minutesDiff <= 60){
            hoursDiff = Math.abs(minutesDiff / 60);
            minutesDiff = Math.abs(minutesDiff %= 60);
            System.out.printf("%d:%02d hours after the start", hoursDiff, minutesDiff);
        }
    }
}
