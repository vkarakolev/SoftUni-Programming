import java.util.LinkedHashMap;
import java.util.Scanner;

public class E06_MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        String command = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        while (!command.equals("stop")){
            if (resources.get(command) == null) {
                resources.put(command, quantity);
            } else {
                resources.put(command, resources.get(command) + quantity);
            }

            command = scanner.nextLine();

            if(command.equals("stop")){
                break;
            }

            quantity = Integer.parseInt(scanner.nextLine());
        }

        resources.entrySet().stream()
                .map(e -> String.format("%s -> %d", e.getKey(), e.getValue()))
                .forEach(System.out::println);
    }
}
