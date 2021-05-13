import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01_Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> numbers = Arrays.stream(input.split(" "))
                .collect(Collectors.toList());
        input = scanner.nextLine();

        StringBuilder result = new StringBuilder();
        StringBuilder text = new StringBuilder();
        text.append(input);

        for (String number : numbers) {
            int sum = 0;

            for (int j = 0; j < number.length(); j++) {
                sum += Integer.parseInt(String.valueOf(number.charAt(j)));
            }

            if (sum > text.length()) {
                sum -= text.length();
            }

            result.append(text.charAt(sum));
            text.deleteCharAt(sum);
        }

        System.out.println(result);
    }
}
