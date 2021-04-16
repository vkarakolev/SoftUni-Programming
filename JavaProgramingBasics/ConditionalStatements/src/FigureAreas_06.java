import java.util.Scanner;

public class FigureAreas_06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String shape = input.nextLine();
        double area = 0;
        if (shape.equals("square")){
            double squareSide = Double.parseDouble(input.nextLine());
            area = squareSide * squareSide;
        }else if (shape.equals("rectangle")){
            double sideA = Double.parseDouble(input.nextLine());
            double sideB = Double.parseDouble(input.nextLine());
            area = sideA * sideB;
        }else if (shape.equals("circle")){
            double radius = Double.parseDouble(input.nextLine());
            area = Math.PI * radius * radius;
        }else if (shape.equals("triangle")){
            double triangleSide = Double.parseDouble(input.nextLine());
            double height = Double.parseDouble(input.nextLine());
            area = triangleSide * height / 2;
        }
        System.out.printf("%.3f", area);
    }
}
