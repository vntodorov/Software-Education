package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chrysanthemums = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int tulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holiday = scanner.nextLine();
        int flowers = chrysanthemums + roses + tulips;
        double price = 0;
        switch (season) {
            case "Spring":
            case "Summer":
                price = 2 * chrysanthemums + 4.10 * roses + 2.50 * tulips;
                if (season.equals("Spring") && tulips > 7) {
                    price = price - price * 5 / 100;
                }
                if (holiday.equals("Y")) {
                    price = price + price * 15 / 100;
                }
                break;
            case "Autumn":
            case "Winter":
                price = 3.75 * chrysanthemums + 4.50 * roses + 4.15 * tulips;
                if (season.equals("Winter") && roses >= 10) {
                    price = price - price * 10 / 100;
                }
                if (holiday.equals("Y")) {
                    price = price + price * 15 / 100;
                }
                break;
        }
        if (flowers > 20) {
            price = price - price * 20 / 100;
        }
        price = price + 2;
        System.out.printf("%.2f", price);
    }
}
