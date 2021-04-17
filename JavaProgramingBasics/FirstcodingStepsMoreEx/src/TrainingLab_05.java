import java.util.Scanner;

public class TrainingLab_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter length <= 100: ");
        double w = Double.parseDouble(input.nextLine());
        System.out.print("Enter width <= 100 and >= 3: ");
        double h = Double.parseDouble(input.nextLine());
        int seatsOnRow = (int) ((h - 1) / 0.7);
        int rows = (int) (w / 1.2);
        int workspaces = seatsOnRow * rows - 3;
        System.out.println(workspaces);
    }
}
