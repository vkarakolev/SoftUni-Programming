import java.util.Scanner;

public class SpecialNumbers_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int firstDigit = 1; firstDigit <= 9; firstDigit++) {
            for (int secondDigit = 1; secondDigit <= 9; secondDigit++) {
                for (int thirdDigit = 1; thirdDigit <= 9; thirdDigit++) {
                    for (int fourthDigit = 1; fourthDigit <= 9; fourthDigit++) {
                        boolean check1 = firstDigit != 0 && n % firstDigit == 0;
                        boolean check2 = secondDigit != 0 && n % secondDigit == 0;
                        boolean check3 = thirdDigit != 0 && n % thirdDigit == 0;
                        boolean check4 = fourthDigit != 0 && n % fourthDigit == 0;

                        if (check1 && check2 && check3 && check4) {
                            System.out.printf("%d%d%d%d ", firstDigit, secondDigit, thirdDigit, fourthDigit);
                        }
                    }
                }
            }
        }
    }
}
