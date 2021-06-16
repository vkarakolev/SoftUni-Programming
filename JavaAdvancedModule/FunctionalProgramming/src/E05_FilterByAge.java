import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class E05_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            people.put(name, age);
        }


        String ageCriteria = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        people.entrySet()
                .stream()
                .filter(getAgeFilter(ageCriteria, age))
                .forEach(getFormatter(format));
    }

    private static Consumer<Map.Entry<String, Integer>> getFormatter(String format) {
        if(format.equals("name")){
           return e -> System.out.println(e.getKey());
        } else if (format.equals("age")){
            return e -> System.out.println(e.getValue());
        }
        return e -> System.out.println(e.getKey() + " - " + e.getValue());
    }

    private static Predicate<Map.Entry<String, Integer>> getAgeFilter(String criteria, int age) {
        if(criteria.equals("older")){
            return e -> e.getValue() >= age;
        }
        return e -> e.getValue() <= age;
    }
}
