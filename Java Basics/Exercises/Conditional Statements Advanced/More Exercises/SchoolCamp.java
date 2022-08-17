package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String season = scanner.nextLine();
        String group = scanner.nextLine();
        int students = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        String sport = "";
        double price = 0;
        switch (season) {
            case "Spring":
                if (group.equals("boys") || group.equals("girls")) {
                    price = students * nights * 7.20;
                } else {
                    price = students * nights * 9.50;
                }
                if (group.equals("boys")) {
                    sport = "Tennis";
                } else if (group.equals("girls")) {
                    sport = "Athletics";
                } else {
                    sport = "Cycling";
                }
                break;
            case "Summer":
                if (group.equals("boys") || group.equals("girls")) {
                    price = students * nights * 15;
                } else {
                    price = students * nights * 20;
                }
                if (group.equals("boys")) {
                    sport = "Football";
                } else if (group.equals("girls")) {
                    sport = "Volleyball";
                } else {
                    sport = "Swimming";
                }
                break;
            case "Winter":
                if (group.equals("boys") || group.equals("girls")) {
                    price = students * nights * 9.60;
                } else {
                    price = students * nights * 10;
                }
                if (group.equals("boys")) {
                    sport = "Judo";
                } else if (group.equals("girls")) {
                    sport = "Gymnastics";
                } else {
                    sport = "Ski";
                }
                break;
        }
        if (students >= 10 && students < 20) {
            price = price - price * 5 / 100;
        } else if (students >= 20 && students < 50) {
            price = price - price * 15 / 100;
        } else if (students >= 50) {
            price = price - price * 50 / 100;
        }
        System.out.printf("%s %.2f lv.", sport, price);
    }
}
