import java.util.*;

public class E05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, ArrayList<Double>> studentsAndGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] studentData = scanner.nextLine().split("\\s+");
            String name = studentData[0];
            double grade = Double.parseDouble(studentData[1]);

            if(studentsAndGrades.get(name) == null){
                ArrayList<Double> grades = new ArrayList<>();
                grades.add(grade);
                studentsAndGrades.put(name, grades);
            } else {
                studentsAndGrades.get(name).add(grade);
            }
        }

        printOutput(studentsAndGrades);
    }

    private static void printOutput (TreeMap<String, ArrayList<Double>> map){
        for (Map.Entry<String, ArrayList<Double>> entry : map.entrySet()) {

            StringBuilder output = new StringBuilder();
            output.append(entry.getKey()).append(" -> ");

            for (Double value : entry.getValue()) {
                output.append(String.format("%.2f ", value));
            }

            output.append("(avg: ").append(String.format("%.2f)", calculateAvg(entry.getValue())));

            System.out.println(output);
        }
    }

    private static double calculateAvg(ArrayList<Double> list) {
        return list.stream().mapToDouble(d -> d).average().orElse(0.00);
    }
}
