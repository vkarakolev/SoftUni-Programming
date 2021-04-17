import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E01_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regEx = ">>(?<name>[A-Z][A-Za-z]+)<<(?<price>\\d+(\\.\\d+)?)!(?<quantity>\\d+)";
        double bill = 0;
        List<String> furniture = new ArrayList<>();

        Pattern pattern = Pattern.compile(regEx);
        while(!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            while(matcher.find()){
                String name = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                furniture.add(name);
                bill += price * quantity;
            }
            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        for (String s : furniture) {
            System.out.println(s);
        }
        System.out.printf("Total money spend: %.2f", bill);

    }
}
