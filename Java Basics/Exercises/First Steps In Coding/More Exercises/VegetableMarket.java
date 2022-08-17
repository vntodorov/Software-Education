package FirstStepsInCoding;

import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vegetables = Double.parseDouble(scanner.nextLine());
        double fruits = Double.parseDouble(scanner.nextLine());
        int KgVegetables = Integer.parseInt(scanner.nextLine());
        int KgFruits = Integer.parseInt(scanner.nextLine());
        double TotalKgVegetables = vegetables * KgVegetables;
        double TotalKgFruits = fruits * KgFruits;
        double result = (TotalKgVegetables + TotalKgFruits) / 1.94;
        System.out.printf("%.2f", result);
    }
}
