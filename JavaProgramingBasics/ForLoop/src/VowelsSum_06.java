import java.util.Scanner;

public class VowelsSum_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int value = 0;
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);

            switch (letter) {
                case 'a':
                    value = 1;
                    break;
                case 'e':
                    value = 2;
                    break;
                case 'i':
                    value = 3;
                    break;
                case 'o':
                    value = 4;
                    break;
                case 'u':
                    value = 5;
                    break;
            }
            sum += value;
            value = 0;
        }
        System.out.println(sum);
    }
}
