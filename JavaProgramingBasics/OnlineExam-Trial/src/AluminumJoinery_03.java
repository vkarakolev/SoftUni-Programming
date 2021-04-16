import java.util.Scanner;

public class AluminumJoinery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int joineryCount = Integer.parseInt(scanner.nextLine());
        String joineryType = scanner.nextLine();
        String delivery = scanner.nextLine();

        int singlePrice = 0;
        double discount = 0;
        double totalPrice = 0;

        if (joineryCount < 10) {
            System.out.println("Invalid order");
        } else {
            switch (joineryType) {
                case "90X130":
                    singlePrice = 110;

                    if (joineryCount > 60) {
                        discount = 0.08;
                    } else if (joineryCount > 30) {
                        discount = 0.05;
                    }

                    break;
                case "100X150":
                    singlePrice = 140;

                    if (joineryCount > 80) {
                        discount = 0.1;
                    } else if (joineryCount > 40) {
                        discount = 0.06;
                    }
                    break;
                case "130X180":
                    singlePrice = 190;

                    if (joineryCount > 50) {
                        discount = 0.12;
                    } else if (joineryCount > 20) {
                        discount = 0.07;
                    }
                    break;
                case "200X300":
                    singlePrice = 250;

                    if (joineryCount > 50) {
                        discount = 0.14;
                    } else if (joineryCount > 25) {
                        discount = 0.09;
                    }
                    break;
            }

            double price = joineryCount * singlePrice;
            totalPrice = price - price * discount;

            if (delivery.equals("With delivery")){
                totalPrice += 60;
            }

            if(joineryCount > 99){
                totalPrice *= 0.96;
            }

            System.out.printf("%.2f BGN", totalPrice);

        }

    }
}
