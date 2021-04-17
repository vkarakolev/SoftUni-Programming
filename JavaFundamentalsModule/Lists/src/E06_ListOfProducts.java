import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E06_ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int productsCount = Integer.parseInt(scanner.nextLine());
        List<String> products = addElementsInList(productsCount, scanner);

        Collections.sort(products);

        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, products.get(i));
        }

    }

    static List<String> addElementsInList (int count, Scanner scanner){
        List<String> inputList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            String elements = scanner.nextLine();
            inputList.add(elements);
        }
        return(inputList);
    }
}
