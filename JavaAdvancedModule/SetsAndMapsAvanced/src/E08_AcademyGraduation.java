import java.util.*;

public class E08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, double[]> students = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = readArray(scanner.nextLine());
            students.put(name, grades);
        }

        printOutput(students);
    }

    private static void printOutput(TreeMap<String, double[]> map) {
        for (var entry : map.entrySet()) {
            String name = entry.getKey();
            double avgGrade = getAvg(entry.getValue());

            StringBuilder output = new StringBuilder();
            output.append(name).append(" is graduated with ").append(avgGrade);
            System.out.println(output);
        }
    }

    private static double getAvg(double[] array) {
        return Arrays.stream(array).average().orElse(0.00);
    }

    private static double[] readArray(String line) {
        return Arrays.stream(line.split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}
