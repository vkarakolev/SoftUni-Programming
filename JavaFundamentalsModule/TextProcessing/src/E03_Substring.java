import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03_Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keyWord = scanner.nextLine();
        String text = scanner.nextLine();
        String result = text;

        int nextWordIndex = result.indexOf(keyWord, 0);
        while(nextWordIndex != -1) {
            int currentIndex = 0;

            List<String> substrings = new ArrayList<>();
            while (nextWordIndex != -1) {
                substrings.add(result.substring(currentIndex, nextWordIndex));
                currentIndex = nextWordIndex + keyWord.length();
                nextWordIndex = result.indexOf(keyWord, currentIndex + 1);
            }
            substrings.add(result.substring(currentIndex));
            result = String.join("", substrings);
            nextWordIndex = result.indexOf(keyWord, 0);
        }

        System.out.println(result);
    }
}
