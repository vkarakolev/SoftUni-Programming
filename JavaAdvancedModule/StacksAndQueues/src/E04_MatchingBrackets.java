import java.lang.invoke.SwitchPoint;
import java.util.ArrayDeque;
import java.util.Scanner;

public class E04_MatchingBrackets {
    public static void main(String[] args) {
        String inputLine = new Scanner(System.in).nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque();

        for (int i = 0; i < inputLine.length(); i++) {
            switch (inputLine.charAt(i)){
                case '(':
                    stack.push(i);
                    break;
                case ')':
                    int startIndex = stack.pop();
                    System.out.println(inputLine.substring(startIndex, i + 1));
                    break;
            }
        }
    }
}
