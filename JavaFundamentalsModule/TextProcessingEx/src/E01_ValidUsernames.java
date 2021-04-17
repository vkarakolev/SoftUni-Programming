import java.util.Scanner;

public class E01_ValidUsernames {
    public static void main(String[] args) {

        String[] usernames = new Scanner(System.in).nextLine().split(", ");

        for (String username : usernames) {
            boolean isValid = validateUsername(username);
            if (isValid){
                System.out.println(username);
            }
        }

    }

    static boolean validateUsername (String username){
        if(username.length() < 3 || username.length() > 16){
            return false;
        }

        for (int i = 0; i < username.length(); i++) {
            char symbol = username.charAt(i);
            if (!Character.isLetterOrDigit(symbol) && symbol != 95 && symbol != 45){
                return false;
            }
        }

        return true;
    }
}
