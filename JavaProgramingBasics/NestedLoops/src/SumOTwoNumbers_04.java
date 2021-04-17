import java.util.Scanner;

public class SumOTwoNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());
        int count = 0;
        boolean isFound = false;

        for(int firstNum = start; firstNum <= end; firstNum++){
            for(int secondNum = start; secondNum <= end; secondNum++){
                count++;
                if(firstNum + secondNum == magicNumber){
                    isFound = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", count, firstNum, secondNum, magicNumber);
                    break;
                }
            }
            if(isFound){
                break;
            }
        }

        if(!isFound){
            System.out.printf("%d combinations - neither equals %d", count, magicNumber);
        }
    }
}
