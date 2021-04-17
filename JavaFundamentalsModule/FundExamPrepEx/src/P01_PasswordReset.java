import java.util.Scanner;

public class P01_PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Done")){
            String[] commands = commandLine.split(" ");

            switch (commands[0]){
                case "TakeOdd":
                       inputLine = takeOdd(inputLine);
                    System.out.println(inputLine);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commands[1]);
                    int length = Integer.parseInt(commands[2]);

                    inputLine = inputLine.substring(0, index) + inputLine.substring(index + length);
                    System.out.println(inputLine);
                    break;
                case "Substitute":
                    String substring = commands[1];
                    String substitute = commands[2];

                    if(inputLine.contains(substring)) {
                        inputLine = substitute(inputLine, substring, substitute);
                        System.out.println(inputLine);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }


            commandLine = scanner.nextLine();
        }

        System.out.println("Your password is: " + inputLine);
    }

    static String takeOdd (String text) {
        StringBuilder oddCharsPass = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if(i % 2 != 0){
                oddCharsPass.append(text.charAt(i));
            }
        }
        return (String.valueOf(oddCharsPass));
    }

    static String substitute (String text, String oldStr, String newStr){
        return (text.replace(oldStr, newStr));
    }
}
