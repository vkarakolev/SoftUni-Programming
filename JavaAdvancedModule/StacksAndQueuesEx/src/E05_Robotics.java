import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05_Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robotsData = scanner.nextLine().split(";");

        LinkedHashMap<String, Integer> robots =  getRobotsMap(robotsData);
        LinkedHashMap<String, Integer> robotsWorkingTime = GetRobotWorkingTimeMap(robotsData);

        String startTime = scanner.nextLine();
        int startTimeInSeconds = getTimeInSeconds(startTime);

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scanner.nextLine();
        while (!product.equals("End")){
            products.offer(product);
            product = scanner.nextLine();
        }

        while (!products.isEmpty()){
            String currentProduct = products.poll();
            startTimeInSeconds++;
            decreaseWorkingTime(robotsWorkingTime);
            boolean isTaken = false;
            for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
                if(robot.getValue() == 0){
                    System.out.println(robot.getKey() + " - " + currentProduct + " [" + getStartTime(startTimeInSeconds) + "]");
                    robotsWorkingTime.put(robot.getKey(), robots.get(robot.getKey()));
                    isTaken = true;
                    break;
                }
            }

            if (!isTaken){
                products.offer(currentProduct);
            }
        }
    }

    private static void decreaseWorkingTime(LinkedHashMap<String, Integer> robotsWorkingTime) {
        for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
            if(robot.getValue() > 0){
                robotsWorkingTime.put(robot.getKey(), robot.getValue() - 1);
            }
        }
    }

    private static String getStartTime (int startTimeInSeconds){
        int hours = (startTimeInSeconds / 3600) % 24;
        int minutes = startTimeInSeconds % 3600 / 60;
        int seconds = startTimeInSeconds % 60;

        return String.format("%02d:%02d:%02d" ,hours, minutes, seconds);
    }

    private static LinkedHashMap<String, Integer> GetRobotWorkingTimeMap(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String data : robotsData) {
            String robotName = data.split("-")[0];
            robots.put(robotName, 0);
        }
        return robots;
    }

    private static LinkedHashMap<String, Integer> getRobotsMap(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String data : robotsData) {
            String robotName = data.split("-")[0];
            int processingTime = Integer.parseInt(data.split("-")[1]);
            robots.put(robotName, processingTime);
        }
        return robots;
    }

    private static int getTimeInSeconds(String time){
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        int seconds = Integer.parseInt(time.split(":")[2]);

        return hours * 3600 + minutes * 60 + seconds;
    }
}
