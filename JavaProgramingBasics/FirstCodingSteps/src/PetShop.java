import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dogs = Integer.parseInt(input.nextLine());
        int otherPets = Integer.parseInt(input.nextLine());
        System.out.println(dogs * 2.5 + otherPets * 4 + " lv.");
    }
}
