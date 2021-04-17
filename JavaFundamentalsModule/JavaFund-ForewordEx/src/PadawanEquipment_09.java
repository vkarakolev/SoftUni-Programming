import java.util.Scanner;

public class PadawanEquipment_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = scanner.nextDouble();
        int studentsCount = scanner.nextInt();
        double lightsabersPrice = scanner.nextDouble();
        double robesPrice = scanner.nextDouble();
        double beltsPrice = scanner.nextDouble();

        double lightSabersCount = Math.ceil(studentsCount * 1.1);
        int beltsCount = studentsCount - studentsCount / 6;

        double bill = lightsabersPrice * lightSabersCount +
                robesPrice * studentsCount + beltsCount * beltsPrice;

        if (bill <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", bill);
        } else {
            double moneyLack = bill - money;
            System.out.printf("Ivan Cho will need %.2flv more.", moneyLack);
        }
    }
}
