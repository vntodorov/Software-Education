package ConditionalStatements;

import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int kilograms = Integer.parseInt(scanner.nextLine());
        double DogFood = Double.parseDouble(scanner.nextLine());
        double CatFood = Double.parseDouble(scanner.nextLine());
        double TurtleFood = Double.parseDouble(scanner.nextLine());
        double NeedFood = (DogFood * days) + (CatFood * days) + ((TurtleFood / 1000) * days);
        if (NeedFood <= kilograms){
            System.out.printf("%.0f kilos of food left.", Math.floor(kilograms - NeedFood));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(NeedFood - kilograms));
        }
    }
}
