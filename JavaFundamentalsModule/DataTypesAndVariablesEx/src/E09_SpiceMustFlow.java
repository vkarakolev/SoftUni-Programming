import java.util.Scanner;

public class E09_SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int totalYield = 0;

        while(startingYield >= 100){
            totalYield += (startingYield - 26);
            startingYield -= 10;
            days++;
        }

        if(totalYield > 26) {
            totalYield -= 26;
        }

        System.out.println(days);
        System.out.println(totalYield);
    }
}
