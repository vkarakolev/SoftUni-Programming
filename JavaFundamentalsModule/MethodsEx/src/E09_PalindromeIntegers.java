import java.util.Scanner;

public class E09_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while (!command.equals("END")){
            System.out.println(checkForPalindrome(command));
            command = scanner.nextLine();
        }
    }

    static boolean checkForPalindrome(String input){
        String[] inputArray = input.split("");
        boolean isPalindrome = true;
        int mirrorIndex = inputArray.length - 1;

        for (int i = 0; i < inputArray.length / 2; i++) {
            if(!inputArray[i].equals(inputArray[mirrorIndex])){
                isPalindrome = false;
                break;
            }
            mirrorIndex--;
        }
        return isPalindrome;
    }
}
