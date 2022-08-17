package WhileLoop;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int NeededSum = Integer.parseInt(scanner.nextLine());
        String price = scanner.nextLine();
        int circle = 0;
        double AllSum = 0;
        double AllCardPayments = 0;
        double AllCashPayments = 0;
        int CashPayments = 0;
        int CardPayments = 0;
        while (!price.equals("End")) {
            circle++;
            int PriceSum = Integer.parseInt(price);
            if (circle % 2 == 0 && PriceSum >= 10) {
                System.out.println("Product sold!");
                AllCardPayments += PriceSum;
                CardPayments++;
            } else if (circle % 2 != 0 && PriceSum <= 100) {
                System.out.println("Product sold!");
                AllCashPayments += PriceSum;
                CashPayments++;
            } else {
                System.out.println("Error in transaction!");
            }
            AllSum = AllCardPayments + AllCashPayments;
            if (AllSum >= NeededSum) {
                break;
            }
            price = scanner.nextLine();
        }
        double AverageCash = AllCashPayments / CashPayments;
        double AverageCard = AllCardPayments / CardPayments;
        if (AllSum >= NeededSum) {
            System.out.printf("Average CS: %.2f%n", AverageCash);
            System.out.printf("Average CC: %.2f", AverageCard);
        } else {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}

