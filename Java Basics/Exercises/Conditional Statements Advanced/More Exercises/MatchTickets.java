package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());
        double vip = 499.99;
        double normal = 249.99;
        double transport = 0;
        double price = 0;
        if (people <= 4) {
            transport = budget * 75 / 100;
        } else if (people <= 9) {
            transport = budget * 60 / 100;
        } else if (people <= 24) {
            transport = budget * 50 / 100;
        } else if (people <= 49) {
            transport = budget * 40 / 100;
        } else {
            transport = budget * 25 / 100;
        }
        switch (category) {
            case "Normal":
                price = people * normal + transport;
                break;
            case "VIP":
                price = people * vip + transport;
                break;
        }
        double left = Math.abs(price - budget);
        if (budget >= price) {
            System.out.printf("Yes! You have %.2f leva left.", left);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", left);
        }
    }
}
