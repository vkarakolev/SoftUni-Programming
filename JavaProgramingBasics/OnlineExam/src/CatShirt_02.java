import java.util.Scanner;

public class CatShirt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sleeve = Double.parseDouble(scanner.nextLine());
        double frontPart = Double.parseDouble(scanner.nextLine());
        String material = scanner.nextLine();
        String tie = scanner.nextLine();

        double shirtWithoutNeckPiece = sleeve * 2 + frontPart * 2;
        double shirtArea = shirtWithoutNeckPiece + shirtWithoutNeckPiece * 0.1;
        double shirtPrice = 0;

        switch (material) {
            case "Linen":
                shirtPrice = shirtArea / 100 * 15;
                break;
            case "Cotton":
                shirtPrice = shirtArea / 100 * 12;
                break;
            case "Denim":
                shirtPrice = shirtArea / 100 * 20;
                break;
            case "Twill":
                shirtPrice = shirtArea / 100 * 16;
                break;
            case "Flannel":
                shirtPrice = shirtArea / 100 * 11;
                break;
        }
        double totalPrice = shirtPrice + 10;

        if (tie.equals("Yes")){
            totalPrice *= 1.2;
        }

        System.out.printf("The price of the shirt is: %.2flv.", totalPrice);
    }
}
