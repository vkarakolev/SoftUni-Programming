import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class E02_KnightsOfHonor {
    public static void main(String[] args) {
        String[] names = new Scanner(System.in).nextLine().split("\\s+");

        Consumer<String> printer = s -> System.out.println("Sir " + s);

        Arrays.stream(names)
                .forEach(printer);
    }
}
