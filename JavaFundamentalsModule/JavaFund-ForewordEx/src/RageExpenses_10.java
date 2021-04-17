import java.util.Scanner;

public class RageExpenses_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gamesLost = scanner.nextInt();
        double headsetPrice = scanner.nextDouble();
        double mousePrice = scanner.nextDouble();
        double keyboardPrice = scanner.nextDouble();
        double displayPrice = scanner.nextDouble();

        int displayCount = 0;
        int keyboardCount = 0;
        int mouseCount = 0;
        int headsetCount = 0;
        double sum = 0;

        if(gamesLost / 12 > 0){
           displayCount = gamesLost / 12;
        }
        if (gamesLost / 6 > 0){
            keyboardCount = gamesLost / 6;
        }
        if (gamesLost / 3 > 0) {
            mouseCount = gamesLost / 3;
        }
        if (gamesLost / 2 > 0){
            headsetCount = gamesLost / 2;
        }

        sum = displayCount * displayPrice + keyboardCount * keyboardPrice +
                 mouseCount * mousePrice + headsetCount * headsetPrice;
        System.out.printf("Rage expenses: %.2f lv.", sum);
    }
}
