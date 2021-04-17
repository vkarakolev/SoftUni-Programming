import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class E02_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameRegex = "[A-Za-z]";
        Pattern namePattern = Pattern.compile(nameRegex);
        String distRegex = "\\d";
        Pattern distPattern = Pattern.compile(distRegex);

        List<String> participants = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        Map<String, Integer> racers = new LinkedHashMap<>();
        for (String participant : participants) {
            racers.put(participant, 0);
        }

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("end of race")) {
            Matcher nameMatcher = namePattern.matcher(inputLine);
            StringBuilder name = new StringBuilder();

            while (nameMatcher.find()) {
                name.append(nameMatcher.group());
            }

            if (racers.containsKey(name.toString())) {
                int currentDist = racers.get(name.toString());
                Matcher distMatcher = distPattern.matcher(inputLine);
                while(distMatcher.find()){
                    currentDist += Integer.parseInt(distMatcher.group());
                }
                racers.put(name.toString(), currentDist);
            }

            inputLine = scanner.nextLine();
        }

        List<String> winners = racers.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - (e1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int count = 1;
        for (String winner : winners) {
            switch(count++){
                case 1:
                    System.out.println("1st place: " + winner);
                    break;
                case 2:
                    System.out.println("2nd place: " + winner);
                    break;
                case 3:
                    System.out.println("3rd place: " + winner);
                    break;
            }
        }

    }

   /* static int kmSum(String s) {
        int sum = 0;
        String[] nums = s.split("[^\\d]+");
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }*/
}
