import java.util.Scanner;

public class E03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(rows, cols, scanner);
        char[][] secondMatrix = readMatrix(rows, cols, scanner);

        printMatrix(intersectionOfTwoMatrices(firstMatrix, secondMatrix));
    }

    public static void printMatrix (char[][] matrix){
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static char[][] intersectionOfTwoMatrices (char[][] first, char[][] second){
        int rows = first.length;
        int cols = first[0].length;
        char[][] intersectionMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char element;
                if(first[row][col] == second[row][col]){
                    element = first[row][col];
                } else {
                    element = '*';
                }
                intersectionMatrix[row][col] = element;
            }
        }

        return intersectionMatrix;
    }

    public static char[][] readMatrix (int rows, int cols, Scanner scanner){
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split(" ");

            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = tokens[col].charAt(0);
            }
        }

        return matrix;
    }
}
