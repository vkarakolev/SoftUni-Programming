import java.util.Scanner;

public class BirthdayParty_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //наем на залата -> от конзолата
        //цена на торта -> 20% от залата = 0.2 * наем на залата
        //цена на напитки -> торта - 45% = торта - 0.45 * торта
        //цена на аниматора -> 1 / 3 от наем на залата = наем на залата / 3
        //разходи = наем на залата + торта + напитки + аниматор

        int hallRent = Integer.parseInt(input.nextLine());
        double cakePrice = hallRent * 0.2;
        double drinksPrice = cakePrice - 0.45 * cakePrice;
        double animatorPrice = hallRent / 3.0;
        double expences = hallRent + cakePrice + drinksPrice + animatorPrice;
        System.out.println(expences);
    }
}
