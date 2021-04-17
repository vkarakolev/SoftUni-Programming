import java.util.Scanner;

public class SumOfOddNumbers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numsToPrint = scanner.nextInt();
        int count = 0;
        int sum = 0;

        for (int i = 1; i < 101; i++) {
            if(i % 2 != 0){
                System.out.println(i);
                count++;
                sum += i;
            }
            if(count >= numsToPrint){
                break;
            }
        }
        System.out.println("Sum: " + sum);
    }
}
