import java.util.ArrayDeque;
import java.util.Scanner;

public class E08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> historyStack = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!command.equals("Home")) {
            String currentURL;

            switch (command) {
                case "back":
                    if (historyStack.size() <= 1) {
                        System.out.println("no previous URLs");
                        command = scanner.nextLine();
                        continue;
                    } else {
                        forwardStack.push(historyStack.pop());
                        currentURL = historyStack.peek();
                    }
                    break;
                case "forward":
                    if (forwardStack.size() < 1) {
                        System.out.println("no next URLs");
                        command = scanner.nextLine();
                        continue;
                    } else {
                        historyStack.push(forwardStack.peek());
                        currentURL = forwardStack.pop();
                    }
                    break;
                default:
                    historyStack.push(command);
                    currentURL = historyStack.peek();
                    forwardStack.clear();
                    break;
            }

            System.out.println(currentURL);

            command = scanner.nextLine();
        }
    }
}