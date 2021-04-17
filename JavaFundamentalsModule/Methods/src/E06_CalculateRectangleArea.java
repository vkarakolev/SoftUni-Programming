import java.util.Scanner;

public class E06_CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int length = scanner.nextInt();

        System.out.println(calculateArea(width, length));
    }

    static int calculateArea (int a, int b){
        int area = a * b;
        return (area);
    }
}
