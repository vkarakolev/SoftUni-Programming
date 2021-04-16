import java.util.Scanner;

public class BiggerNumber_02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = Integer.parseInt(input.nextLine());
        int num2 = Integer.parseInt(input.nextLine());
        if(num1 > num2){
            System.out.println(num1);
        }else{
            System.out.println(num2);
        }
    }
}
