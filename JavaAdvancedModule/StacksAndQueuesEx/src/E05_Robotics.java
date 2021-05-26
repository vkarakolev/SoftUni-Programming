import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class E05_Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robotsData = scanner.nextLine().split(";");

        LinkedHashMap<String, Integer> robots =  getRobotsMap(robotsData);
        String startTime = scanner.nextLine();
        int startTimeInSeconds = getTimeInSeconds(startTime);

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scanner.nextLine();
        while (!product.equals("End")){
            products.offer(product);
            product = scanner.nextLine();
        }

        

    }

    public static LinkedHashMap<String, Integer> getRobotsMap(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String data : robotsData) {
            String robotName = data.split("-")[0];
            int processingTime = Integer.parseInt(data.split("-")[1]);
            robots.put(robotName, processingTime);
        }
        return robots;
    }

    public static int getTimeInSeconds(String time){
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        int seconds = Integer.parseInt(time.split(":")[2]);

        return hours * 3600 + minutes * 60 + seconds;
    }
}
