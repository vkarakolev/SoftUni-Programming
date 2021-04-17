import java.util.Scanner;

public class E03_Substrings2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String text = scanner.nextLine();

        while(text.contains(word)){
            text = text.replace(word, "");
        }

        System.out.println(text);
    }
}
