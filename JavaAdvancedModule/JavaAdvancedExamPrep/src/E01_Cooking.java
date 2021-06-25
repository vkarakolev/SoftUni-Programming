import java.util.*;
import java.util.stream.Collectors;

public class E01_Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        Map<String, Integer> materials = new TreeMap<>();
        materials.put("Bread", 0);
        materials.put("Cake", 0);
        materials.put("Pastry", 0);
        materials.put("Fruit Pie", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()){
            int liquid = liquids.poll();
            int ingredient = ingredients.peek();
            int sum = liquid + ingredient;

            switch (sum) {
                case 25 :
                    materials.merge("Bread", 1, Integer::sum);
                    break;
                case 50 :
                    materials.merge("Cake", 1, Integer::sum);
                    break;
                case 75 :
                    materials.merge("Pastry", 1, Integer::sum);
                    break;
                case 100 :
                    materials.merge("Fruit Pie", 1, Integer::sum);
                    break;
                default :
                    ingredients.push(ingredients.pop() + 3);
                    continue;
            }

            ingredients.pop();
        }

        int typesCooked = 0;
        for (var entry : materials.entrySet()) {
            if(entry.getValue() != 0){
                typesCooked++;
            }
        }

        if(typesCooked == 4){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        System.out.println("Liquids left: " + isLeft(liquids));
        System.out.println("Ingredients left: " + isLeft(ingredients));
        materials.entrySet().stream()
                .map(e -> String.format("%s: %d", e.getKey(), e.getValue()))
                .forEach(System.out::println);
    }

    private static String isLeft (ArrayDeque<Integer> deque) {
        if(deque.isEmpty()){
            return "none";
        } else {
            return deque.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
        }
    }
}
