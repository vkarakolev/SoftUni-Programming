import java.util.Scanner;

public class TrainTheTrainers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countJury = Integer.parseInt(scanner.nextLine());
        double sumGradeAllPresentations = 0;
        int countGrades = 0;

        while (true){
            String presentation = scanner.nextLine();
            if (presentation.equals("Finish")){
                break;
            }

            double sumGradePerPresentation = 0;
            for(int jury = 1; jury <= countJury; jury++){
                double grade = Double.parseDouble(scanner.nextLine());
                sumGradePerPresentation += grade;
                sumGradeAllPresentations += grade;
                countGrades++;
            }
            double avgPerPresentation = sumGradePerPresentation / countJury;
            System.out.printf("%s - %.2f.%n", presentation, avgPerPresentation);
        }

        double avgForAll = sumGradeAllPresentations / countGrades;
        System.out.printf("Student's final assessment is %.2f.", avgForAll);
    }
}
