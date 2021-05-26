import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class E01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] numbers = new Scanner(System.in).nextLine().split(" ");

        for (String n : numbers) {
            stack.push(n);
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
