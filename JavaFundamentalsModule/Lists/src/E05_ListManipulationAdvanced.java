import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E05_ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = parseLineToInts(scanner);
        String[] command = scanner.nextLine().split(" ");

        while(!command[0].equals("end")){
            switch(command[0]){
                case "Contains":
                    boolean isThereSuchNumber = false;
                    for (Integer number : numbers) {
                        if(number == Integer.parseInt(command[1])){
                            isThereSuchNumber = true;
                        }
                    }

                    if(isThereSuchNumber){
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    switch(command[1]){
                        case "even":
                            for (Integer number : numbers) {
                                if(number % 2 == 0){
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "odd":
                            for (Integer number : numbers) {
                                if(number % 2 != 0){
                                    System.out.print(number + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (Integer number : numbers) {
                        sum += number;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                        switch(command[1]){
                            case ">":
                                for (Integer number : numbers) {
                                    if(number > Integer.parseInt(command[2])){
                                        System.out.print(number + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case ">=":
                                for (Integer number : numbers) {
                                    if(number >= Integer.parseInt(command[2])){
                                        System.out.print(number + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case "<":
                                for (Integer number : numbers) {
                                    if(number < Integer.parseInt(command[2])){
                                        System.out.print(number + " ");
                                    }
                                }
                                System.out.println();
                                break;
                            case "<=":
                                for (Integer number : numbers) {
                                    if(number <= Integer.parseInt(command[2])){
                                        System.out.print(number + " ");
                                    }
                                }
                                System.out.println();
                                break;
                        }
                    break;
            }

            command = scanner.nextLine().split(" ");
        }
    }

    static List<Integer> parseLineToInts (Scanner scanner){
        String[] input = scanner.nextLine().split(" ");
        List<Integer> inputList = new ArrayList<>();

        for (String s : input) {
            inputList.add(Integer.parseInt(s));
        }

        return(inputList);
    }
}
