import java.util.Scanner;

public class NumbersNTo1_02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        for(int i = n; i >= 1; i--){
            System.out.println(i);
        }
    }
}
