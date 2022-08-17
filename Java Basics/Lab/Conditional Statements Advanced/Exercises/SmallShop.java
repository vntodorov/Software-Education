package ConditionalStatementsAdvanced.lab;

import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        switch (city) {
            case "Sofia":
                if (product.equals("coffee")) {
                    System.out.printf("%f", 0.50 * quantity);
                } else if (product.equals("water")) {
                    System.out.printf("%f", 0.80 * quantity);
                } else if (product.equals("beer")) {
                    System.out.printf("%f", 1.20 * quantity);
                } else if (product.equals("sweets")) {
                    System.out.printf("%f", 1.45 * quantity);
                } else if (product.equals("peanuts")) {
                    System.out.printf("%f", 1.60 * quantity);
                }
                break;
            case "Plovdiv":
                if (product.equals("coffee")) {
                    System.out.printf("%f", 0.40 * quantity);
                } else if (product.equals("water")) {
                    System.out.printf("%f", 0.70 * quantity);
                } else if (product.equals("beer")) {
                    System.out.printf("%f", 1.15 * quantity);
                } else if (product.equals("sweets")) {
                    System.out.printf("%f", 1.30 * quantity);
                } else if (product.equals("peanuts")) {
                    System.out.printf("%f", 1.50 * quantity);
                }
                break;
            case "Varna":
                if (product.equals("coffee")) {
                    System.out.printf("%f", 0.45 * quantity);
                } else if (product.equals("water")) {
                    System.out.printf("%f", 0.70 * quantity);
                } else if (product.equals("beer")) {
                    System.out.printf("%f", 1.10 * quantity);
                } else if (product.equals("sweets")) {
                    System.out.printf("%f", 1.35 * quantity);
                } else if (product.equals("peanuts")) {
                    System.out.printf("%f", 1.55 * quantity);
                }
                break;
        }
    }
}
