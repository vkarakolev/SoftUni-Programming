import java.util.ArrayDeque;
import java.util.Scanner;

public class E01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> historyStack = new ArrayDeque<>();

        String command = scanner.nextLine();
        while(!command.equals("Home")){
            if(command.equals("back")){
                if(historyStack.size() <= 1){
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                } else {
                    historyStack.pop();
                }
            } else {
                historyStack.push(command);
            }

            String currentURL = historyStack.peek();
            System.out.println(currentURL);

            command = scanner.nextLine();
        }
    }
}
