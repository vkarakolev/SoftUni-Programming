import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class E04_ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = parseLineToInts(scanner);

        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "Add":
                    numbers.add(Integer.parseInt(command[1]));
                    break;
                case "Remove":
                    numbers.remove((Integer)Integer.parseInt(command[1]));
                    break;
                case "RemoveAt":
                    numbers.remove(Integer.parseInt(command[1]));
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(command[2]), Integer.parseInt(command[1]));
                    break;
            }
            command = scanner.nextLine().split(" ");
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }


    }

    static List<Integer> parseLineToInts(Scanner scanner) {
        String[] inputLine = scanner.nextLine().split(" ");
        List<Integer> inputList = new ArrayList<>();

        for (String s : inputLine) {
            inputList.add(Integer.parseInt(s));
        }

        return (inputList);
    }
}
