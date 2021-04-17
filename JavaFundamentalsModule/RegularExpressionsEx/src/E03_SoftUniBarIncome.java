import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E03_SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "%(?<customer>[A-Z][a-z]+)%(.[^|$%.]+)?<(?<product>\\w+)>(.[^|$%.]+)?\\|(?<count>\\d+)\\|(.[^|$%.]+)?(?<price>\\d+(\\.\\d+)?)\\$";
        Pattern pattern = Pattern.compile(regex);
        double income = 0;

        String input = scanner.nextLine();
        while(!input.equals("end of shift")){
            Matcher matcher = pattern.matcher(input);
            while(matcher.find()){
                String name = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double totalProductPrice = count * price;
                income += totalProductPrice;

                System.out.printf("%s: %s - %.2f%n", name, product, totalProductPrice);
            }
            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", income);
    }
}