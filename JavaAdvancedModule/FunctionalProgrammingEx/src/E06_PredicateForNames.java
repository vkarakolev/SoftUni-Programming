import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class E06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> isValid = (x -> x.length() <= n);

        Arrays.stream(names)
                .filter(isValid)
                .forEach(System.out::println);
    }
}
