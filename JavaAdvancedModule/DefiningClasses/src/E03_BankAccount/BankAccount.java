package E03_BankAccount;

public class BankAccount {
    private static int accountNextId = 1;
    private static double interestRate = 0.02;

    private  int id;
    private double balance;

    public BankAccount(){
        id = accountNextId;
        accountNextId++;
    }

    public void deposit (double amount) {
        balance += amount;
    }

    public static void setInterestRate (double interestRate){
        BankAccount.interestRate = interestRate;
    }

    public double getInterest (int years){
        return balance * interestRate * years;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }
}
