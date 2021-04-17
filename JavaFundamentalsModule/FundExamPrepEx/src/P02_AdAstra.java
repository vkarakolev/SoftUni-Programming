import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_AdAstra {
    public static void main(String[] args) {
        String text = new Scanner(System.in).nextLine();

        String regex = "([|#])(?<name>[A-Za-z ]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<cal>(\\d{1,4})|(10000))\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int totalCalories = 0;
        while(matcher.find()){
            totalCalories += Integer.parseInt(matcher.group("cal"));
        }

        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);

        matcher = pattern.matcher(text);
        while(matcher.find()){
            String item = matcher.group("name");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("cal"));
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n", item, date, calories);
        }

    }
}
