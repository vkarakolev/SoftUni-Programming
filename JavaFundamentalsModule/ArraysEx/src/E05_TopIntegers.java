import java.util.Scanner;

public class E05_TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputString = scanner.nextLine().split(" ");
        int[] inputInt = new int[inputString.length];
        for (int i = 0; i < inputInt.length; i++) {
            inputInt[i] = Integer.parseInt(inputString[i]);
        }

        for (int i = 0; i < inputInt.length; i++) {
            boolean isBigger = true;
            for (int j = i + 1; j < inputInt.length; j++) {
                if(inputInt[i] <= inputInt[j]) {
                    isBigger = false;
                    break;
                }
            }
            if(isBigger){
                System.out.print(inputInt[i] + " ");
            }
        }
    }
}
