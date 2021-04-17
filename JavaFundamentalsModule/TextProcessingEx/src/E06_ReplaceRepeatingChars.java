import java.util.Scanner;

public class E06_ReplaceRepeatingChars {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if(i == input.length() - 1){
                result.append(input.charAt(i));
                break;
            }
            if(input.charAt(i) == input.charAt(i + 1)){
                continue;
            }
            result.append(input.charAt(i));
        }

        System.out.println(result);
    }
}
