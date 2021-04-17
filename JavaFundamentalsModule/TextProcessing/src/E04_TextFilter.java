import java.util.Scanner;

public class E04_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            text = text.replace(bannedWord, repeatString("*", bannedWord.length()));
        }

        System.out.println(text);
    }

    static String repeatString (String word, int count){
        String[] words = new String[count];
        for (int i = 0; i < count; i++) {
            words[i] = word;
        }

        return (String.join("", words));
    }
}
