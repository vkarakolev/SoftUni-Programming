import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E02_MatchPhoneNumber {
    public static void main(String[] args) {
        String numbers = new Scanner(System.in).nextLine();
        String regEx = "\\+359([- ])2\\1\\d{3}\\1\\d{4}\\b";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(numbers);

        List<String> matchedPhones = new ArrayList<>();
        while (matcher.find()){
            matchedPhones.add(matcher.group());
        }

        System.out.println(String.join(", ", matchedPhones));
    }
}
