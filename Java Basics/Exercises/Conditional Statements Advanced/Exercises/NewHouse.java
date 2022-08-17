package ConditionalStatementsAdvanced.exercises;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flower = scanner.nextLine();
        int flowers = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double price = 0;
        switch (flower){
            case "Roses":
                if (flowers > 80){
                    price = (5 * flowers) - ((5 * flowers) * 10 / 100.00);
                } else {
                    price = 5 * flowers;
                }
                break;
            case "Dahlias":
                if (flowers > 90){
                    price = (3.80 * flowers) - ((3.80 * flowers) * 15 / 100);
                } else {
                    price = 3.80 * flowers;
                }
                break;
            case "Tulips":
                if (flowers > 80){
                    price = (2.80 * flowers) - ((2.80 * flowers) * 15 / 100);
                } else {
                    price = 2.80 * flowers;
                }
                break;
            case "Narcissus":
                if (flowers < 120){
                    price = (3 * flowers) + ((3 * flowers) * 15 / 100.00);
                } else {
                    price = 3 * flowers;
                }
                break;
            case "Gladiolus":
                if (flowers < 80){
                    price = (2.50 * flowers) + ((2.50 * flowers) * 20 / 100);
                } else {
                    price = 2.50 * flowers;
                }
                break;
        }
        if (budget >= price){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowers, flower, budget - price);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", price - budget);
        }
    }
}
