import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> elements = new ArrayList<>();
        int degrees = Integer.parseInt(scanner.nextLine().split("[()]")[1]);

        int biggestLength = 0;
        String command = scanner.nextLine();
        while (!command.equals("END")){
            elements.add(command);

            if(command.length() > biggestLength){
                biggestLength = command.length();
            }

            command = scanner.nextLine();
        }

        char[][] matrix = fillMatrix(padMissingElementsWithSpace(elements, biggestLength));
        matrix = rotateMatrix(matrix, degrees);
        printMatrix(matrix);
    }

    public static char[][] rotateMatrix(char[][] matrix, int degrees) {
        if(degrees > 360){
            degrees %= 360;
        }

        int iterations = degrees / 90;
        for (int i = 0; i < iterations; i++) {
            matrix = rotateMatrixOn90Degrees(matrix);
        }

        return matrix;
    }

    public static char[][] rotateMatrixOn90Degrees(char[][] matrix) {
        char[][] rotated = new char[matrix[0].length][matrix.length];

        for (int row = 0; row < rotated.length; row++) {
            int newElementRow = matrix.length - 1;

            for (int col = 0; col < rotated[0].length; col++) {
                rotated[row][col] = matrix[newElementRow][row];
                newElementRow--;
            }
        }

        return rotated;
    }

    public static void printMatrix (char[][] matrix) {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public static char[][] fillMatrix(List<String> list) {
        int rows = list.size();
        int cols = list.get(0).length();
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String word = list.get(row);
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = word.split("")[col].charAt(0);
            }
        }

        return matrix;
    }

    public static List<String> padMissingElementsWithSpace(List<String> list, int length) {
        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);

            if(element.length() < length){
                int diff = length - element.length();
                StringBuilder newElement = new StringBuilder();
                newElement.append(element);
                newElement.append(" ".repeat(diff));
                list.set(i, String.valueOf(newElement));
            }
        }

        return list;
    }
}
