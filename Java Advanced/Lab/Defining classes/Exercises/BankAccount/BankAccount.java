package DefiningClassesLAB.BankAccount;

public class BankAccount {

    private static int nextId = 1;
    private static double interestRate = 0.02;

    private int id;

    private double balance;

    public BankAccount() {
        this.id = nextId;
        nextId++;
    }

    public int getId(){
        return this.id;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;

    }

    public double getInterest(int years) {

        return BankAccount.interestRate * years * this.balance;


    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
