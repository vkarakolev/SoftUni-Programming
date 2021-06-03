import java.util.Arrays;
import java.util.Scanner;

public class E04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = readArray(scanner.nextLine(), "\\s+");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = readMatrix(rows, cols, scanner, "\\s+");

        int[][] bestSumMatrix = getBiggestSumMatrix3x3(matrix);
        System.out.println("Sum = " + getElementsSum(bestSumMatrix));
        printMatrix(bestSumMatrix);

    }

    public static Object getElementsSum(int[][] matrix) {
        int sum = 0;

        for (int[] row : matrix) {
            for (int col : row) {
                sum += col;
            }
        }

        return sum;
    }

    public static int[][] getBiggestSumMatrix3x3(int[][] matrix) {
        int bestSum = 0;
        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if(currentSum > bestSum){
                    bestSum = currentSum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        return new int[][] {
                {matrix[bestRow][bestCol] , matrix[bestRow][bestCol + 1] , matrix[bestRow][bestCol + 2]},
                {matrix[bestRow + 1][bestCol] , matrix[bestRow + 1][bestCol + 1] , matrix[bestRow + 1][bestCol + 2]},
                {matrix[bestRow + 2][bestCol] , matrix[bestRow + 2][bestCol + 1] , matrix[bestRow + 2][bestCol + 2]}
        };
    }

    public static void printMatrix (int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static int[] readArray (String line, String regex){
        return Arrays.stream(line.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String regex){
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine(), regex);
        }

        return matrix;
    }
}
