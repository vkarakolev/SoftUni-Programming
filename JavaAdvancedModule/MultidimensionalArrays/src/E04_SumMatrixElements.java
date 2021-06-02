import java.util.Arrays;
import java.util.Scanner;

public class E04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = readArray(scanner.nextLine(), ", ");

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = readMatrix(rows, cols, scanner, ", ");

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sumOfMatrixElements(matrix));

    }

    public static int sumOfMatrixElements(int[][] matrix){
        int sum = 0;
        for (int[] row : matrix) {
            for (int col : row) {
                sum += col;
            }
        }

        return sum;
    }

    public static int[][] readMatrix (int rows, int cols, Scanner scanner, String regex){
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine(), regex);
        }

        return matrix;
    }

    public static int[] readArray (String line, String regex){
        return Arrays.stream(line.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
