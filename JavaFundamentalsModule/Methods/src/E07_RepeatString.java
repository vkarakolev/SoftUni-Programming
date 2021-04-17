import java.util.Scanner;

public class E07_RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int repetitions = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatString(input, repetitions));
    }

    static String repeatString(String input, int repetitions){
        String[] repeatedString = new String[repetitions];
        for (int i = 0; i < repeatedString.length; i++) {
            repeatedString[i] = input;
        }
        return (String.join("",repeatedString));
    }
}
