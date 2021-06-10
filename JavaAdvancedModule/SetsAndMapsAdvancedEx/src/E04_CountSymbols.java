import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E04_CountSymbols {
    public static void main(String[] args) {
        String text = new Scanner(System.in).nextLine();

        HashMap<String, Integer> charOccurrences = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            String currentChar = String.valueOf(text.charAt(i));
            charOccurrences.merge(currentChar, 1, Integer::sum);
        }

        charOccurrences.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> String.format("%s: %d time/s", e.getKey(), e.getValue()))
                .forEach(System.out::println);
    }
}
