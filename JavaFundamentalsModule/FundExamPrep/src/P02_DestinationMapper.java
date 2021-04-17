import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> validLocations = new ArrayList<>();
        int travelPoints = 0;

        String regex = "([=/])(?<place>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while(matcher.find()){
            validLocations.add(matcher.group("place"));
            travelPoints += matcher.group("place").length();
        }

        System.out.println("Destinations: " + String.join(", ", validLocations));
        System.out.println("Travel Points: " + travelPoints);
    }
}
