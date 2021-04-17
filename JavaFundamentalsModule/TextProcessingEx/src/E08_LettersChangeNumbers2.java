import java.util.Scanner;

public class E08_LettersChangeNumbers2 {
    public static void main(String[] args) {
        String[] input = new Scanner(System.in).nextLine().split("\\s+");
        double sum = 0;

        for (String s : input) {
            char first = s.charAt(0);
            int number = Integer.parseInt(s.substring(1, s.length() - 1));
            char second = s.charAt((s.length() - 1));

            sum += convertingNumbers(first, number, second);
        }

        System.out.printf("%.2f", sum);
    }

    static double convertingNumbers(char first, int number, char second){
        double sum = 0;
        int position;

        if(first >= 65 && first <= 90 && number != 0){
            position = first - 64;
            sum += 1.0 * number / position;
        } else {
            position = first - 96;
            sum += number * position;
        }

        if(second >= 65 && second <= 90){
            position = second - 64;
            sum -= position;
        } else {
            position = second - 96;
            sum += position;
        }

        return sum;
    }
}
