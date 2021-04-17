import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E04_WordFilter {
    public static void main(String[] args) {

        List<String> words = Arrays.stream(new Scanner(System.in).nextLine().split(" ")).
                filter(s -> s.length() % 2 == 0).
                collect(Collectors.toList());

        System.out.println(String.join(System.lineSeparator(), words));
    }
}
