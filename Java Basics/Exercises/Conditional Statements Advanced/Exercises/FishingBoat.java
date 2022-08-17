package ConditionalStatementsAdvanced.exercises;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishers = Integer.parseInt(scanner.nextLine());
        double price = 0;
        double SpringPrice = 3000;
        double SummerAutumnPrice = 4200;
        double WinterPrice = 2600;
        switch (season) {
            case "Spring":
                price = SpringPrice - SpringPrice * 10 / 100.00;
                if (fishers >= 7 && fishers <= 11) {
                    price = SpringPrice - SpringPrice * 15 / 100.00;
                } else if (fishers >= 12){
                    price = SpringPrice - SpringPrice * 25 / 100.00;
                }
                break;
            case "Summer":
            case "Autumn":
                price = SummerAutumnPrice - SummerAutumnPrice * 10 / 100;
                if (fishers >= 7 && fishers <= 11) {
                    price = SummerAutumnPrice - SummerAutumnPrice * 15 / 100.00;
                } else if (fishers >= 12) {
                    price = SummerAutumnPrice - SummerAutumnPrice * 25 / 100.00;
                }
                break;
            case "Winter":
                price = WinterPrice - WinterPrice * 10 / 100;
                if (fishers >= 7 && fishers <= 11) {
                    price = WinterPrice - WinterPrice * 15 / 100.00;
                } else if (fishers >= 12) {
                    price = WinterPrice - WinterPrice * 25 / 100.00;
                }
                break;
        }
        if (fishers % 2 == 0 && !season.equals("Autumn")) {
            price = price - price * 5 / 100;
        }
        if (budget >= price) {
            System.out.printf("Yes! You have %.2f leva left.", budget - price);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", price - budget);
        }
    }
}
