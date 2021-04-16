import java.util.Scanner;

public class NumberSequence_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCount = Integer.parseInt(scanner.nextLine());
        int n = 0;
        int min = 0;
        int max = 0;

        for (int i = 0; i < numCount; i++) {
            n = Integer.parseInt(scanner.nextLine());
            if(i == 0){
                min = n;
                max = n;
            }else if (min >= n) {
                min = n;
            } else if (n >= max) {
                max = n;
            }
        }
        System.out.printf("Max number: %d%nMin number: %d", max, min);
    }
}
