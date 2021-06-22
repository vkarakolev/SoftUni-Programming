package E02_CompanyRoster;

import java.util.List;

public class Department {
    private String name;
    private List<Employee> departmentEmployees;

    public Department() {
    }

    public Department(String name, List<Employee> departmentEmployees) {
        this.name = name;
        this.departmentEmployees = departmentEmployees;
    }

    public List<Employee> getDepartmentEmployees() {
        return departmentEmployees;
    }

    public String getName() {
        return name;
    }
}
