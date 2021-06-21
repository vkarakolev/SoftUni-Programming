import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int divider = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);
        numbers.removeIf(n -> n % divider == 0);
        numbers.forEach(e -> System.out.print(e + " "));
    }
}
