import java.util.Arrays;
import java.util.Scanner;

public class E05_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = readArray(scanner.nextLine(), ", ");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = readMatrix(rows, cols, scanner, ", ");

        int[][] biggestSubMatrix = getMaxSumSubMatrix2x2(matrix);
        printMatrix(biggestSubMatrix);
        System.out.println(getElementsSum(biggestSubMatrix));
    }

    public static int getElementsSum(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int col : row) {
                sum += col;
            }
        }

        return sum;
    }

    public static void printMatrix(int[][] matrix) {
        for (int [] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static int[][] getMaxSumSubMatrix2x2 (int[][] matrix){
        int maxSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];

                if(currentSum > maxSum){
                    maxSum = currentSum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        return new int[][] {
                {matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1]},
                {matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1]}
        };
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String regex) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine(), regex);
        }

        return matrix;
    }

    private static int[] readArray(String line, String regex) {
        return Arrays.stream(line.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
