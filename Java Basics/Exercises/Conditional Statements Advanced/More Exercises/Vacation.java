package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String location = "";
        String place = "";
        double price = 0;
        if (budget <= 1000){
            place = "Camp";
        } else if (budget <= 3000){
            place = "Hut";
        } else {
            place = "Hotel";
        }
        switch (season){
            case "Summer":
                location = "Alaska";
                if (place.equals("Camp")){
                    price = budget * 65 / 100;
                } else if (place.equals("Hut")){
                    price = budget * 80 / 100;
                } else {
                    price = budget * 90 / 100;
                }
                break;
            case "Winter":
                location = "Morocco";
                if (place.equals("Camp")){
                    price = budget * 45 / 100;
                } else if (place.equals("Hut")){
                    price = budget * 60 / 100;
                } else {
                    price = budget * 90 / 100;
                }
                break;
        }
        System.out.printf("%s - %s - %.2f", location, place, price);
    }
}
