import java.util.Scanner;

public class Cinema_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String type = input.nextLine();
        int rows = Integer.parseInt(input.nextLine());
        int columns = Integer.parseInt(input.nextLine());
        double price = 0;

        switch (type){
            case "Premiere":
            price = 12;
                break;
            case "Normal":
                price = 7.5;
                break;
            case "Discount":
                price = 5;
                break;
        }
        double income = price * rows * columns;
        System.out.printf("%.2f leva", income);
    }
}
