import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E01_MatchFullName {
    public static void main(String[] args) {
        String text = new Scanner(System.in).nextLine();
        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            System.out.print(matcher.group() + " ");
        }
    }
}
