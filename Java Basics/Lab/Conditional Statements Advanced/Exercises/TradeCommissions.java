package ConditionalStatementsAdvanced.lab;

import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        double profit = Double.parseDouble(scanner.nextLine());
        double commission = 0;
        if (profit >= 0 && profit <= 500) {
            switch (city) {
                case "Sofia":
                    commission = 5;
                    System.out.printf("%.2f", profit * (commission / 100));
                    break;
                case "Varna":
                    commission = 4.5;
                    System.out.printf("%.2f", profit * (commission / 100));
                    break;
                case "Plovdiv":
                    commission = 5.5;
                    System.out.printf("%.2f", profit * (commission / 100));
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (profit > 500 && profit <= 1000) {
            switch (city) {
                case "Sofia":
                    commission = 7;
                    System.out.printf("%.2f", profit * (commission / 100));
                    break;
                case "Varna":
                    commission = 7.5;
                    System.out.printf("%.2f", profit * (commission / 100));
                    break;
                case "Plovdiv":
                    commission = 8;
                    System.out.printf("%.2f", profit * (commission / 100));
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (profit > 1000 && profit <= 10000) {
            switch (city) {
                case "Sofia":
                    commission = 8;
                    System.out.printf("%.2f", profit * (commission / 100));
                    break;
                case "Varna":
                    commission = 10;
                    System.out.printf("%.2f", profit * (commission / 100));
                    break;
                case "Plovdiv":
                    commission = 12;
                    System.out.printf("%.2f", profit * (commission / 100));
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (profit > 10000) {
            switch (city) {
                case "Sofia":
                    commission = 12;
                    System.out.printf("%.2f", profit * (commission / 100));
                    break;
                case "Varna":
                    commission = 13;
                    System.out.printf("%.2f", profit * (commission / 100));
                    break;
                case "Plovdiv":
                    commission = 14.5;
                    System.out.printf("%.2f", profit * (commission / 100));
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else {
            System.out.println("error");
        }
    }
}