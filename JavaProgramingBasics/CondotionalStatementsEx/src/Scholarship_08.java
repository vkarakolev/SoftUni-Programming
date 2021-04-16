import java.util.Scanner;

public class Scholarship_08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double income = Double.parseDouble(input.nextLine());
        double avgGrade = Double.parseDouble(input.nextLine());
        double minimumSalary = Double.parseDouble(input.nextLine());
        double socialScholarship = 0;
        double gradeScholarship = 0;

        if (avgGrade <= 4.5) {
            System.out.println("You cannot get a scholarship!");
        } else if (avgGrade > 4.5 && avgGrade < 5.5 && income > minimumSalary){
            System.out.println("You cannot get a scholarship!");
        } else if (avgGrade > 4.5 && income < minimumSalary){
            socialScholarship = minimumSalary * 0.35;
            if (avgGrade >= 5.5){
                gradeScholarship = avgGrade * 25;
            }
            if (socialScholarship > gradeScholarship){
                System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialScholarship));
            } else {
                System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(gradeScholarship));
            }
        } else if (avgGrade >= 5.5){
            gradeScholarship = avgGrade * 25;
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(gradeScholarship));
        }
    }
}
