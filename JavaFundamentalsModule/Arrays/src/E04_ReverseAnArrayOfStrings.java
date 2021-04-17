import java.util.Scanner;

public class E04_ReverseAnArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arrayOfStrings = input.split(" ");

        for (int i = 0; i < arrayOfStrings.length / 2; i++) {
            int swapIndex = arrayOfStrings.length - 1 - i;
            String oldI = arrayOfStrings[i];
            arrayOfStrings[i] = arrayOfStrings[swapIndex];
            arrayOfStrings[swapIndex] = oldI;
        }
        System.out.println(String.join(" ", arrayOfStrings));
    }
}
