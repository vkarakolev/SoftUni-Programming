import java.util.Scanner;

public class InvalidNumber_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = Integer.parseInt(input.nextLine());

        if((number < 100 || number > 200) && number !=0){
            System.out.println("invalid");
        }
    }
}
