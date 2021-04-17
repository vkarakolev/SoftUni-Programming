import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E05_Largest3Numbers {
    public static void main(String[] args) {

        Arrays.stream (new Scanner(System.in).nextLine().split(" "))
                .map(n -> Integer.parseInt(n))
                .sorted((a, b) -> Integer.compare(b, a))
                .limit(3)
                .forEach(i -> System.out.print(i + " "));

    }
}
