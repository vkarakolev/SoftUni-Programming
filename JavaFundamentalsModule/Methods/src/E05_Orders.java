import java.util.Scanner;

public class E05_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        calculateAndPrintPrice(product, quantity);

    }

    static void calculateAndPrintPrice(String product, int quantity) {
        double price = 0;
        switch (product) {
            case "coffee":
                price = 1.5;
                break;
            case "water":
                price = 1;
                break;
            case "coke":
                price = 1.4;
                break;
            case "snacks":
                price = 2;
                break;
        }
        System.out.printf("%.2f", price * quantity);
    }
}
