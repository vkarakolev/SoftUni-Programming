import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_EmojiDetector {
    public static void main(String[] args) {
        String text = new Scanner(System.in).nextLine();
        int coolThreshold = 1;

        String digitRegex = "\\d";
        Pattern digitPattern = Pattern.compile(digitRegex);
        Matcher matcher = digitPattern.matcher(text);

        while (matcher.find()){
            coolThreshold *= Integer.parseInt(matcher.group());
        }
        System.out.println("Cool threshold: " + coolThreshold);

        String emojiRegex = "(:{2}|\\*{2})(?<letters>[A-Z][a-z]{2,})\\1";
        Pattern emojiPattern = Pattern.compile(emojiRegex);
        matcher = emojiPattern.matcher(text);
        int emojiCounter = 0;
        List<String> coolEmojis = new ArrayList<>();

        while (matcher.find()){
            emojiCounter++;
            int coolness = 0;
            String emojiLetters = matcher.group("letters");

            for (int i = 0; i < emojiLetters.length(); i++) {
                coolness += emojiLetters.charAt(i);
            }

            if(coolness > coolThreshold){
                coolEmojis.add(matcher.group());
            }
        }

        System.out.println(emojiCounter + " emojis found in the text. The cool ones are:");
        if(coolEmojis != null) {
            for (String coolEmoji : coolEmojis) {
                System.out.println(coolEmoji);
            }
        }
    }
}
