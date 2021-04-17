import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = parseLineToInts(scanner);
        int wagonCapacity = Integer.parseInt(scanner.nextLine());
        String[] command = scanner.nextLine().split(" ");

        while(!command[0].equals("end")){
            if(command[0].equals("Add")){
                wagons.add(Integer.parseInt(command[1]));
            } else {
                for (Integer wagon : wagons) {
                    if(wagon + Integer.parseInt(command[0]) <= wagonCapacity){
                        wagons.set(wagons.indexOf(wagon), wagon + Integer.parseInt(command[0]));
                        break;
                    }
                }

            }

            command = scanner.nextLine().split(" ");
        }

        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");
        }


    }

    static List<Integer> parseLineToInts (Scanner scanner){
        String[] inputLine = scanner.nextLine().split(" ");
        List<Integer> inputList = new ArrayList<>();

        for (String s : inputLine) {
            inputList.add(Integer.parseInt(s));
        }

        return(inputList);
    }
}
