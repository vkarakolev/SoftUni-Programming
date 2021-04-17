import java.util.*;

public class E08_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companies = new HashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] inputInfo = command.split(" -> ");
            String companyName = inputInfo[0];
            String currentEmployeeId = inputInfo[1];

            List<String> employeeIDs = companies.get(companyName);
            if (employeeIDs == null) {
                employeeIDs = new ArrayList<>();
                companies.put(companyName, employeeIDs);
            } else {
                if (employeeIDs.contains(currentEmployeeId)) {
                    command = scanner.nextLine();
                    continue;
                }
            }
            employeeIDs.add(currentEmployeeId);
            Collections.sort(employeeIDs);

            command = scanner.nextLine();
        }


        companies.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> {
                    System.out.println(e.getKey());
                    for (String s : e.getValue()) {
                        System.out.println("-- " + s);
                    }
                });
    }
}
