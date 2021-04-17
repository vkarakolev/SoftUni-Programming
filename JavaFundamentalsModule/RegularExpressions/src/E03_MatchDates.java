import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E03_MatchDates {
    public static void main(String[] args) {
        String dates = new Scanner(System.in).nextLine();
        String regEx = "(?<day>\\d{2})([./-])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(dates);

        while (matcher.find()){
            System.out.printf("Day: %s, Month: %s, Year: %s%n",
                    matcher.group("day"), matcher.group("month"), matcher.group("year"));
        }
    }
}
