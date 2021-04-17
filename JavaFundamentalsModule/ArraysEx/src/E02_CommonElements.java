import java.util.Scanner;

public class E02_CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstString = scanner.nextLine();
        String[] firstArr = firstString.split(" ");

        String secondString = scanner.nextLine();
        String[] secondArr = secondString.split(" ");

        for (int i = 0; i < secondArr.length; i++) {
            for (int j = 0; j < firstArr.length; j++) {
                if(secondArr[i].equals(firstArr[j])){
                    System.out.print(secondArr[i] + " ");
                }
            }
        }
    }
}
