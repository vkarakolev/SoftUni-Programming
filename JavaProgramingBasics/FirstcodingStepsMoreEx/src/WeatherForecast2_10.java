import java.util.Scanner;

public class WeatherForecast2_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double degrees = Double.parseDouble(input.nextLine());
        if(degrees < 5 || degrees > 35){
            System.out.println("unknown");
        }else if(degrees > 4.9 && degrees < 12){
            System.out.println("Cold");
        }else if(degrees > 11.9 && degrees < 15){
            System.out.println("Cool");
        }else if(degrees > 14.9 && degrees < 20.1){
            System.out.println("Mild");
        }else if(degrees > 20 && degrees < 26){
            System.out.println("Warm");
        }else if(degrees > 25.9 && degrees < 35.1){
            System.out.println("Hot");
        }
    }
}
