import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01_OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int taskToKill = Integer.parseInt(scanner.nextLine());
        boolean isKilled = false;
        int killer = 0;

        while (!isKilled) {
            int task = tasks.peek();
            int thread = threads.poll();

            if (task == taskToKill) {
                killer = thread;
                isKilled = true;
            } else if(thread >= task) {
                tasks.pop();
            }
        }

        System.out.printf("Thread with value %s killed task %s%n", killer, taskToKill);

        System.out.println(killer + " " + threads.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
}
