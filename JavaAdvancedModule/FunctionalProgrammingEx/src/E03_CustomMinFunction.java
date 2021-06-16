import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class E03_CustomMinFunction {
    public static void main(String[] args) {
        int[] numbers = Arrays.stream(new Scanner(System.in).nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> getMin = arr -> Arrays.stream(arr).min().orElse(0);
        System.out.println(getMin.apply(numbers));
    }
}
