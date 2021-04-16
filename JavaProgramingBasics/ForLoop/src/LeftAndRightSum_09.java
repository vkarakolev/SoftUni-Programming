import java.util.Scanner;

public class LeftAndRightSum_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int NumCount = Integer.parseInt(scanner.nextLine());
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < NumCount; i++) {
            int leftNumbers = Integer.parseInt(scanner.nextLine());
            leftSum += leftNumbers;
        }

        for (int i = 0; i < NumCount; i++) {
            int rightNumbers = Integer.parseInt(scanner.nextLine());
            rightSum += rightNumbers;
        }

        if (leftSum == rightSum) {
            System.out.println("Yes, sum = " + leftSum);
        } else {
            int diff = Math.abs(leftSum - rightSum);
            System.out.println("No, diff = " + diff);
        }
    }
}
