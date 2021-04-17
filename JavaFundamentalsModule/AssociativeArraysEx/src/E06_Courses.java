import java.util.*;


public class E06_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();
        String command = scanner.nextLine();

        while(!command.equals("end")){
            String[] studentInfo = command.split(" : ");
            String course = studentInfo[0];
            String studentName = studentInfo[1];

            List<String> students = courses.get(course);
            if(students == null){
                students = new ArrayList<>();
                courses.put(course, students);
            }
            students.add(studentName);
            Collections.sort(students);

            command = scanner.nextLine();
        }

        courses.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size())
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    for (String s : e.getValue()) {
                        System.out.println("-- " + s);
                    }
                });
    }
}
