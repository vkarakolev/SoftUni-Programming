import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class E01_EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] results = new int[n];

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            int currentResult = 0;
            for (int j = 0; j <word.length(); j++) {
                switch (word.charAt(j)){
                    case 'a' :
                    case 'A' :
                    case 'e' :
                    case 'E' :
                    case 'i' :
                    case 'I' :
                    case 'o' :
                    case 'O' :
                    case 'u' :
                    case 'U' :
                        currentResult += word.charAt(j) * word.length();
                        break;
                    default:
                        currentResult += word.charAt(j) / word.length();
                }
            }

            results[i] = currentResult;
        }

        Arrays.sort(results);
        for (int r : results) {
            System.out.println(r);
        }

    }
}
