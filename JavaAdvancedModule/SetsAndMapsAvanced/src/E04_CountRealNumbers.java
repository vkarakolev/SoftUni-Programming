import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class E04_CountRealNumbers {
    public static void main(String[] args) {

        double[] numbers = readArray(new Scanner(System.in).nextLine());
        LinkedHashMap<Double, Integer> sequences = new LinkedHashMap<>(numbers.length);

        for (double currentNum : numbers) {
            sequences.merge(currentNum, 1, Integer::sum);
        }

        sequences.entrySet().stream()
                .map(e -> String.format("%.1f -> %d", e.getKey(), e.getValue()))
                .forEach(System.out::println);
    }

    private static double[] readArray (String line){
        return Arrays.stream(line.split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}
