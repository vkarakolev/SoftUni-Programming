import java.util.Arrays;
import java.util.Scanner;

public class E03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndCols = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readSquareMatrix(rowsAndCols, scanner, "\\s+");

        int firstSum = calculateFirstDiagonalSum(matrix);
        int secondSum = calculateSecondDiagonalSum(matrix);

        System.out.println(Math.abs(firstSum - secondSum));
    }

    public static int calculateSecondDiagonalSum(int[][] matrix) {
        int sum = 0;
        int col = 0;

        for (int row = matrix.length - 1; row >= 0; row--) {
            sum += matrix[row][col];
            col++;
        }

        return sum;
    }

    public static int calculateFirstDiagonalSum(int[][] matrix) {
        int sum = 0;

        for (int rowAndCol = 0; rowAndCol < matrix.length; rowAndCol++) {
            sum += matrix[rowAndCol][rowAndCol];
        }

        return sum;
    }

    public static int[] readArray (String line, String regex){
        return Arrays.stream(line.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[][] readSquareMatrix(int rowsAndCols, Scanner scanner, String regex){
        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        for (int row = 0; row < rowsAndCols; row++) {
            matrix[row] = readArray(scanner.nextLine(), regex);
        }

        return matrix;
    }
}
