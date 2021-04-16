import java.util.Scanner;

public class Revision {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //1. променлива за доларите
        //2. 1 usd = 1.79549 BGN
        //3. променлива за бг лева = долари * курс
        //4. принтираме резултат
        double usd = Double.parseDouble(input.nextLine());
        double bgn = usd * 1.79549;
        System.out.println(bgn);


    }
}
