import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class E03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int command = scanner.nextInt();
            switch (command){
                case 1 :
                    int number = scanner.nextInt();
                    stack.push(number);
                    break;
                case 2 :
                    stack.pop();
                    break;
                case 3 :
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}