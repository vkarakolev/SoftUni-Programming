import java.util.Scanner;

public class E01_SignOfIntegerNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.printf("The number %d is %s.", num, signCheck(num));
        }

    static String signCheck( int number){
        String sign;
        if(number < 0){
            sign = "negative";
        } else if (number > 0){
            sign = "positive";
        } else {
            sign = "zero";
        }

        return(sign);
    }
}
