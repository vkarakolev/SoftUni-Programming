import java.util.ArrayDeque;
import java.util.Scanner;

public class E02_SimpleCalculator {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] inputLine = new Scanner(System.in).nextLine().split("\\s+");

        for (int i = inputLine.length - 1; i >= 0; i--) {
            stack.push(inputLine[i]);
        }

        while (stack.size() > 1){
            int leftOperand = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int rightOperand = Integer.parseInt(stack.pop());

            int result = operator.equals("+")
                    ? leftOperand + rightOperand
                    : leftOperand - rightOperand;

            stack.push(String.valueOf(result));
        }

        System.out.println(stack.pop());
    }
}
