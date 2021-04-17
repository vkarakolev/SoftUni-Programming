import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E02_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while(!input.equals("stop")){
            int count = Integer.parseInt(scanner.nextLine());

            Integer currentCount = resources.get(input);
            if(currentCount == null){
                currentCount = 0;
            }
            currentCount += count;

            resources.put(input, currentCount);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
