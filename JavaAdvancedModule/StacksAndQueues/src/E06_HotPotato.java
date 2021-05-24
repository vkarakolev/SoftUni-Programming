import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class E06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> kidsQueue = new ArrayDeque<>();
        Collections.addAll(kidsQueue, names);

        while (kidsQueue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String currentKid = kidsQueue.poll();
                kidsQueue.offer(currentKid);
            }

            String kid = kidsQueue.poll();
            System.out.println("Removed " + kid);
        }

        String lastKid = kidsQueue.poll();
        System.out.println("Last is " + lastKid);
    }
}
