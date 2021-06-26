import java.util.ArrayDeque;
import java.util.Scanner;

public class E02_Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(", ");

        int[] position = new int[2];
        ArrayDeque<Integer> foodCount = new ArrayDeque<>();

        char[][] matrix = new char[size][size];
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < line.length; col++) {
                matrix[row][col] = line[col].charAt(0);

                if(matrix[row][col] == 's') {
                    position[0] = row;
                    position[1] = col;
                } else if (matrix[row][col] == 'f') {

                    foodCount.push(1);
                }
            }
        }

        ArrayDeque<Integer> length = new ArrayDeque<>();
        length.push(1);
        boolean isKilled = false;
        for (String direction : directions) {
            switch (direction) {
                case "up" :
                    isKilled = move(position, matrix, length, foodCount, -1, 0);
                    break;
                case "down" :
                    isKilled = move(position, matrix, length, foodCount, +1, 0);
                    break;
                case "left" :
                    isKilled = move(position, matrix, length, foodCount, 0, -1);
                    break;
                case "right" :
                    isKilled = move(position, matrix, length, foodCount, 0, +1);
                    break;
            }

            if (foodCount.size() == 0 || isKilled) {
                break;
            }
        }

        if (isKilled) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            if(foodCount.size() == 0) {
                System.out.println("You win! Final python length is " + length.size());
            } else {
                System.out.println("You lose! There is still " + foodCount.size() + " food to be eaten.");
            }
        }
    }

    private static boolean move(int[] position, char[][] matrix, ArrayDeque<Integer> length, ArrayDeque<Integer> foodCount, int rowModifier, int colModifier) {
        boolean isKilled = false;
        int row = position[0];
        int col = position[1];
        int newRow = isInBounds(row + rowModifier, matrix);
        int newCol = isInBounds(col + colModifier, matrix);

        if (matrix[newRow][newCol] == 'f') {
            length.push(1);
            foodCount.pop();
        } else if (matrix[newRow][newCol] == 'e') {
            isKilled = true;
        }

        matrix[row][col] = '*';
        matrix[newRow][newCol] = 's';
        position[0] = newRow;
        position[1] = newCol;
        return isKilled;
    }

    private static int isInBounds(int i, char[][] matrix) {
        if (i < 0) {
            i = matrix.length - 1;
        } else if (i == matrix.length) {
            i = 0;
        }
        return i;
    }
}
