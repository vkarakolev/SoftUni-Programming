import java.util.*;

public class E04_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> products = new LinkedHashMap<>();
        List<Product> productList = new ArrayList<>();

        String command = scanner.nextLine();

        while(!command.equals("buy")){
            String[] productData = command.split(" ");
            String productName = productData[0];
            double currentPrice = Double.parseDouble(productData[1]);
            int currentQuantity = Integer.parseInt(productData[2]);

            Product product = new Product(productName, currentPrice, currentQuantity);

            boolean isContaining = false;
            int index = -1;
            for (int i = 0; i < productList.size(); i++) {
                if((productList.get(i).getName()).equals(productName)) {
                    index = i;
                    isContaining = true;
                    break;
                }
            }

            if(isContaining) {
                int newQuantity = productList.get(index).getQuantity() + currentQuantity;
                product.setQuantity(newQuantity);
                productList.set(index, product);
            } else {
                productList.add(product);
            }

            Double totalProductPrice = product.getPrice() * product.getQuantity();
            products.put(product.getName(), totalProductPrice);

            command = scanner.nextLine();
        }

        products.forEach((k, v) -> System.out.printf("%s -> %.2f%n", k, v));
    }

    public static class Product{
        String name;
        double price;
        int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
