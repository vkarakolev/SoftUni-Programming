import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E02_RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().split("\\s+");

        List<String> repeatedWords = new ArrayList<>();
        for (int i = 0; i < inputLine.length; i++) {
            repeatedWords.add(repeatString(inputLine[i], inputLine[i].length()));
        }

        System.out.println(String.join("", repeatedWords));
    }

    static String repeatString (String word, int count){
        String[] words = new String[count];
        for (int i = 0; i < count; i++) {
            words[i] = word;
        }

        return (String.join("", words));
    }
}
