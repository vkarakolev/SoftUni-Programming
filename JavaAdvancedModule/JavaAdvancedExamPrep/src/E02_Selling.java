import java.util.Scanner;

public class E02_Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = readSquareMatrix(size, scanner);
        Integer[][] positions = findPositions(matrix);

        int money = 0;
        while (money != -1 && money < 50) {
            String direction = scanner.nextLine();

            switch (direction) {
                case "down" :
                    money = move(positions, money, matrix, +1, 0);
                    break;
                case "up" :
                    money = move(positions, money, matrix, -1, 0);
                    break;
                case "left" :
                    money = move(positions, money, matrix, 0, -1);
                    break;
                case "right" :
                    money = move(positions, money, matrix, 0, +1);
                    break;
            }
        }

        if(money == -1) {
            System.out.println("Bad news, you are out of the bakery.");
            money = 0;
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + money);
        printMatrix(matrix);


    }

    private static void printMatrix (char[][] matrix) {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    private static int move(Integer[][] positions, int money, char[][] matrix, int rowModifier, int colModifier) {
        int row = positions[0][0];
        int col = positions[0][1];
        int newRow = row + rowModifier;
        int newCol = col + colModifier;

        if(newRow == matrix.length || newCol == matrix.length || newRow < 0 || newCol < 0) {
            matrix[row][col] = '-';
            return -1;
        } else if(Character.isDigit(matrix[newRow][newCol])){
            int currentMoney = Character.getNumericValue(matrix[newRow][newCol]);
            money += currentMoney;
        } else if (newRow == positions[1][0] && newCol == positions[1][1]) {
            matrix[newRow][newCol] = '-';
            newRow = positions[2][0];
            newCol = positions[2][1];
        } else if (newRow == positions[2][0] && newCol == positions[2][1]) {
            matrix[newRow][newCol] = '-';
            newRow = positions[1][0];
            newCol = positions[1][1];
        }

        matrix[row][col] = '-';
        matrix[newRow][newCol] = 'S';
        positions[0][0] = newRow;
        positions[0][1] = newCol;
        return money;
    }

    private static Integer[][] findPositions(char[][] matrix) {
        Integer[][] positions = new Integer[3][2];
        int count = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
                    positions[0][0] = row;
                    positions[0][1] = col;
                } else if (matrix[row][col] == 'O') {
                    if(count == 0) {
                        positions[1][0] = row;
                        positions[1][1] = col;
                        count++;
                    } else {
                        positions[2][0] = row;
                        positions[2][1] = col;
                    }
                }
            }
        }

        if(positions[1][0] == null){
            positions[1] = new Integer[]{-1, -1};
            positions[2] = new Integer[]{-1, -1};
        }

        return positions;
    }

    private static char[][] readSquareMatrix (int size, Scanner scanner) {
        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        return matrix;
    }
}
