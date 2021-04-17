import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E06_Students2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] studentInfo = input.split("\\s+");

            Student s = new Student(studentInfo[0], studentInfo[1], Integer.parseInt(studentInfo[2]), studentInfo[3]);

            int existingIndex = findStudentIndex(students, s.firstName, s.lastName);
            if (existingIndex != -1) {
                students.get(existingIndex).setHomeTown(s.homeTown);
                students.get(existingIndex).setAge(s.age);
            } else {
                students.add(s);
            }

            input = scanner.nextLine();
        }

        String townForSearch = scanner.nextLine();

        for (Student student : students) {
            if (student.getHomeTown().equals(townForSearch)) {
                System.out.printf("%s %s is %d years old%n",
                        student.getFirstName(), student.getLastName(), student.getAge());
            }
        }

    }

    static int findStudentIndex(List<Student> students, String firstName, String lastNme) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastNme)) {
                return students.indexOf(student);
            }
        }
        return -1;
    }

    static class Student {
        String firstName;
        String lastName;
        int age;
        String homeTown;

        public Student(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public String getHomeTown() {
            return homeTown;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }
    }
}
