import java.util.Scanner;

public class P01_TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encrypted = scanner.nextLine();

        String command = scanner.nextLine();
        while (!command.equals("Decode")){
            String[] instructions = command.split("\\|");

            switch (instructions[0]){
                case "Move":
                    int lettersCount = Integer.parseInt(instructions[1]);
                    encrypted = encrypted.substring(lettersCount) + encrypted.substring(0, lettersCount);
                    break;
                case "Insert":
                    int indexAfter = Integer.parseInt(instructions[1]);
                    String value = instructions[2];
                    StringBuilder sb = new StringBuilder();
                    sb.append(encrypted);
                    sb.insert(indexAfter, value);

                    encrypted = String.valueOf(sb);
                    break;
                case "ChangeAll":
                    String oldStr = instructions[1];
                    String newStr = instructions[2];

                    encrypted = encrypted.replace(oldStr, newStr);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("The decrypted message is: " + encrypted);
    }
}
