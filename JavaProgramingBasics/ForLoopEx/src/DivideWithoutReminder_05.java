import java.util.Scanner;

public class DivideWithoutReminder_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;

        for(int i = 0; i < count; i++){
            int num = Integer.parseInt(scanner.nextLine());

            if(num % 2 == 0){
                p1++;
            }
            if(num % 3 == 0){
                p2++;
            }
            if(num % 4 == 0){
                p3++;
            }
        }

        p1 = p1 / count * 100;
        p2 = p2 / count * 100;
        p3 = p3 / count * 100;

        System.out.printf("%.2f%%%n", p1);
        System.out.printf("%.2f%%%n", p2);
        System.out.printf("%.2f%%", p3);
    }
}
