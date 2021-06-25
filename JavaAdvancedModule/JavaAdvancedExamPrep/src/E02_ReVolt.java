import java.util.Scanner;

public class E02_ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int commandsCount = Integer.parseInt(scanner.nextLine());

        int[] position = new int[2];
        char[][] matrix = new char[size][size];
        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();

            if(line.contains("f")){
                position[0] = row;
                position[1] = line.indexOf("f");
            }
        }

        boolean hasWon = false;
        while (commandsCount-- > 0 && !hasWon){
            String command = scanner.nextLine();

            switch (command){
                case "up" :
                    hasWon = movePlayer(position, matrix, -1, 0);
                    break;
                case "down" :
                    hasWon = movePlayer(position, matrix, +1, 0);
                    break;
                case "left" :
                    hasWon = movePlayer(position, matrix, 0, -1);
                    break;
                case "right" :
                    hasWon = movePlayer(position, matrix, 0, +1);
                    break;
            }
        }

        if (hasWon){
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);
    }

    private static boolean movePlayer(int[] position, char[][] matrix, int rowModifier, int colModifier) {
        int row = position[0];
        int col = position[1];
        int newRow = validatePosition(row + rowModifier, matrix.length);
        int newCol = validatePosition(col + colModifier, matrix.length);

        boolean playerWon = false;

        if(matrix[newRow][newCol] == 'B') {
            newRow = validatePosition(newRow + rowModifier, matrix.length);
            newCol = validatePosition(newCol + colModifier, matrix.length);
        } else if (matrix[newRow][newCol] == 'T') {
            return false;
        }

        if(matrix[newRow][newCol] == 'F'){
            playerWon = true;
        }

        matrix[row][col] = '-';
        matrix[newRow][newCol] = 'f';
        position[0] = newRow;
        position[1] = newCol;
        return playerWon;
    }

    private static int validatePosition(int position, int size) {
        if (position < 0) {
            position = size - 1;
        } else if (position >= size) {
            position = 0;
        }

        return position;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] rows : matrix) {
            for (char col : rows) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
