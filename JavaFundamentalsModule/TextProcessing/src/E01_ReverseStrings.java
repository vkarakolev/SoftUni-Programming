import java.util.Scanner;

public class E01_ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while(!input.equals("end")){
            StringBuilder reversed = new StringBuilder();

            for (int i = input.length() - 1; i >= 0; i--) {
                reversed.append(input.charAt(i));
            }

            System.out.println(input + " = " + reversed);

            input = scanner.nextLine();
        }
    }
}
