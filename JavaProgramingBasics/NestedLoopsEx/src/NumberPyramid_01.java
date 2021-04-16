import java.util.Scanner;

public class NumberPyramid_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int count = 1;

        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= row; col++){
                if(count > n){
                    break;
                }
                System.out.printf("%d ", count);
                count++;
            }
            System.out.println();
        }
    }
}
