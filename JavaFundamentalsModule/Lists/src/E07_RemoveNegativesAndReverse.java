import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E07_RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = parseLineToInts(scanner);
        Collections.reverse(numbers);

        int i = 0;
        while(i < numbers.size()){
            if(numbers.get(i) < 0){
                numbers.remove(i);
            } else {
                i++;
            }
        }

        if(numbers.size() == 0){
            System.out.println("empty");
        } else {
            for (Integer number : numbers) {
                System.out.print(number + " ");
            }
        }
    }

    static List<Integer> parseLineToInts(Scanner scanner){
        String[] inputLine = scanner.nextLine().split(" ");
        List<Integer> inputList = new ArrayList<>();

        for (String s : inputLine) {
            inputList.add(Integer.parseInt(s));
        }

        return(inputList);
    }
}
