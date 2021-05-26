import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class E07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> kidsQueue = new ArrayDeque<>();
        Collections.addAll(kidsQueue, names);

        int cycle = 1;
        while (kidsQueue.size() > 1) {

            for (int i = 1; i < n; i++) {
                String currentKid = kidsQueue.poll();
                kidsQueue.offer(currentKid);
            }

            String kid = kidsQueue.peek();
            if(isPrime(cycle)){
                System.out.println("Prime " + kid);
            } else {
                System.out.println("Removed " + kidsQueue.poll());
            }

            cycle++;
        }

        String lastKid = kidsQueue.poll();
        System.out.println("Last is " + lastKid);
    }

    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}