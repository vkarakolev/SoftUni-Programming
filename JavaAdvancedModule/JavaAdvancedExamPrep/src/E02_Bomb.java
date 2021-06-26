import java.util.ArrayDeque;
import java.util.Scanner;

public class E02_Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        int[] sapper = new int[2];
        ArrayDeque<Integer> bombs = new ArrayDeque<>();
        int count = 0;

        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < line.length; col++) {
                matrix[row][col] = line[col].charAt(0);

                if (matrix[row][col] == 's') {
                    sapper[0] = row;
                    sapper[1] = col;
                } else if (matrix[row][col] == 'B') {
                    count++;
                    bombs.push(count);
                }
            }
        }

        boolean hasWon = false;
        for (String command : commands) {
            switch (command) {
                case "down" :
                    hasWon = move(sapper, matrix, bombs, +1, 0);
                    break;
                case "up" :
                    hasWon = move(sapper, matrix, bombs, -1, 0);
                    break;
                case "left" :
                    hasWon = move(sapper, matrix, bombs, 0, -1);
                    break;
                case "right" :
                    hasWon = move(sapper, matrix, bombs, 0, +1);
                    break;
            }

            if (hasWon){
                break;
            }
        }

        if (hasWon) {
            if(bombs.size() == 0) {
                System.out.println("Congratulations! You found all bombs!");
            } else {
                System.out.println("END! " + bombs.size() + " bombs left on the field");
            }
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombs.size(), sapper[0], sapper[1]);
        }

    }

    private static boolean move(int[] sapper, char[][] matrix, ArrayDeque<Integer> bombs, int rowModifier, int colModifier) {
        boolean hasWon = false;
        int row = sapper[0];
        int col = sapper[1];
        int newRow = row + rowModifier;
        int newCol = col + colModifier;

        if (!isInBounds(matrix, newRow, newCol)) {
            newRow = row;
            newCol = col;
        } else if (matrix[newRow][newCol] == 'e') {
            hasWon = true;
        } else if (matrix[newRow][newCol] == 'B') {
            System.out.println("You found a bomb!");
            bombs.pop();
            matrix[row][col] = '+';
            matrix[newRow][newCol] = 's';

            if(bombs.size() == 0) {
                hasWon = true;
            }
        }

        sapper[0] = newRow;
        sapper[1] = newCol;
        return hasWon;
    }

    private static boolean isInBounds(char[][] matrix, int newRow, int newCol) {
        return (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix.length);
    }
}
