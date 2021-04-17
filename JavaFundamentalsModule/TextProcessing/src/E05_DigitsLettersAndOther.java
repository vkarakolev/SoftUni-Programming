import java.util.*;

public class E05_DigitsLettersAndOther {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        StringBuilder digits = null;
        StringBuilder letters = null;
        StringBuilder chars = null;


        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                if (digits == null) {
                    digits = new StringBuilder();
                }
                digits.append(input.charAt(i));
            } else if (Character.isLetter(input.charAt(i))){
                if (letters == null){
                    letters = new StringBuilder();
                }
                letters.append(input.charAt(i));
            } else {
                if (chars == null){
                    chars = new StringBuilder();
                }
                chars.append(input.charAt(i));
            }
        }

        System.out.printf("%s%n%s%n%s%n", digits, letters, chars);
    }
}
