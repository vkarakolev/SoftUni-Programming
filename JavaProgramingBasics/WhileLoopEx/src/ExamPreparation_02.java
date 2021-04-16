import java.util.Scanner;

public class ExamPreparation_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int badGrades = Integer.parseInt(scanner.nextLine());
        int allGrades = 0;
        int gradeCount = 0;
        double avgGrade = 0;
        int problemCount = 0;
        String lastProblem = null;
        int badGradesCount = 0;

        while(true){
            String problem = scanner.nextLine();
            if(problem.equals("Enough")){
                System.out.printf("Average score: %.2f%n", avgGrade);
                System.out.printf("Number of problems: %d%n", problemCount);
                System.out.printf("Last problem: %s", lastProblem);
                break;
            }

            int grade = Integer.parseInt(scanner.nextLine());
            if(grade <= 4){
                badGradesCount++;
                if(badGradesCount == badGrades){
                    System.out.printf("You need a break, %d poor grades.", badGradesCount);
                    break;
                }
            }
            allGrades += grade;
            gradeCount++;
            problemCount++;
            lastProblem = problem;

            avgGrade = allGrades * 1.0 / gradeCount ;

        }


    }
}
