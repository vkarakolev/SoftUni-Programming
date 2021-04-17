import java.util.Scanner;

public class FishLand_06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double mackerelValue = Double.parseDouble(input.nextLine()); // Скумрия
        double toyValue = Double.parseDouble(input.nextLine()); // Цаца
        double bonitoCount = Double.parseDouble(input.nextLine()); // Паламуд
        double horseMackerelCount = Double.parseDouble(input.nextLine()); // Сафрид
        int shellCount = Integer.parseInt(input.nextLine()); //Миди
        double bonitoValue = mackerelValue * 1.6;
        double horseMackerelValue = toyValue * 1.8;
        double bill = bonitoCount * bonitoValue + horseMackerelCount * horseMackerelValue + shellCount * 7.5;
        System.out.printf("%.2f", bill);
    }
}
