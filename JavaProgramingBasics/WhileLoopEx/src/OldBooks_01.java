import java.util.Scanner;

public class OldBooks_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String searchedBook = scanner.nextLine();
        int count = 0;

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("No More Books")) {
                System.out.println("The book you search is not here!");
                System.out.printf("You checked %d books.", count);
                break;
            }

            if (command.equals(searchedBook)) {
                System.out.printf("You checked %d books and found it.", count);
                break;
            }

            count++;
        }
    }
}
