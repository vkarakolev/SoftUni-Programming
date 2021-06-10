import java.util.HashMap;
import java.util.Scanner;

public class E05_PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> contacts = new HashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("search")){
            String[] contactData = command.split("-");
            String name = contactData[0];
            String number = contactData[1];

            contacts.put(name, number);

            command = scanner.nextLine();
        }

        command = scanner.nextLine();
        while (!command.equals("stop")){
            if(contacts.get(command) == null){
                System.out.printf("Contact %s does not exist.%n", command);
            } else {
                System.out.printf("%s -> %s%n", command, contacts.get(command));
            }

            command = scanner.nextLine();
        }
    }
}
