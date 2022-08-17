package ConditionalStatements;

import java.util.Scanner;

public class FuelTankPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fuel = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        String card = scanner.nextLine();
        double price = 0;
        if (fuel.equals("Gasoline")) {
            if (card.equals("Yes")) {
                price = (quantity * 2.22) - (quantity * 0.18);
            } else {
                price = (quantity * 2.22);
            }
            if (quantity < 20) {
                System.out.printf("%.2f lv.", price);
            } else if (quantity <= 25) {
                System.out.printf("%.2f lv.", price - price * 8 / 100);
            } else {
                System.out.printf("%.2f lv.", price - price * 10 / 100);
            }
        }
        if (fuel.equals("Diesel")) {
            if (card.equals("Yes")) {
                price = (quantity * 2.33) - (quantity * 0.12);
            } else {
                price = (quantity * 2.33);
            }
            if (quantity < 20) {
                System.out.printf("%.2f lv.", price);
            } else if (quantity <= 25) {
                System.out.printf("%.2f lv.", price - price * 8 / 100);
            } else {
                System.out.printf("%.2f lv.", price - price * 10 / 100);
            }
        }
        if (fuel.equals("Gas")) {
            if (card.equals("Yes")) {
                price = (quantity * 0.93) - (quantity * 0.08);
            } else {
                price = (quantity * 0.93);
            }
            if (quantity < 20) {
                System.out.printf("%.2f lv.", price);
            } else if (quantity <= 25) {
                System.out.printf("%.2f lv.", price - price * 8 / 100);
            } else {
                System.out.printf("%.2f lv.", price - price * 10 / 100);
            }
        }
    }
}
