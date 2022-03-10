package E03_UniversitySystem.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "e03_students")
public class Student extends Person {

    @Column(name = "average_grade", nullable = false)
    private double averageGrade;

    private int attendance;

    @ManyToMany
    @JoinTable(name = "e03_students_courses",
    joinColumns = @JoinColumn(name = "stident_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private Set<Course> courses;

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, String phoneNumber, double averageGrade, int attendance) {
        super(firstName, lastName, phoneNumber);

        this.averageGrade = averageGrade;
        this.attendance = attendance;
        this.courses = new HashSet<>();
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }
}
