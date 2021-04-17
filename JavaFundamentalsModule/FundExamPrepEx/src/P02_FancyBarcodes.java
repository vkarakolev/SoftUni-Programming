import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String regex = "^@#+(?<item>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+$";
        Pattern pattern = Pattern.compile(regex);
        String digitRegex = "\\d+";
        Pattern digitPattern = Pattern.compile(digitRegex);

        for (int i = 0; i < n; i++) {
            String barcodes = scanner.nextLine();
            Matcher matcher = pattern.matcher(barcodes);

            if(matcher.find()){
                String item = matcher.group("item");
                matcher = digitPattern.matcher(item);
                if(matcher.find()){
                    StringBuilder digits = new StringBuilder();
                    digits.append(matcher.group());
                    while(matcher.find()){
                        digits.append(matcher.group());
                    }
                    System.out.printf("Product group: %s%n", digits);
                } else {
                    System.out.println("Product group: 00");
                }
            } else {
                System.out.println("Invalid barcode");
            }

        }
    }
}
