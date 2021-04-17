import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> userData = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
             String[] commands = scanner.nextLine().split("\\s+");
             String userName = commands[1];

            if(commands[0].equals("register")){
                 String licensePlateNumber = commands[2];

                 if(userData.get(userName) == null){
                    userData.put(userName, licensePlateNumber);
                     System.out.printf("%s registered %s successfully%n", userName, userData.get(userName));
                 } else {
                     System.out.printf("ERROR: already registered with plate number %s%n", userData.get(userName));
                 }

             } else {
                if(userData.get(userName) == null){
                    System.out.printf("ERROR: user %s not found%n", userName);
                } else {
                    userData.remove(userName);
                    System.out.printf("%s unregistered successfully%n", userName);
                }
             }
        }

        for (Map.Entry<String, String> entry : userData.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
