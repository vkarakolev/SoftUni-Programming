import java.util.ArrayDeque;
import java.util.Scanner;

public class E03_DecimalToBinary {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int decimal = Integer.parseInt(new Scanner(System.in).nextLine());

        while (decimal != 0){
            stack.push(decimal % 2);
            decimal /= 2;
        }

        if(stack.peek() == null){
            System.out.println(0);
        } else {
            for (Integer i : stack) {
                System.out.print(stack.pop());
            }
        }
    }
}
