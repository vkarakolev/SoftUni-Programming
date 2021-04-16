import java.util.Scanner;

public class StreamOfCharacters_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        int length = word.length();

        for(int i = 0; i < length; i++){
            System.out.println(word.charAt(i));
        }
    }
}
