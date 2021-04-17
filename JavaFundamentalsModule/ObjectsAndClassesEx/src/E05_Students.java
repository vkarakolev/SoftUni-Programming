import java.util.*;

public class E05_Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCount = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < studentCount; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");

            Student student = new Student(inputLine);
            students.add(student);
        }

        Collections.sort(students, Collections.reverseOrder(Comparator.comparing(Student::getGrade)));

        for (Student student : students) {
            System.out.println(student.toString(student));
        }

    }

    static class Student{
        String firstName;
        String lastName;
        double grade;

        public Student(String[] inputLine){
            this.firstName = inputLine[0];
            this.lastName = inputLine[1];
            this.grade = Double.parseDouble(inputLine[2]);
        }

        public double getGrade() {
            return grade;
        }

        static String toString(Student student){
            String output = String.format("%s %s: %.2f", student.firstName, student.lastName, student.grade);
            return output;
        }
    }
}
