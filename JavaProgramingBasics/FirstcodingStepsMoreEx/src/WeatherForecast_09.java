import java.util.Scanner;

public class WeatherForecast_09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String weather = input.nextLine();
        if(weather.equals("sunny")){
            System.out.println("It's warm outside!");
        }else{
            System.out.println("It's cold outside!");
        }
    }
}
