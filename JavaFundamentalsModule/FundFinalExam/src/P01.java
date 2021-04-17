import java.util.Arrays;
import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String letters = scanner.nextLine();

        boolean endTurn = false;
        while(!endTurn){
            String[] commands = scanner.nextLine().split(" ");

            if (commands[0].equals("Move")) {
                int moveIndex = Integer.parseInt(commands[1]);
                if (moveIndex < 0 || moveIndex > 6) {
                    continue;
                }

                char movedChar = letters.charAt(moveIndex);
                letters = letters.substring(0, moveIndex) + letters.substring(moveIndex + 1) + movedChar;
            } else if (commands[0].equals("Insert") && commands[1].equals("Space")) {
                int insertIndex = Integer.parseInt(commands[2]);
                char space = ' ';

                letters = letters.substring(0, insertIndex) + space + letters.substring(insertIndex);
            } else if (commands[0].equals("Reverse")) {
                String subStr = commands[1];
                if (letters.contains(subStr)) {
                    StringBuilder reversed = new StringBuilder();
                    reversed.append(subStr);
                    reversed.reverse();
                    reversed.insert(0, letters.substring(0, letters.indexOf(subStr)) + letters.substring(letters.indexOf(subStr) + subStr.length()));
                    letters = String.valueOf(reversed);
                }
            } else if (commands[0].equals("Exchange") && commands[1].equals("Tiles")) {
                String newLetters = commands[2];
                letters = newLetters + letters.substring(newLetters.length());

                System.out.println(separateBySpace(letters));
                endTurn = true;
            } else if (commands.length == 1 && (commands[0]).equals("Pass")) {
                System.out.println(separateBySpace(letters));
                endTurn = true;
            } else if (commands.length == 1 && commands[0].equals("Play")) {
                if (letters.contains(" ")) {
                    letters = letters.substring(0, letters.indexOf(" "));
                }

                System.out.printf("You are playing with the word %s.", letters);
                endTurn = true;
            }
        }
    }

    static String separateBySpace (String text){
        String[] elements = text.split("");
        return (String.join(" ", elements));
    }
}
