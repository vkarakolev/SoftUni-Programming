import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E02_ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = parseLineToInts(scanner);

        String command = scanner.nextLine();
        while(!command.equals("end")){
            String[] commands = command.split("\\s+");
            int value = Integer.parseInt(commands[1]);
            switch(commands[0]){
                case "Delete":
                    int i = 0;

                    while(i < list.size()){
                        if(list.get(i) == value){
                            list.remove((Integer)value);
                        } else {
                            i++;
                        }
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commands[2]);

                    if(index > list.size() - 1 || index < 0) {
                        break;
                    }

                    list.add(index, value);
                    break;
             }

             command = scanner.nextLine();
         }

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    static List<Integer> parseLineToInts (Scanner scanner){
        String[] inputLine = scanner.nextLine().split("\\s+");
        List<Integer> inputList = new ArrayList<>();

        for (String s : inputLine) {
            inputList.add(Integer.parseInt(s));
        }

        return(inputList);
    }
}

