import java.util.ArrayDeque;
import java.util.Scanner;

public class E05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque();

        String command = scanner.nextLine();
        while (!command.equals("print")){
            if(command.equals("cancel")){
                if(queue.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.poll());
                }
            } else {
                queue.offer(command);
            }

            command = scanner.nextLine();
        }

        for (Object q : queue) {
            System.out.println(q);
        }
    }
}
