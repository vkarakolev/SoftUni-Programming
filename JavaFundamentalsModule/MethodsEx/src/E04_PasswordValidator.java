import java.util.Scanner;

public class E04_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean[] isValid = {checkPasswordLength(input), checkForForbiddenChars(input), checkForMinTwoDigits(input)};
        int validChecksCount = 0;

        for (int i = 0; i < isValid.length; i++) {
            if(isValid[i]){
                validChecksCount++;
            }
        }

        if (validChecksCount == 3) {
            System.out.println("Password is valid");
        }
    }

    static boolean checkPasswordLength(String input) {
        boolean isValid = true;
        if (input.length() < 6 || input.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            isValid = false;
        }
        return isValid;
    }

    static boolean checkForForbiddenChars(String input) {
        boolean isValid = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 48 || input.charAt(i) > 57
                    && input.charAt(i) < 65 || input.charAt(i) > 90
                    && input.charAt(i) < 97 || input.charAt(i) > 122) {
                isValid = false;
                break;
            }
        }
        if (isValid == false) {
            System.out.println("Password must consist only of letters and digits");
        }
        return isValid;
    }

    static boolean checkForMinTwoDigits(String input) {
        boolean isValid = true;
        int digitCounter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (47 < input.charAt(i) && input.charAt(i) < 57) {
                digitCounter++;
            }
        }

        if (digitCounter < 2) {
            isValid = false;
            System.out.println("Password must have at least 2 digits");
        }

        return isValid;
    }
}
