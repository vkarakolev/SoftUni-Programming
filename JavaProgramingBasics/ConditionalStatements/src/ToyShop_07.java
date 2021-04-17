import java.util.Scanner;

public class ToyShop_07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double tripPrice = Double.parseDouble(input.nextLine());
        int puzzles = Integer.parseInt(input.nextLine());
        int speakingDolls = Integer.parseInt(input.nextLine());
        int teddyBears = Integer.parseInt(input.nextLine());
        int minions = Integer.parseInt(input.nextLine());
        int trucks = Integer.parseInt(input.nextLine());
        double turnover = puzzles * 2.6 + speakingDolls * 3 + teddyBears * 4.1 + minions * 8.2 + trucks * 2;
        int toyCount = puzzles + speakingDolls + teddyBears + minions + trucks;

        if (toyCount >= 50){
            turnover *= 0.75;
        }
        double profit = turnover * 0.9;
        double money = 0;
        if(profit >= tripPrice){
            money = profit - tripPrice;
            System.out.printf("Yes! %.2f lv left.", money);
        }else{
            money = tripPrice - profit;
            System.out.printf("Not enough money! %.2f lv needed.", money);
        }
    }
}
