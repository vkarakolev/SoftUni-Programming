import java.util.Scanner;
import java.util.TreeSet;

public class E02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> guests = getMissingMembers(scanner);
        System.out.println(guests.size());
        printSet(guests);
    }

    public static TreeSet<String> getMissingMembers (Scanner scanner){
        TreeSet<String> members = new TreeSet<>();

        String command = scanner.nextLine();
        boolean isStarted = false;
        while (!command.equals("END")){
            if(command.equals("PARTY")){
                isStarted = true;
                command = scanner.nextLine();
                continue;
            }

            if(!isStarted){
                members.add(command);
            } else {
                members.remove(command);
            }

            command = scanner.nextLine();
        }
        return members;
    }

    public static void printSet(TreeSet<String> set){
        for (String s : set) {
            System.out.println(s);
        }
    }
}
