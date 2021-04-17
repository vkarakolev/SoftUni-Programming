import java.util.Scanner;

public class E03_CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        printCharsInRange(first, second);
    }

    static void printCharsInRange(char first, char second){
        char greater, smaller;

        if (first > second){
            greater = first;
            smaller = second;
        } else {
            greater = second;
            smaller = first;
        }

        for (int i = smaller + 1; i < greater; i++) {
            char currentChar = (char)i;
            System.out.print(currentChar + " ");
        }
    }
}
