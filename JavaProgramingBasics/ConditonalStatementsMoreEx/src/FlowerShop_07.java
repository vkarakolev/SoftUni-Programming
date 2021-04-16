import java.util.Scanner;

public class FlowerShop_07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int magnoliaCount = Integer.parseInt(input.nextLine());
        int hyacinthCount = Integer.parseInt(input.nextLine()); //зюмбюли
        int rosesCount = Integer.parseInt(input.nextLine());
        int cactusCount = Integer.parseInt(input.nextLine());
        double giftPrice = Double.parseDouble(input.nextLine());

        double turnover = 0.95 * (magnoliaCount * 3.25 + hyacinthCount * 4 + rosesCount * 3.5 + cactusCount * 8);

        if (turnover >= giftPrice) {
            double moneyLeft = turnover - giftPrice;
            System.out.printf("She is left with %.0f leva.", Math.floor(moneyLeft));
        } else {
            double moneyLack = giftPrice - turnover;
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(moneyLack) );
        }
    }
}
