import java.util.ArrayDeque;
import java.util.Scanner;

public class E07_FibonacciWithQueue {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(getFib(n));
    }

    public static long getFib(int n){
        ArrayDeque<Long> fibonacciSequence = new ArrayDeque<>();
        int counter = 0;
        while(counter <= n){
            long firstNum;
            long secondNUm;
            long currentNum;

            if(counter == 0){
                fibonacciSequence.offer((long) 1);
                counter++;
                firstNum = 0;
                secondNUm = 1;
                currentNum = firstNum + secondNUm;
                fibonacciSequence.offer(currentNum);
                counter++;
            }

            firstNum = fibonacciSequence.poll();
            secondNUm = fibonacciSequence.poll();
            currentNum = firstNum + secondNUm;

            fibonacciSequence.offer(secondNUm);
            fibonacciSequence.offer(currentNum);
            counter++;
        }
        fibonacciSequence.poll();
        return fibonacciSequence.poll();
    }
}
