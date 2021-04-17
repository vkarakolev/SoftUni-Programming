import java.util.Scanner;

public class E04_ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringArr = scanner.nextLine().split(" ");
        int[] intArr = new int[stringArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(stringArr[i]);
        }
        int rotations = scanner.nextInt();

        for (int i = 0; i < rotations; i++) {
            int oldFirstNum = intArr[0];
            for (int j = 0; j < intArr.length; j++) {
                if (j == intArr.length - 1) {
                    intArr[j] = oldFirstNum;
                } else {
                    intArr[j] = intArr[j + 1];
                }
            }
        }
        for (int number : intArr) {
            System.out.print(number + " ");
        }

    }
}
