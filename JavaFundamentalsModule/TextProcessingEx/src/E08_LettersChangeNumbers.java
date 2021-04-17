import java.math.BigDecimal;
import java.util.Scanner;

public class E08_LettersChangeNumbers {
    public static void main(String[] args) {
        String[] input = new Scanner(System.in).nextLine().split("\\s+");
        BigDecimal sum = new BigDecimal(0);

        for (String s : input) {
            char first = s.charAt(0);
            int number = Integer.parseInt(s.substring(1, s.length() - 1));
            char second = s.charAt((s.length() - 1));

            sum = sum.add(convertingNumbers(first, number, second));
        }

        System.out.printf("%.2f", sum);
    }

    static BigDecimal convertingNumbers(char first, int number, char second){
        BigDecimal sum = new BigDecimal(0);
        int position;

        if(first >= 65 && first <= 90 && number != 0){
            position = first - 64;
            sum = sum.add(BigDecimal.valueOf(1.0 * number / position));
        } else {
            position = first - 96;
            sum = sum.add(BigDecimal.valueOf(number * position));
        }

        if(second >= 65 && second <= 90){
            position = second - 64;
            sum = sum.subtract(BigDecimal.valueOf(position));
        } else {
            position = second - 96;
            sum = sum.add(BigDecimal.valueOf(position));
        }

        return sum;
    }
}
