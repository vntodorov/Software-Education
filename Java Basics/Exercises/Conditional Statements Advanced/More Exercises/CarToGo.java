package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String classic = "";
        String car = "";
        double price = 0;
        if (budget <= 100) {
            classic = "Economy class";
        } else if (budget <= 500) {
            classic = "Compact class";
        } else {
            classic = "Luxury class";
        }
        switch (season) {
            case "Summer":
                if (classic.equals("Economy class")) {
                    car = "Cabrio";
                    price = budget * 35 / 100;
                } else if (classic.equals("Compact class")) {
                    car = "Cabrio";
                    price = budget * 45 / 100;
                } else {
                    car = "Jeep";
                    price = budget * 90 / 100;
                }
                break;
            case "Winter":
                car = "Jeep";
                if (classic.equals("Economy class")) {
                    price = budget * 65 / 100;
                } else if (classic.equals("Compact class")) {
                    price = budget * 80 / 100;
                } else {
                    price = budget * 90 / 100;
                }
                break;
        }
        System.out.printf("%s%n", classic);
        System.out.printf("%s - %.2f", car, price);
    }
}
