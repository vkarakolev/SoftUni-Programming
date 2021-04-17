import java.util.Scanner;

public class E06_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputString = scanner.nextLine().split(" ");
        int[] inputInt = new int[inputString.length];
        for (int i = 0; i < inputInt.length; i++) {
            inputInt[i] = Integer.parseInt(inputString[i]);
        }

        if(inputInt.length == 1){
            System.out.print(0);
            return;

        }

        boolean isEquals = false;
        for (int i = 0; i < inputInt.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = i - 1; j >= 0; j--) {
                leftSum += inputInt[j];
            }

            for (int j = i + 1; j < inputInt.length; j++) {
                rightSum += inputInt[j];
            }
            
            if (leftSum == rightSum) {
                isEquals = true;
                System.out.println(i);
                break;
            }
        }

        if(!isEquals){
            System.out.println("no");
        }
    }
}

