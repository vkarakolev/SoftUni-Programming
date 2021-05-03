import java.util.Scanner;

public class E02_PascalTriangle {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        long[] currentArray = new long[n];
        long[] newArray = new long[n];

        for (int i = 0; i < n; i++) {
            if(i == 0) {
                newArray[0] = 1;
                System.arraycopy(newArray, 0, currentArray, 0, newArray.length);
            } else {
                for (int j = 0; j <= i; j++) {
                    long currentElement = 0;
                    long previousElement = 0;

                    if(j != 0) {
                        previousElement = currentArray[j - 1];
                    }
                    if(j != i) {
                        currentElement = currentArray[j];
                    }
                    newArray[j] = currentElement + previousElement;
                }
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(newArray[j] + " ");
            }
            System.out.println();

            System.arraycopy(newArray, 0, currentArray, 0, currentArray.length);
        }
    }
}
