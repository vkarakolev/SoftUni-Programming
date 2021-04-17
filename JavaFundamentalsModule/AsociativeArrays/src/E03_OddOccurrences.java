import java.util.*;

public class E03_OddOccurrences {
    public static void main(String[] args) {
        Map<String, Integer> wordOccurrences = new LinkedHashMap<>();

        String[] input = new Scanner(System.in).nextLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            String word = input[i].toLowerCase();
            Integer occurrences = wordOccurrences.get(word);
            if(occurrences == null){
                occurrences = 0;
            }

            wordOccurrences.put(word, occurrences + 1);
        }

        List<String> odds = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordOccurrences.entrySet()) {
            if (entry.getValue() % 2 == 1){
                odds.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", odds));
    }
}
