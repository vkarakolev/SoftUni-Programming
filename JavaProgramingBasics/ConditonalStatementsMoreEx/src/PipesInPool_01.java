import java.util.Scanner;

public class PipesInPool_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int v = Integer.parseInt(input.nextLine());
        int p1 = Integer.parseInt(input.nextLine());
        int p2 = Integer.parseInt(input.nextLine());
        double h = Double.parseDouble(input.nextLine());
        double litersWater = p1 * h + p2 * h;
        double poolFullness = litersWater / v;
        
        if (poolFullness <= 1) {
            poolFullness *= 100;
            double p1percent = (p1 * h / litersWater) * 100;
            double p2percent = (p2 * h / litersWater) * 100;
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.", poolFullness, p1percent, p2percent);
        }else{
            litersWater -= v;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", h, litersWater);
        }
    }
}
