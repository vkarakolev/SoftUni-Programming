import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E05_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = readIntegerList(scanner);
        int[] bomb = readIntegerArray(scanner, 2);

        int i = 0;
        while (i < numbers.size() - 1) {

            if ((numbers.get(i) == bomb[0])) {
                int rotations = 2 * bomb[1] + 1;
                int removeIndex = numbers.indexOf(bomb[0]) - bomb[1];

                if (0 > removeIndex) {
                    rotations -= Math.abs(removeIndex);
                    removeIndex = 0;
                }

                for (int j = 0; j < rotations; j++) {
                    if (removeIndex > numbers.size() - 1) {
                        break;
                    } else {
                        numbers.remove(removeIndex);
                    }
                }
                i = 0;
            } else {
                i++;
            }
        }

        int sum = 0;
        for (Integer n : numbers) {
            sum += n;
        }

        System.out.println(sum);
    }


    static int[] readIntegerArray(Scanner scanner, int length) {

        String[] numbersAsStrings = scanner.nextLine().split("\\s+");
        int[] arr = new int[length];

        for (int i = 0; i < numbersAsStrings.length; i++) {
            arr[i] = Integer.parseInt(numbersAsStrings[i]);
        }

        return (arr);
    }

    static List<Integer> readIntegerList(Scanner scanner) {
        String[] inputLine = scanner.nextLine().split("\\s+");
        List<Integer> inputList = new ArrayList<>();

        for (String s : inputLine) {
            inputList.add(Integer.parseInt(s));
        }

        return (inputList);
    }
}
