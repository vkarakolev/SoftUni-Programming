import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E04_StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String regex = "@(?<name>[A-Z][a-z]+)([^@!>:-]+)?:(?<population>\\d+)([^@!>:-]+)?!(?<type>[AD])!([^@!>:-]+)?->(?<soldiers>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String encryptedMassage = scanner.nextLine();
            String decryptedMassage = decryptingMassages(encryptedMassage);

            Matcher matcher = pattern.matcher(decryptedMassage);
            while (matcher.find()){
                switch(matcher.group("type")){
                    case "A":
                        attacked.add(matcher.group("name"));
                        break;
                    case "D":
                        destroyed.add(matcher.group("name"));
                        break;
                }
            }
        }

        Collections.sort(attacked);
        Collections.sort(destroyed);

        System.out.println("Attacked planets: " + attacked.size());
        for (String s : attacked) {
            System.out.println("-> " + s);
        }

        System.out.println("Destroyed planets: " + destroyed.size());
        for (String s : destroyed) {
            System.out.println("-> " + s);
        }
    }

    static String decryptingMassages(String input){
        int keyCount = 0;
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)){
                case 's':
                case 't':
                case 'a':
                case 'r':
                case 'S':
                case 'T':
                case 'A':
                case 'R':
                    keyCount++;
                    break;
            }
        }
        for (int i = 0; i < input.length(); i++) {
            char newChar =(char)(input.charAt(i) - keyCount);
            decrypted.append(newChar);
        }

        return (String.valueOf(decrypted));
    }
}
