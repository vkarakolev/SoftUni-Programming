package E03_UniversitySystem.Entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "e03_teachers")
public class Teacher extends Person {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private BigDecimal salary;

    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;

    public Teacher() {
        super();
    }

    public Teacher(String firstName, String lastName, String phoneNumber, String email, BigDecimal salary) {
        super(firstName, lastName, phoneNumber);

        this.email = email;
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
