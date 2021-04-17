import java.util.Scanner;

public class SquareArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int side = Integer.parseInt(input.nextLine());
        int area = side * side;
        System.out.println(area);
    }
}
