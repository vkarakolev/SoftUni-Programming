import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class E06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> stores = new TreeMap<>();

        String command = scanner.nextLine();
        while (!command.equals("Revision")){
            String store = command.split(", ")[0];
            String product = command.split(", ")[1];
            double price = Double.parseDouble(command.split(", ")[2]);

            stores.putIfAbsent(store, new LinkedHashMap<>());
            LinkedHashMap<String, Double> products = stores.get(store);
            products.put(product, price);

            command = scanner.nextLine();
        }

        printOutput(stores);
    }

    private static void printOutput(TreeMap<String, LinkedHashMap<String, Double>> stores) {
        for (var storeEntry : stores.entrySet()) {
            String store = storeEntry.getKey();
            System.out.println(store + "->");

            for (var productEntry : storeEntry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", productEntry.getKey(), productEntry.getValue());
            }
        }
    }
}
