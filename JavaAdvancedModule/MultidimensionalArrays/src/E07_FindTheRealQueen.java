import java.util.Scanner;

public class E07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char [][] matrix = readMatrix(8, scanner, " ");

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 'q'){
                    if(isValidQueen(row, col, matrix)){
                        System.out.println(row + " " + col);
                    }
                }
            }
        }
    }

    public static boolean isValidQueen(int row, int col, char[][] matrix) {
        return checkFirstDiagonal(row, col, matrix) &&
                checkSecondDiagonal(row, col, matrix) &&
                checkRow(row, matrix) &&
                checkCol(col, matrix);
    }

    public static boolean checkCol(int col, char[][] matrix) {
        int counter = 0;

        for (char[] chars : matrix) {
            if (chars[col] == 'q') {
                counter++;
            }

            if (counter > 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkRow(int row, char[][] matrix) {
        int counter = 0;

        for (int currentCol = 0; currentCol < matrix[row].length; currentCol++) {
            if(matrix[row][currentCol] == 'q'){
                counter++;
            }

            if(counter > 1){
                return false;
            }
        }

        return true;
    }

    public static boolean checkSecondDiagonal(int row, int col, char[][] matrix) {
        int currentRow = row;
        int currentCol = col;

        while(currentRow != matrix.length - 1 && currentCol != 0){
            currentRow++;
            currentCol--;

            if(matrix[currentRow][currentCol] == 'q'){
                return false;
            }
        }

        while (row != 0 && col != matrix[row].length - 1) {
            row--;
            col++;

            if (matrix[row][col] == 'q'){
                return false;
            }
        }
        return true;
    }

    public static boolean checkFirstDiagonal(int row, int col, char[][] matrix){
        int currentRow = row;
        int currentCol = col;

        while(currentRow != 0 && currentCol != 0){
            currentRow--;
            currentCol--;

            if(matrix[currentRow][currentCol] == 'q'){
                return false;
            }
        }

        while(row != matrix.length - 1 && col != matrix[row].length - 1){
            row++;
            col++;

            if(matrix[row][col] == 'q'){
                return false;
            }
        }

        return true;
    }

    public static char[] readArray (String line, String regex){

        char[] arr = new char [8];

        for (int i = 0; i < 8; i++) {
            arr[i] = (line.split(regex)[i].charAt(0));
        }

        return arr;
    }

    public static char[][] readMatrix(int rowsAndCols, Scanner scanner, String regex) {
        char[][] matrix = new char[rowsAndCols][rowsAndCols];

        for (int row = 0; row < rowsAndCols; row++) {
            matrix[row] = readArray(scanner.nextLine(), regex);
        }

        return matrix;
    }
}
