import java.util.Scanner;

public class BarcodeGenerator_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        int firstStartNum = start / 1000;
        int secondStartNum = start / 100 % 10;
        int thirdStartNum = start / 10 % 10;
        int forthStartNum = start % 10;

        int firstEndNum = end / 1000;
        int secondEndNum = end / 100 % 10;
        int thirdEndNum = end / 10 % 10;
        int forthEndNum = end % 10;

        for (int first = firstStartNum; first <= firstEndNum; first++) {
            if (first % 2 == 0) {
                continue;
            }
            for (int second = secondStartNum; second <= secondEndNum; second++) {
                if (second % 2 == 0) {
                    continue;
                }
                for (int third = thirdStartNum; third <= thirdEndNum; third++) {
                    if (third % 2 == 0) {
                        continue;
                    }
                    for (int forth = forthStartNum; forth <= forthEndNum; forth++) {
                        if (forth % 2 == 0) {
                            continue;
                        }
                        System.out.printf("%d%d%d%d ", first, second, third, forth);
                    }
                }
            }
        }
    }
}
