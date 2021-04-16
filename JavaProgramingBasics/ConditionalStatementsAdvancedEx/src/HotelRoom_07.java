import java.util.Scanner;

public class HotelRoom_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());
        double apartmentPrice = 0;
        double studioPrice = 0;

        switch(month){
            case "May":
            case "October":
                    studioPrice = 50;
                    apartmentPrice = 65;

                if(nights > 7 && nights <= 14){
                    studioPrice *= 0.95;
                }else if (nights > 14){
                    studioPrice *= 0.7;
                }
                break;
            case "June":
            case "September":
                studioPrice = 75.20;
                apartmentPrice = 68.70;

                if (nights > 14){
                    studioPrice *= 0.8;
                }
                break;
            case "July":
            case "August":
                studioPrice = 76;
                apartmentPrice = 77;
                break;
        }

        if(nights > 14){
            apartmentPrice *= 0.9;
        }

        studioPrice *= nights;
        apartmentPrice *= nights;

        System.out.printf("Apartment: %.2f lv.%nStudio: %.2f lv.", apartmentPrice, studioPrice);
    }
}
