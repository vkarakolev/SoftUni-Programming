import java.util.Scanner;

public class CatExpenses_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double bed = Double.parseDouble(scanner.nextLine());
        double toilet = Double.parseDouble(scanner.nextLine());

        double food = toilet * 1.25;
        double toys = food / 2;
        double vet = toys * 1.1;
        double savings = (toilet + food + toys + vet) * 0.05;

        double expenses = bed + ( toilet + food + toys + vet + savings) * 12;
        System.out.printf("%.2f lv.", expenses);
    }
}
