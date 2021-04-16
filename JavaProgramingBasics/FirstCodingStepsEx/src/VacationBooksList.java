import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //1. прочитаме входни данни и ги съхраняваме в променливи
        //2. за колко часа ще прочете книгата = бр. стр / стр. на час
        //3. колко часа на ден = за колко часа трябва да я прочете / дни
        //4. печатаме дни
        int bookPages = Integer.parseInt(input.nextLine());
        int pagesPerHour = Integer.parseInt(input.nextLine());
        int daysToRead = Integer.parseInt(input.nextLine());

        int hoursToRead = bookPages / pagesPerHour; // общ брой часове
        int hoursPerDay = hoursToRead / daysToRead; // часове на ден
        System.out.println(hoursPerDay);
    }
}
