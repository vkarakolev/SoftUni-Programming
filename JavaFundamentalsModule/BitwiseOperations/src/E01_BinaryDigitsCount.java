import java.util.Scanner;

public class E01_BinaryDigitsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        int b = scanner.nextInt();
        int count = 0;

        while(inputNum != 0){
            int bit = inputNum % 2;

            if(bit == b){
                count++;
            }

            inputNum /= 2;
        }

        System.out.println(count);
    }
}
