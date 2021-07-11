package E05_JediGalaxy;

import input.Reader;
import output.ConsolePrinter;

import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        int[] dimensions = Reader.readIntArray("\\s+");
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = createIntMatrix(rows, cols);

        String[] command = Reader.readStringArray("\\s+");
        long sum = 0L;
        while (!String.join(" ", command).equals("Let the Force be with you")) {
            int[] jediPosition = parseStringArrayToInt(command);
            int[] evilPosition = Reader.readIntArray("\\s+");

            int evilRow = evilPosition[0];
            int evilCol = evilPosition[1];

            sum += getSumFromMovement(matrix, evilRow, evilCol, -1);

            int jediRow = jediPosition[0];
            int jediCol = jediPosition[1];

            sum += getSumFromMovement(matrix, jediRow, jediCol, +1);

            command = Reader.readStringArray("\\s+");
        }

        ConsolePrinter.printLine(String.valueOf(sum));
    }

    private static Long getSumFromMovement(int[][] matrix, int row, int col, int colStep) {
        Predicate<Integer> moveCondition = column -> {
            if (colStep < 0) {
                return column >= 0;
            } else {
                return column < matrix[0].length;
            }
        };

        long sum = 0L;
        while (row >= 0 && moveCondition.test(col)) {
            if (isInRange(matrix, row, col)) {
                if (colStep < 0) {
                    matrix[row][col] = 0;
                } else {
                    sum += matrix[row][col];
                }
            }

            row--;
            col += colStep;
        }
        return sum;
    }

    private static boolean isInRange(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    public static int[] parseStringArrayToInt(String[] arr) {
        return Arrays.stream(arr)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[][] createIntMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }

        return matrix;
    }
}
