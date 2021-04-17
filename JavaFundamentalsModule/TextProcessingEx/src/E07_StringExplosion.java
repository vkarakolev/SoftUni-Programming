import java.util.Scanner;

public class E07_StringExplosion {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(new Scanner(System.in).nextLine());
        int strength = 0;

        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '>'){
                strength += Character.getNumericValue(text.charAt(i + 1));
            } else if (strength > 0 && text.charAt(i) != '>') {
                text.deleteCharAt(i);
                strength--;
                i--;
            }
        }

        System.out.println(text);
    }
}
