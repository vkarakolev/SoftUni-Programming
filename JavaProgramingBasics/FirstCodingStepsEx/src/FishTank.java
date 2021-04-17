import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = Integer.parseInt(input.nextLine());
        int width = Integer.parseInt(input.nextLine());
        int height = Integer.parseInt(input.nextLine());
        double percent = Double.parseDouble(input.nextLine());
        int capacity = length * width * height;
        double freeSpace = capacity - (percent / 100) * capacity;
        double liters = freeSpace * 0.001;
        System.out.printf("%.2f", liters);

    }
}
