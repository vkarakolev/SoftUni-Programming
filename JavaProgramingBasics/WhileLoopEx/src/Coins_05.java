import java.util.Scanner;

public class Coins_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double changeInLeva = Double.parseDouble(scanner.nextLine());
        double changeInStotinki = Math.round(changeInLeva * 100);
        int countCoins = 0;

        while (changeInStotinki > 0) {
            if (changeInStotinki >= 200) {
                changeInStotinki -= 200;
                countCoins++;
            } else if (changeInStotinki >= 100) {
                changeInStotinki -= 100;
                countCoins++;
            } else if (changeInStotinki >= 50) {
                changeInStotinki -= 50;
                countCoins++;
            } else if (changeInStotinki >= 20) {
                changeInStotinki -= 20;
                countCoins++;
            } else if (changeInStotinki >= 10) {
                changeInStotinki -= 10;
                countCoins++;
            } else if (changeInStotinki >= 5) {
                changeInStotinki -= 5;
                countCoins++;
            } else if (changeInStotinki >= 2) {
                changeInStotinki -= 2;
                countCoins++;
            } else if (changeInStotinki == 1) {
                changeInStotinki -= 1;
                countCoins++;
            }
        }

        System.out.println(countCoins);
    }
}

