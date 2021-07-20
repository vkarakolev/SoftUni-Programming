package E04_PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[1];
            int countOfToppings = Integer.parseInt(data[2]);
            Pizza pizza = new Pizza(name, countOfToppings);

            data = scanner.nextLine().split("\\s+");
            String type = data[1];
            String baking = data[2];
            double weight = Double.parseDouble(data[3]);
            Dough dough = new Dough(type, baking, weight);
            pizza.setDough(dough);

            data = scanner.nextLine().split("\\s+");
            while (!data[0].equals("END")) {
                type = data[1];
                weight = Double.parseDouble(data[2]);
                Topping topping = new Topping(type, weight);
                pizza.addTopping(topping);

                data = scanner.nextLine().split("\\s+");
            }

            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
