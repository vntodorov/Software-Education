package WhileLoop.exercises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double NeededMoney = Double.parseDouble(scanner.nextLine());
        double InStockMoney = Double.parseDouble(scanner.nextLine());
        boolean isSaved = true;
        int FollowingSpendDays = 0;
        int days = 0;
        while (InStockMoney < NeededMoney) {
            String Action = scanner.nextLine();
            double sum = Double.parseDouble(scanner.nextLine());
            days++;
            if (Action.equals("save")) {
                FollowingSpendDays = 0;
                InStockMoney += sum;
            } else {
                InStockMoney -= sum;
                FollowingSpendDays++;
                if (sum > InStockMoney) {
                    InStockMoney = 0;
                }
                if (FollowingSpendDays == 5) {
                    isSaved = false;
                    break;
                }
            }
        }
        if (isSaved) {
            System.out.printf("You saved the money for %d days.", days);
        } else {
            System.out.printf("You can't save the money.%n");
            System.out.printf("%d", days);
        }
    }
}
