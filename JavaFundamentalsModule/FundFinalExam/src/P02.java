import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02 {
    public static void main(String[] args) {
        String text = new Scanner(System.in).nextLine();

        String regex = "[@#]+(?<color>[a-z]{3,})[@#]+[\\W_]*/+(?<amount>\\d+)/+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            int amount = Integer.parseInt(matcher.group("amount"));
            String color = matcher.group("color");
            System.out.printf("You found %d %s eggs!%n", amount, color);
        }
    }
}
