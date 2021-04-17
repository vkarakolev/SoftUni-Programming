import java.util.Arrays;
import java.util.Scanner;

public class E11_ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        while(!input.equals("end")){
            String[] inputArray = input.split(" ");
            String command = inputArray[0];
            switch(command){
                case "exchange":
                    int index = Integer.parseInt(inputArray[1]);
                    if(0 <= index && index < numbers.length){
                        //method
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    String type = inputArray[1];
                    
                    break;
                case "min": break;
                case "first": break;
                case "last": break;
            }

            input = scanner.nextLine();
        }
    }
}
