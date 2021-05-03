import java.util.Scanner;

public class E03_RecursiveFibonacci {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(getFibonacci(n));
    }

    static long getFibonacci (int n) {
        if(n == 2){
            return 1;
        } else if (n == 1){
            return 1;
        }

        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }
}
