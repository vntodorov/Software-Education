package ConditionalStatementsAdvanced.exercises;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String continent = "";
        String place = "";
        double price = 0;
        switch (season) {
            case "summer":
                if (budget <= 100) {
                    price = budget * 30 / 100;
                    continent = "Bulgaria";
                    place = "Camp";
                } else if (budget <= 1000) {
                    price = budget * 40 / 100;
                    continent = "Balkans";
                    place = "Camp";
                } else {
                    price = budget * 90 / 100;
                    continent = "Europe";
                    place = "Hotel";
                }
                break;
            case "winter":
                if (budget <= 100) {
                    price = budget * 70 / 100;
                    continent = "Bulgaria";
                    place = "Hotel";
                } else if (budget <= 1000) {
                    price = budget * 80 / 100;
                    continent = "Balkans";
                    place = "Hotel";
                } else {
                    price = budget * 90 / 100;
                    continent = "Europe";
                    place = "Hotel";
                }
                break;
        }
        System.out.printf("Somewhere in %s%n", continent);
        System.out.printf("%s - %.2f", place, price);
    }
}
