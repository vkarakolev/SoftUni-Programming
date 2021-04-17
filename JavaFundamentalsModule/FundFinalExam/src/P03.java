import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> distributors = new HashMap<>();
        Map<String, Double> clients = new HashMap<>();
        Double totalIncome = 0.0;

        String command = scanner.nextLine();
        while(!command.equals("End")){
            String[] operations = command.split("\\s+");
            String name = operations[1];
            double money = Double.parseDouble(operations[2]);

            switch (operations[0]){
                case "Deliver":
                    if(!distributors.containsKey(name)){
                        distributors.put(name, money);
                    } else {
                        double currentCost = distributors.get(name) + money;
                        distributors.put(name, currentCost);
                    }
                    break;
                case "Return":
                    if(!distributors.containsKey(name) || distributors.get(name) < money){
                        break;
                    }

                    double currentCost = distributors.get(name) - money;
                    distributors.put(name, currentCost);
                    if(distributors.get(name) == 0){
                        distributors.remove(name);
                    }

                    break;
                case "Sell":
                    totalIncome += money;
                    if(!clients.containsKey(name)){
                        clients.put(name, money);
                    } else {
                        double currentMoneySpent = clients.get(name) + money;
                        clients.put(name, currentMoneySpent);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        clients.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> String.format("%s: %.2f", e.getKey(), e.getValue()))
                .forEach(System.out::println);

        System.out.println("-----------");

        distributors.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> String.format("%s: %.2f", e.getKey(), e.getValue()))
                .forEach(System.out::println);

        System.out.println("-----------");
        System.out.printf("Total Income: %.2f", totalIncome);
    }
}
