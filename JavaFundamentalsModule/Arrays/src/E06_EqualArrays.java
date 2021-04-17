import java.util.Scanner;

public class E06_EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstString = scanner.nextLine();
        String[] firstStringArray = firstString.split(" ");
        int[] firstIntArray = new int[firstStringArray.length];
        for (int i = 0; i < firstIntArray.length; i++) {
            firstIntArray[i] = Integer.parseInt(firstStringArray[i]);
        }

        String secondString = scanner.nextLine();
        String[] secondStringArray = secondString.split(" ");
        int[] secondIntArray = new int[secondStringArray.length];
        for (int i = 0; i < secondIntArray.length; i++) {
            secondIntArray[i] = Integer.parseInt(secondStringArray[i]);
        }

        boolean areEqual = true;
        int falseIndex = -1;
        int sum = 0;
        if(firstIntArray.length != secondIntArray.length){
            areEqual = false;
        } else {
            for (int i = 0; i < firstIntArray.length; i++) {
                if(firstIntArray[i] != secondIntArray[i]){
                    areEqual = false;
                    falseIndex = i;
                    break;
                } else {
                    sum += firstIntArray[i];
                }
            }
        }

        if(areEqual){
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", falseIndex);
        }

    }
}
