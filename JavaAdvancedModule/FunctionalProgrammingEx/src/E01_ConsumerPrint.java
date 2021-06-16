import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class E01_ConsumerPrint {
    public static void main(String[] args) {
        String[] names = new Scanner(System.in).nextLine().split("\\s+");

        Consumer<String> printer = System.out::println;

        Arrays.stream(names)
                .forEach(printer);
    }
}
