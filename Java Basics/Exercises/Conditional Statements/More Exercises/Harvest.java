package ConditionalStatements;

import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vineyard = Integer.parseInt(scanner.nextLine());
        double grape = Double.parseDouble(scanner.nextLine());
        int WantedWine = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        double Harvest = vineyard * grape;
        double Liters = (Harvest * 40 / 100) / 2.5;
        if (Liters < WantedWine){
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(WantedWine - Liters));
        }
        if (Liters >= WantedWine){
            double left = Math.ceil(Liters - WantedWine);
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", Math.floor(Liters));
            System.out.printf("%.0f liters left -> %.0f liters per person.", left, Math.ceil(left / workers));
        }
    }
}
