import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E06_ExtractEmails {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        String regex = "\\ (?<email>(?<user>[A-Za-z0-9]+[\\w+\\.-]*[A-Za-z0-9])@(?<host>[a-z]+\\-*[a-z]+\\.[a-z]+(\\.[a-z]+)*))\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while(matcher.find()){
            System.out.println(matcher.group("email"));
        }
    }
}
