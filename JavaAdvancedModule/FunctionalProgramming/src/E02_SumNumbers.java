import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class E02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(", ");
        Function<String[], IntStream> map = arr -> Arrays.stream(arr).mapToInt(Integer::parseInt);
        IntStream stream = map.apply(tokens);

        Function <IntStream, Long> count = IntStream::count;
        Function <IntStream, Integer> sum = IntStream::sum;

        System.out.println("Count = " + count.apply(map.apply(tokens)));
        System.out.println("Sum = " + sum.apply(stream));
    }
}
