import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E01_CountCharsInAString {
    public static void main(String[] args) {
        Map<Character, Integer> sequences = new LinkedHashMap<>();
        String input = new Scanner(System.in).nextLine();

        for (int i = 0; i < input.length(); i++) {

            char character = input.charAt(i);
            if(character == 32){
                continue;
            }

            Integer count = sequences.get(character);
            if(count == null){
                count = 0;
            }

            sequences.put(character, count + 1);
        }

        for (Map.Entry<Character, Integer> entry : sequences.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


    }
}
