import java.util.Scanner;

public class E04_TribonacciSequence {
    public static void main(String[] args) {
        int num = new Scanner(System.in).nextInt();
        int first = 0;
        int second = 0;
        int third = 0;
        int newNum;

        for (int i = 0; i < num; i++) {
            if(i == 0){
                System.out.print(1 + " ");
                first = 1;
                continue;
            }

            newNum = first + second + third;

            third = second;
            second = first;
            first = newNum;

            System.out.print(newNum + " ");
        }
    }
}
