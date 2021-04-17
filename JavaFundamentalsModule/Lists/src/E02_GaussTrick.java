import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E02_GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = parseLineToInt(scanner);

        for (int i = 0; i < numbers.size() - 1; i++) {
            int lastElement = numbers.get(numbers.size() - 1);
            numbers.set(i, numbers.get(i) + lastElement);
            numbers.remove(numbers.size() - 1);
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }


    }

    static List<Integer> parseLineToInt(Scanner scanner){
        String[] inputLine = scanner.nextLine().split(" ");
        List<Integer> inputList = new ArrayList<>();
        for (String num : inputLine) {
            inputList.add(Integer.parseInt(num));
        }

        return(inputList);
    }
}
