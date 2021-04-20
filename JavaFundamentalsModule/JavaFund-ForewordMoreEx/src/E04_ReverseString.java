import java.util.Scanner;

public class E04_ReverseString {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        String output = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            output += input.charAt(i);
        }

        System.out.println(output);
    }
}
