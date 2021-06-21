package E03_BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Create" :
                    BankAccount bankAccount = new BankAccount();
                    accounts.put(bankAccount.getId(), bankAccount);
                    System.out.printf("Account ID%d created%n", bankAccount.getId());
                    break;
                case "Deposit" :
                    int id = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);

                    bankAccount = accounts.get(id);
                    String output = executeIfNotNull(bankAccount, b -> {
                        b.deposit(amount);
                        return String.format("Deposited %.0f to ID%d", amount, id);
                    });

                    System.out.println(output);
                    break;
                case "SetInterest" :
                    BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
                    break;
                case "GetInterest" :
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    bankAccount = accounts.get(id);
                    output = executeIfNotNull(bankAccount, b -> {
                        double interest = b.getInterest(years);
                        return String.format("%.2f", interest);
                    });

                    System.out.println(output);
                    break;
            }

            input = scanner.nextLine();
        }
    }

    public static String executeIfNotNull (BankAccount account, Function<BankAccount, String> function){
        if(account == null){
            return "Account does not exist";
        }

        return function.apply(account);
    }
}
