import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = readArray(scanner);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = readMatrix(rows, cols, scanner);

        int searchElement = Integer.parseInt(scanner.nextLine());

        List<int[]> output = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentElement = matrix[row][col];
                if(currentElement == searchElement){
                    output.add(new int[] {row, col});
                }
            }
        }

        if(output.isEmpty()){
            System.out.println("not found");
        } else {
            for (int[] indexes : output) {
                System.out.println(indexes[0] + " " + indexes[1]);
            }
        }
    }

    public static int[] readArray (Scanner scanner){
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner){
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner);
        }

        return matrix;
    }
}
