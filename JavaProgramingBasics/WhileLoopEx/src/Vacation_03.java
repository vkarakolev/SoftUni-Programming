import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vacationPrice = Double.parseDouble(scanner.nextLine());
        double  savedMoney = Double.parseDouble(scanner.nextLine());
        int spendCount = 0;
        int daysCount = 0;

        while(true){
            String action = scanner.nextLine();
            double amount = Double.parseDouble(scanner.nextLine());
            daysCount++;
            if(action.equals("spend")){
                spendCount++;
                if(spendCount == 5){
                    System.out.println("You can't save the money.");
                    System.out.println(daysCount);
                    break;
                }
                savedMoney -= amount;
                if(amount > savedMoney){
                    savedMoney = 0;
                }
            } else if(action.equals("save")){
                spendCount = 0;
                savedMoney += amount;
                if(savedMoney >= vacationPrice){
                    System.out.printf("You saved the money for %d days.", daysCount);
                    break;
                }
            }

        }
    }
}
