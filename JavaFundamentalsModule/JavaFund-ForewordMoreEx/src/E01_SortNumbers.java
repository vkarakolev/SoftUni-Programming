import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E01_SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int inputNum = Integer.parseInt(scanner.nextLine());
            numbers.add(inputNum);
        }

        numbers.stream()
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
    }
}
