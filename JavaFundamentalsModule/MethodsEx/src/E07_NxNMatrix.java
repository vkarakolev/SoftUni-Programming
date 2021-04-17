import java.util.Scanner;

public class E07_NxNMatrix {
    public static void main(String[] args) {
        int inputNum =new Scanner(System.in).nextInt();
        printMatrixOfNumbers(inputNum);
    }

    static void printMatrixOfNumbers(int num){
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
