package E03_StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private final Map<String, Student> studentsByName;

    public StudentRepository() {
        this.studentsByName = new HashMap<>();
    }

    public void add(Student student) {
        this.studentsByName.put(student.getName(), student);
    }

    public Student get(String name) {
        return this.studentsByName.get(name);
    }

    public boolean contains(String name) {
        return studentsByName.containsKey(name);
    }
}
