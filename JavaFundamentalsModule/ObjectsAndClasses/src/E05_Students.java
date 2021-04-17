import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E05_Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String input = scanner.nextLine();
        while(!input.equals("end")){
            String[] studentData = input.split(" ");

            Student s = new Student();
            s.setStudentData(s, studentData[0], studentData[1], Integer.parseInt(studentData[2]), studentData[3]);
            students.add(s);

            input = scanner.nextLine();
        }

        String cityForSearch = scanner.nextLine();
        for (Student student : students) {
            if(student.getHomeTown().equals(cityForSearch)){
                System.out.printf("%s %s is %d years old%n",
                        student.getFirstName(), student.getLastName(), student.getAge());
            }
        }


    }

    static class Student {
        String firstName;
        String lastName;
        int age;
        String homeTown;

        public void setStudentData(Student s, String firstName, String lastName, int age, String homeTown){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getHomeTown(){
            return homeTown;
        }

        public String getFirstName(){
            return firstName;
        }

        public Integer getAge(){
            return age;
        }

        public String getLastName() {
            return lastName;
        }
    }
}
