package ConditionalStatements;

import java.util.Locale;
import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fuel = scanner.nextLine();
        int InFuel = Integer.parseInt(scanner.nextLine());
        boolean validFuel = (fuel.equals("Diesel") || fuel.equals("Gasoline") || fuel.equals("Gas"));
        if (!validFuel){
            System.out.println("Invalid fuel!");
        } else if (InFuel >= 25){
            System.out.printf("You have enough %s.", fuel.toLowerCase());
        } else {
            System.out.printf("Fill your tank with %s!", fuel.toLowerCase());
        }
    }
}
