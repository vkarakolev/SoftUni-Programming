import java.util.Scanner;

public class Nums1ToNStep3_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        for(int i = 1; i <= n; i += 3){
            System.out.println(i);
        }
    }
}
