import java.util.LinkedHashMap;
import java.util.Scanner;

public class E07_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        int counter = 1;
        String command = scanner.nextLine();
        String name = null;
        while (!command.equals("stop")){
            if(counter % 2 != 0){
                name = command;
            } else {
                if(!command.contains(".com") && !command.contains(".uk") && !command.contains(".us")){
                    emails.put(name, command);
                }
            }

            counter++;
            command = scanner.nextLine();
        }

        emails.entrySet().stream()
                .map(e -> String.format("%s -> %s", e.getKey(), e.getValue()))
                .forEach(System.out::println);
    }
}
