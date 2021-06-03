import java.util.Arrays;
import java.util.Scanner;

public class E05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = readArray(scanner.nextLine(), " ");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        String[][] matrix = readMatrix(rows, cols, scanner, " ");

        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] commandData = command.split("\\s+");

            if(isValid(commandData, rows, cols)){
                int firstRow = Integer.parseInt(commandData[1]);
                int firstCol = Integer.parseInt(commandData[2]);
                int secondRow = Integer.parseInt(commandData[3]);
                int secondCol = Integer.parseInt(commandData[4]);

                printMatrix(swapElements(matrix, firstRow, firstCol, secondRow, secondCol));
            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }

    }

    public static String[][] swapElements(String[][] matrix, int firstRow, int firstCol, int secondRow, int secondCol) {
        String firstElement = matrix[firstRow][firstCol];
        String secondElement = matrix[secondRow][secondCol];

        matrix[firstRow][firstCol] = secondElement;
        matrix[secondRow][secondCol] = firstElement;

        return matrix;
    }

    public static boolean isValid(String[] command, int rows, int cols) {
        return command.length == 5 && command[0].equals("swap") &&
                -1 < Integer.parseInt(command[1]) && Integer.parseInt(command[1]) < rows &&
                -1 < Integer.parseInt(command[3]) && Integer.parseInt(command[3]) < rows &&
                -1 < Integer.parseInt(command[2]) && Integer.parseInt(command[2]) < cols &&
                -1 < Integer.parseInt(command[4]) && Integer.parseInt(command[4]) < cols;
    }

    public static void printMatrix (String[][] matrix) {
        for (String[] row : matrix) {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static String[][] readMatrix(int rows, int cols, Scanner scanner, String regex){
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split(regex);
        }

        return matrix;
    }

    public static int[] readArray (String line, String regex){
        return Arrays.stream(line.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
