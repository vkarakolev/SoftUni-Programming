import java.util.ArrayDeque;
import java.util.Scanner;

public class E06_BalancedParentheses {
    public static void main(String[] args) {
        String inputLine = new Scanner(System.in).nextLine();

        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        boolean areBalanced = false;
        for (int i = 0; i < inputLine.length(); i++) {
            char currentBracket = inputLine.charAt(i);
            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                openBrackets.push(currentBracket);
            } else if (currentBracket == ')' || currentBracket == '}' || currentBracket == ']') {
                if(openBrackets.isEmpty()){
                    areBalanced = false;
                    break;
                }

                char lastOpenBracket = openBrackets.pop();
                switch (lastOpenBracket) {
                    case '(':
                        areBalanced = currentBracket == ')';
                        break;
                    case '{':
                        areBalanced = currentBracket == '}';
                        break;
                    case '[' :
                        areBalanced = currentBracket == ']';
                        break;
                }

                if(!areBalanced){
                    break;
                }
            }
        }

        if(areBalanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
