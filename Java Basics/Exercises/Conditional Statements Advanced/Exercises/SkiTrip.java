package ConditionalStatementsAdvanced.exercises;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        String room = scanner.nextLine();
        String mark = scanner.nextLine();
        double RoomFor1 = 18.00;
        double Apartment = 25.00;
        double President = 35.00;
        double nights = days - 1;
        double Price = 0;
        switch (room) {
            case "room for one person":
                Price = nights * RoomFor1;
                break;
            case "apartment":
                Price = nights * Apartment;
                if (days < 10) {
                    Price = Price - Price * 30 / 100;
                } else if (days <= 15) {
                    Price = Price - Price * 35 / 100;
                } else {
                    Price = Price - Price * 50 / 100;
                }
                break;
            case "president apartment":
                Price = nights * President;
                if (days < 10) {
                    Price = Price - Price * 10 / 100;
                } else if (days <= 15) {
                    Price = Price - Price * 15 / 100;
                } else {
                    Price = Price - Price * 20 / 100;
                }
                break;
        }
        if (mark.equals("positive")) {
            Price = Price + Price * 25 / 100;
        } else {
            Price = Price - Price * 10 / 100;
        }
        System.out.printf("%.2f", Price);
    }
}
