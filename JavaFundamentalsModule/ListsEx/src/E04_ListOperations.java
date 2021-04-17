import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E04_ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = parseLineToInts(scanner);

        String[] command = scanner.nextLine().split(" ");
        while(!command[0].equals("End")){
            switch(command[0]){
                case "Add":
                    numbers.add(Integer.parseInt(command[1]));
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    if(checkIndex(index, numbers.size())) {
                        numbers.add(index, Integer.parseInt(command[1]));
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(command[1]);
                    if(checkIndex(index, numbers.size())) {
                        numbers.remove(index);
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(command[2]);
                    if(command[1].equals("left")){
                        for (int i = 0; i < count; i++) {
                            numbers.add(numbers.get(0));
                            numbers.remove(0);
                        }
                    } else {
                        for (int i = 0; i < count; i++) {
                            numbers.add(0, numbers.get(numbers.size() - 1));
                            numbers.remove(numbers.size() - 1);
                        }
                    }
                    break;
            }

            command = scanner.nextLine().split(" ");
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }

    static boolean checkIndex (int index, int size){
        boolean isIn = true;
        if(0 > index || index > size - 1) {
            System.out.println("Invalid index");
            isIn = false;
        }
        return (isIn);
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
