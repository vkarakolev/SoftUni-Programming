import java.util.Scanner;

public class E08_BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String biggestKegModel = "";
        double biggestKegCapacity = 0;

        for (int i = 0; i < n; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double kegCapacity = Math.PI * radius * radius * height;
            if (kegCapacity > biggestKegCapacity){
                biggestKegCapacity = kegCapacity;
                biggestKegModel = model;
            }
        }
        System.out.println(biggestKegModel);

    }
}
