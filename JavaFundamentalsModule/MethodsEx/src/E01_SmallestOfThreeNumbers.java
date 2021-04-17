import java.util.Scanner;

public class E01_SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();

        System.out.println(getSmallestNum(first, second, third));
    }

    static int getSmallestNum(int first, int second, int third) {
        int smallestNum = 0;
        if (first < second && first < third) {
            smallestNum = first;
        } else if (second < first && second < third) {
            smallestNum = second;
        } else {
            smallestNum = third;
        }

        return smallestNum;
    }
}
