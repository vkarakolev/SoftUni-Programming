import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandsCount = Integer.parseInt(scanner.nextLine());
        List<String> members = new ArrayList<>();

        for (int i = 0; i < commandsCount; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[2]){
                case "going!":
                    if(checkIfInGuestList(command, members)){
                        System.out.printf("%s is already in the list!%n", command[0]);
                    } else {
                        members.add(command[0]);
                    }
                    break;
                case "not":
                    if(checkIfInGuestList(command, members)){
                        members.remove(command[0]);
                    } else {
                        System.out.printf("%s is not in the list!%n", command[0]);
                    }
                    break;
            }
        }

        for (String member : members) {
            System.out.println(member);
        }

    }

    static boolean checkIfInGuestList (String[] command, List<String> guestList){
        boolean isIn = false;

        for (String s : guestList) {
            if(s.equals(command[0])){
                isIn = true;
                break;
            }
        }

        return (isIn);
    }
}
