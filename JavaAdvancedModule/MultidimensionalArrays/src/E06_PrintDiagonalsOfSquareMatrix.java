import java.util.Arrays;
import java.util.Scanner;

public class E06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(n, scanner, "\\s+");

        printArray(getFirstDiagonal(matrix));
        printArray(getSecondDiagonal(matrix));
    }

    public static void  printArray(int[] arr){
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static int[] getSecondDiagonal(int[][] matrix){
        int[] secondDiagonal = new int[matrix.length];

        int col = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            secondDiagonal[col] = matrix[row][col];
            col++;
        }

        return secondDiagonal;
    }

    public static int[] getFirstDiagonal(int[][] matrix) {
        int[] firstDiagonal = new int[matrix.length];

        for (int rowAndCol = 0; rowAndCol < matrix.length; rowAndCol++) {
            firstDiagonal[rowAndCol]  = matrix[rowAndCol][rowAndCol];
        }

        return firstDiagonal;
    }

    public static int[] readArray (String line, String regex){
        return Arrays.stream(line.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[][] readMatrix(int rowsAndCols, Scanner scanner, String regex) {
        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        for (int row = 0; row < rowsAndCols; row++) {
            matrix[row] = readArray(scanner.nextLine(), regex);
        }

        return matrix;
    }
}
