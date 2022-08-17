package ConditionalStatements.exercises;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double excursion = Double.parseDouble(scanner.nextLine());
        int puzzle = Integer.parseInt(scanner.nextLine());
        int doll = Integer.parseInt(scanner.nextLine());
        int teddy = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());
        int order = puzzle + doll + teddy + minions + trucks;
        double total = (puzzle * 2.60) + (doll * 3) + (teddy * 4.10) + (minions * 8.20) + (trucks * 2);
        if (order >= 50){
            total = total - total * 25 / 100;
        }
        total = total - total * 10 / 100;
        if (total >= excursion){
            double left = total - excursion;
            System.out.printf("Yes! " + "%.2f" + " lv left.", left);
        } else {
            double left = excursion - total;
            System.out.printf("Not enough money! " + "%.2f" + " lv needed.", left);
        }
    }
}
