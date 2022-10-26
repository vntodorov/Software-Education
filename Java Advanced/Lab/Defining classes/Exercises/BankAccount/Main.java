package DefiningClassesLAB.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!command.equals("End")){

            String currentCommand = command.split("\\s+")[0];

            switch (currentCommand){
                case "Create":
                    BankAccount currentAccount = new BankAccount();
                    bankAccounts.put(currentAccount.getId(), currentAccount);
                    System.out.printf("Account ID%d created%n", currentAccount.getId());
                    break;
                case "Deposit":
                    int currentDepositId = Integer.parseInt(command.split("\\s+")[1]);
                    double amount = Double.parseDouble(command.split("\\s+")[2]);

                    if (bankAccounts.containsKey(currentDepositId)){
                        BankAccount currentBankAccount = bankAccounts.get(currentDepositId);
                        currentBankAccount.deposit(amount);
                        bankAccounts.put(currentDepositId, currentBankAccount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, currentDepositId);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(command.split("\\s+")[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int currentInterestId = Integer.parseInt(command.split("\\s+")[1]);
                    int years = Integer.parseInt(command.split("\\s+")[2]);
                    if (bankAccounts.containsKey(currentInterestId)){
                        BankAccount currentBankAccount = bankAccounts.get(currentInterestId);
                        System.out.printf("%.2f%n",currentBankAccount.getInterest(years));
                    } else {
                        System.out.println("Account does not exist");

                    }
                    break;

            }
            command = scanner.nextLine();
        }
    }
}
