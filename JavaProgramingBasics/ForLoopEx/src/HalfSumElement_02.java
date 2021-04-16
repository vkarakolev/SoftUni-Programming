import java.util.Scanner;

public class HalfSumElement_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for( int i = 1; i <= count; i++){
            int num = Integer.parseInt(scanner.nextLine());
            sum += num;
            if(num > max){
                max = num;
            }
        }
        int sumWithoutMax = sum - max;

        if(sumWithoutMax == max){
            System.out.println("Yes");
            System.out.printf("Sum = %d", max);
        } else {
            int diff = Math.abs(max - sumWithoutMax);
            System.out.println("No");
            System.out.printf("Diff = %d", diff);
        }

    }
}
