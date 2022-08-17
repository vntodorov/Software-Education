package FirstStepsInCoding.exercises;

import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ChickenMenu = Integer.parseInt(scanner.nextLine());
        int FishMenu = Integer.parseInt(scanner.nextLine());
        int VeganMenu = Integer.parseInt(scanner.nextLine());
        double MenuPrice = ChickenMenu * 10.35 + FishMenu * 12.40 + VeganMenu * 8.15;
        double Dessert = MenuPrice * 20 / 100;
        double TotalPrice = MenuPrice + Dessert + 2.50;
        System.out.println(TotalPrice);

    }
}
