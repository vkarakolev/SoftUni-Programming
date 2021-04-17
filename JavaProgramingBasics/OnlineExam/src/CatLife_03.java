import java.util.Scanner;

public class CatLife_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String breed = scanner.nextLine();
        String sex = scanner.nextLine();
        int lifeInYears = 0;

        switch (breed) {
            case "British Shorthair":
                if (sex.equals("m")) {
                    lifeInYears = 13;
                } else if (sex.equals("f")) {
                    lifeInYears = 14;
                }
                break;
            case "Siamese":
                if (sex.equals("m")) {
                    lifeInYears = 15;
                } else if (sex.equals("f")) {
                    lifeInYears = 16;
                }
                break;
            case "Persian":
                if (sex.equals("m")) {
                    lifeInYears = 14;
                } else if (sex.equals("f")) {
                    lifeInYears = 15;
                }
                break;
            case "Ragdoll":
                if (sex.equals("m")) {
                    lifeInYears = 16;
                } else if (sex.equals("f")) {
                    lifeInYears = 17;
                }
                break;
            case "American Shorthair":
                if (sex.equals("m")) {
                    lifeInYears = 12;
                } else if (sex.equals("f")) {
                    lifeInYears = 13;
                }
                break;
            case "Siberian":
                if (sex.equals("m")) {
                    lifeInYears = 11;
                } else if (sex.equals("f")) {
                    lifeInYears = 12;
                }
                break;
            default:
                System.out.printf("%s is invalid cat!", breed);
                break;
        }
        int lifeInCatMonths = lifeInYears * 2;
        if (lifeInCatMonths > 0) {
            System.out.printf("%d cat months", lifeInCatMonths);
        }
    }
}
