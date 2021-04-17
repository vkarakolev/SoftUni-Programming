import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int days = Integer.parseInt(input.nextLine());
        int confectioners = Integer.parseInt(input.nextLine());
        int cakes =  Integer.parseInt(input.nextLine());
        int waffles =  Integer.parseInt(input.nextLine());
        int pancakes =  Integer.parseInt(input.nextLine());
        double turnover = days * (confectioners * (cakes * 45.0 + waffles * 5.8 + pancakes * 3.2));
        double donation = turnover - turnover / 8;
        System.out.printf("%.2f лв.", donation);
    }
}
