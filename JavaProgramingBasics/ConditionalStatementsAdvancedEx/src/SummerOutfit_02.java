import java.util.Scanner;

public class SummerOutfit_02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int degrees = Integer.parseInt(input.nextLine());
        String time = input.nextLine();
        String outfit = null;
        String shoes = null;

        switch (time) {
            case "Morning":
                if (degrees >= 10 && degrees <= 18) {
                    outfit = "Sweatshirt";
                    shoes = "Sneakers";
                    break;
                } else if (degrees > 18 && degrees <= 24) {
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                } else if (degrees >= 25){
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    break;
                }
            case "Afternoon":
                if (degrees >= 10 && degrees <= 18) {
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                } else if (degrees > 18 && degrees <= 24) {
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    break;
                } else if (degrees >= 25){
                    outfit = "Swim Suit";
                    shoes = "Barefoot";
                    break;
                }
            case "Evening":
                if (degrees >= 10 && degrees <= 18) {
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                } else if (degrees > 18 && degrees <= 24) {
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                } else if (degrees >= 25){
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                }
        }
        System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);
    }
}
