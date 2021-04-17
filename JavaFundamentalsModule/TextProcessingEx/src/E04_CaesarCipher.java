import java.util.Scanner;

public class E04_CaesarCipher {
    public static void main(String[] args) {
        String text = new Scanner(System.in).nextLine();
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            encryptedText.append((char)(text.charAt(i) + 3));
        }

        System.out.println(encryptedText);
    }
}
