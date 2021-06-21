import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E07_FindTheSmallestElement {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> getMin = x -> x.stream()
                .mapToInt(e -> e)
                .min()
                .orElse(0);

        System.out.println(numbers.lastIndexOf(getMin.apply(numbers)));
    }
}
