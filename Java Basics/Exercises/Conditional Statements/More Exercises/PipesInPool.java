package ConditionalStatements;

import java.util.Scanner;

public class PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double water = (p1 * h) + (p2 * h);
        double percentage = (water / v) * 100;
        double p1result = ((p1 * h) / water) * 100;
        double p2result = ((p2 * h) / water) * 100;
        if (v >= water) {
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%% Pipe 2: %.2f%%.", percentage, p1result, p2result);
        } else {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", h, water - v);
        }
    }
}
