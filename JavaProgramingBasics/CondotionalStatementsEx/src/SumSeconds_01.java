import java.util.Scanner;

public class SumSeconds_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int firstTime = Integer.parseInt(input.nextLine());
        int secondTime = Integer.parseInt(input.nextLine());
        int thirdTime = Integer.parseInt(input.nextLine());

        int totalTime = firstTime + secondTime + thirdTime;
        int timeInMinutes = totalTime / 60;
        int timeInSeconds = totalTime % 60;

        if (timeInSeconds < 10){
            System.out.printf("%d:0%d", timeInMinutes, timeInSeconds);
        }else{
            System.out.printf("%d:%d", timeInMinutes, timeInSeconds);
        }
    }
}
