import java.util.Scanner;

public class Histogram_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;

        for(int i = 0; i < count; i++){
            int num = Integer.parseInt(scanner.nextLine());

            if(num < 200){
                p1++;
            } else if (num < 400){
                p2++;
            } else if (num < 600){
                p3++;
            } else if (num < 800){
                p4++;
            } else if (num >= 800){
                p5++;
            }
        }
        p1 = p1 / count * 100;
        p2 = p2 / count * 100;
        p3 = p3 / count * 100;
        p4 = p4 / count * 100;
        p5 = p5 / count * 100;

        System.out.printf("%.2f%%%n", p1);
        System.out.printf("%.2f%%%n", p2);
        System.out.printf("%.2f%%%n", p3);
        System.out.printf("%.2f%%%n", p4);
        System.out.printf("%.2f%%", p5);
    }
}
