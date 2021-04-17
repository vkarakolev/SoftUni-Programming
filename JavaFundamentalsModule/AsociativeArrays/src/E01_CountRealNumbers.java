import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E01_CountRealNumbers {
    public static void main(String[] args) {
        TreeMap<Double, Integer> counts = new TreeMap<>();

        String[] numbersAsStrings = new Scanner(System.in).nextLine().split(" ");
        for (int i = 0; i < numbersAsStrings.length; i++) {
            double number = Double.parseDouble(numbersAsStrings[i]);

            Integer occurrences = counts.get(number);
            if(occurrences == null){
                occurrences = 0;
            }

            counts.put(number, occurrences + 1);
        }

        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }

    }
}
