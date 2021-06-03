import java.util.Scanner;

public class E02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = generatePalindromeMatrix(rows, cols);
        printMatrix(matrix);
    }

    public static String[][] generatePalindromeMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            char rowChars = (char) (row + 97);
            for (int col = 0; col < cols; col++) {
                char colChar = (char) (rowChars + col);

                String palindrome = String.valueOf(rowChars) + colChar + rowChars;
                matrix[row][col] = palindrome;
            }
        }
        
        return matrix;
    }

    public static void printMatrix (String[][] matrix) {
        for (String[] row : matrix) {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
