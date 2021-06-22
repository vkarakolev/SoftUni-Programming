package E02_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departments = new HashMap<>();

        while (n-- > 0){
            String[] personData = scanner.nextLine().split("\\s+");
            Employee employee = createEmployeeByDataLength(personData);
            String departmentName = employee.getDepartment();

            Department department = new Department(departmentName, new ArrayList<>());
            departments.putIfAbsent(departmentName, department);
            departments.get(departmentName).getDepartmentEmployees().add(employee);
        }

        Department bestDepartment = getBestDepartment(departments);

        System.out.println("Highest Average Salary: " + bestDepartment.getName());
        bestDepartment.getDepartmentEmployees()
                .stream()
                .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                .map(Employee::toString)
                .forEach(System.out::println);
    }

    public static Department getBestDepartment (Map<String, Department> departments) {
        Department bestDepartment = new Department();
        double bestAvgSalary = Double.MIN_VALUE;

        for (var entry : departments.entrySet()) {
            double currentAvgSalary = getAvgSalary(entry.getValue().getDepartmentEmployees());
            if(bestAvgSalary < currentAvgSalary){
                bestAvgSalary = currentAvgSalary;
                bestDepartment = entry.getValue();
            }
        }

        return bestDepartment;
    }

    public static double getAvgSalary (List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    public static Employee createEmployeeByDataLength (String[] data){
        Employee employee;
        if(data.length == 6) {
            employee = new Employee(data[0], Double.parseDouble(data[1]), data[2],
                    data[3], data[4], Integer.parseInt(data[5]));
        } else if (data.length == 4) {
            employee = new Employee(data[0], Double.parseDouble(data[1]), data[2],
                    data[3]);
        } else {
            if(Character.isLetter(data[4].charAt(0))){
                employee = new Employee(data[0], Double.parseDouble(data[1]), data[2],
                        data[3], data[4]);
            } else {
                employee = new Employee(data[0], Double.parseDouble(data[1]), data[2],
                        data[3], Integer.parseInt(data[4]));
            }
        }

        return employee;
    }
}
