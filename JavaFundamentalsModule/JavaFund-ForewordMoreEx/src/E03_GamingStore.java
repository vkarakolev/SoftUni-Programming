import java.util.Scanner;

public class E03_GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        double spentMoney = 0;

        String game = scanner.nextLine();
        while (!game.equals("Game Time")) {
            double gamePrice = 0;
            boolean found = true;

            switch (game) {
                case "RoverWatch Origins Edition":
                case "OutFall 4":
                    gamePrice = 39.99;
                    break;
                case "CS: OG":
                    gamePrice = 15.99;
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99;
                    break;
                case "Honored 2":
                    gamePrice = 59.99;
                    break;
                case "RoverWatch":
                    gamePrice = 29.99;
                    break;
                default:
                    found = false;
                    break;
            }

            if(!found){
                System.out.println("Not Found");
            } else if (currentBalance - gamePrice < 0){
                System.out.println("Too Expensive");
            } else {
                currentBalance -= gamePrice;
                spentMoney += gamePrice;
                System.out.println("Bought " + game);
            }

            game = scanner.nextLine();
        }
        if (currentBalance == 0){
            System.out.println("Out of money!");
        } else  {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spentMoney, currentBalance);
        }
    }
}
