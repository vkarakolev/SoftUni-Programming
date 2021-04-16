import java.util.Scanner;

public class AgencyProfit_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String companyName = scanner.nextLine();
        int adultTicketsCount = Integer.parseInt(scanner.nextLine());
        int kidTicketsCount = Integer.parseInt(scanner.nextLine());
        double netAdultPrice = Double.parseDouble(scanner.nextLine());
        double serviceTax = Double.parseDouble(scanner.nextLine());

        double netKidsPrice = netAdultPrice * 0.3;
        int ticketsCount = adultTicketsCount + kidTicketsCount;
        double allTicketsPrice = adultTicketsCount * netAdultPrice + kidTicketsCount * netKidsPrice + ticketsCount * serviceTax;
        double profit = allTicketsPrice * 0.2;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", companyName, profit);
    }
}
