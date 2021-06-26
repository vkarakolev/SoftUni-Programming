import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01_MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> second = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(second::push);

        int sum = 0;
        int claimed = 0;
        while (!first.isEmpty() && !second.isEmpty()) {
            int firstItem = first.peek();
            int secondItem = second.pop();
            sum = firstItem + secondItem;

            if (sum % 2 == 0) {
                claimed += sum;
                first.poll();
            } else {
                first.offer(secondItem);
            }
        }

        if(first.isEmpty()){
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        if (sum >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + claimed);
        } else {
            System.out.println("Poor prey... Value: " + claimed);
        }
    }
}
