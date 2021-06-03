import java.util.Scanner;

public class E01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int rowsAndCols = Integer.parseInt(line.split(", ")[0]);
        String type = line.split(", ")[1];

        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        switch (type){
            case "A" :
                printMatrix(fillingMatrixTypeA(matrix));
                break;
            case "B" :
                printMatrix(fillingMatrixTypeB(matrix));
                break;
        }
    }

    public static int[][] fillingMatrixTypeB(int[][] matrix) {
        int counter = 1;

        for (int col = 0; col < matrix.length; col++) {
            if(col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0 ; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }

        return matrix;
    }

    public static int[][] fillingMatrixTypeA (int[][] matrix){
        int counter = 1;

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }

        return matrix;
    }

    public static void printMatrix (int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
