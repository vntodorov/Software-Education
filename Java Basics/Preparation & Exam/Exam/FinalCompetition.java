package EXAM;

import java.util.Scanner;

public class FinalCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dancers = Integer.parseInt(scanner.nextLine());
        double points = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String place = scanner.nextLine();
        double Price = dancers * points;
        switch (place){
            case "Bulgaria":
                if (season.equals("summer")){
                    Price -= Price * 5 / 100;
                } else {
                    Price -= Price * 8 / 100;
                }
                break;
            case "Abroad":
                Price += Price * 50 / 100;
                if (season.equals("summer")){
                    Price -= Price * 10 / 100;
                } else {
                    Price -= Price * 15 / 100;
                }
                break;
        }
        double CharityPrice = Price * 75 / 100;
        Price -= CharityPrice;
        double PricePerDancer = Price / dancers;
        System.out.printf("Charity - %.2f%n", CharityPrice);
        System.out.printf("Money per dancer - %.2f", PricePerDancer);
    }
}
