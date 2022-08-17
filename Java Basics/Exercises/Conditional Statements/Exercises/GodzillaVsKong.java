package ConditionalStatements.exercises;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int extra = Integer.parseInt(scanner.nextLine());
        double price = Double.parseDouble(scanner.nextLine());
        double decor = budget * 10 / 100;
        double cloth = extra * price;
        if (extra > 150){
            cloth = cloth - cloth * 10 / 100;
        }
        double total = decor + cloth;
        if (total > budget){
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", total - budget);
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", budget - total);
        }
    }
}
