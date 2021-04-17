import java.util.Scanner;

public class E08_LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char character = scanner.nextLine().charAt(0);

        if(65 <= character && character <= 90){
            System.out.println("upper-case");
        } else if (97 <= character && character <= 122){
            System.out.println("lower-case");
        }
    }
}
