import java.util.Scanner;

public class WorldSwimmingRecord_07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
            double record = Double.parseDouble(input.nextLine());
            double distance = Double.parseDouble(input.nextLine());
            double timePerMeter = Double.parseDouble(input.nextLine());

            double swimmingTime = distance * timePerMeter;
            double delayTime = Math.floor(distance / 15) * 12.5;
            double totalTime = swimmingTime + delayTime;

            if (totalTime < record){
                System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
            } else {
                double needSeconds = totalTime - record;
                System.out.printf("No, he failed! He was %.2f seconds slower.", needSeconds);
            }
    }
}
