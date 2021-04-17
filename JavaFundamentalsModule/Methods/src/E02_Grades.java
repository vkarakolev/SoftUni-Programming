import java.util.Scanner;

public class E02_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());;
        printInWords(grade);
    }

    static void printInWords(Double inputGrade){
        String result;
        if(inputGrade < 3){
            result = "Fail";
        } else if (inputGrade < 3.5){
            result = "Poor";
        } else if (inputGrade < 4.5){
            result = "Good";
        } else if (inputGrade < 5.5){
            result = "Very good";
        } else {
            result = "Excellent";
        }
        System.out.println(result);
    }
}
