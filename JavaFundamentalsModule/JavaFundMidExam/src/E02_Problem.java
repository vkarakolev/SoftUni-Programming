import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E02_Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> shoppingList = new ArrayList<>();
        shoppingList = addLineInList(input);

        input = scanner.nextLine();
        while (!input.equals("Go Shopping!")){
            String[] commandLine = input.split("\\s+");
            String command = commandLine[0];
            String item = commandLine[1];

            switch (command){
                case "Urgent":
                    if(!shoppingList.contains(item)){
                        shoppingList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    if (shoppingList.contains(item)){
                        shoppingList.remove(item);
                    }
                    break;
                case "Correct":
                    if(shoppingList.contains(item)){
                        shoppingList.set(shoppingList.indexOf(item), commandLine[2]);
                    }
                    break;
                case "Rearrange":
                    if(shoppingList.contains(item)){
                        shoppingList.remove(item);
                        shoppingList.add(item);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        String output = String.join(", ", shoppingList);

        System.out.println(output);

    }

    static List<String> addLineInList (String input){
        String[] inputArray = input.split("!");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            list.add(inputArray[i]);
        }
        return list;
    }
}
