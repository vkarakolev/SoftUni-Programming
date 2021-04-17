import java.util.Scanner;

public class E06_MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        printMiddleCharsOfString(input);
    }

    static void printMiddleCharsOfString(String input){
        if (input.length() % 2 == 0){
            for (int i = 0; i < input.length(); i++) {
                if(i == input.length() / 2 - 1 || i == input.length() / 2){
                    System.out.print(input.charAt(i));
                }
            }
        } else {
            for (int i = 0; i < input.length(); i++) {
                if (i == input.length() / 2){
                    System.out.println(input.charAt(i));
                    break;
                }
            }
        }
    }
}
