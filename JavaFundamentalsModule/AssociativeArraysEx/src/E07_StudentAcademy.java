import java.util.*;

public class E07_StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentData = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            double currentGrade = Double.parseDouble(scanner.nextLine());

            List<Double> grades = studentData.computeIfAbsent(studentName, k -> new ArrayList<>());
            studentData.put(studentName, grades);
            grades.add(currentGrade);
        }

        studentData.entrySet().stream()
                .filter(e -> e.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.5)
                .sorted((e1, e2) -> {
                    double e1Av = e1.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double e2Av = e2.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    return Double.compare(e2Av, e1Av);
                })
                .forEach(e -> {
                    double avg = e.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    System.out.printf("%s -> %.2f%n", e.getKey(), avg);
                });
    }
}
