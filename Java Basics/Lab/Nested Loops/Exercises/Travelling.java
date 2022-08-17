package NestedLoops.lab;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();
        while (!destination.equals("End")) {
            double NeededBudget = Double.parseDouble(scanner.nextLine());
            double all = 0;
            while (all < NeededBudget){
                double sum = Double.parseDouble(scanner.nextLine());
                all += sum;
            }
            System.out.printf("Going to %s!%n", destination);
            destination = scanner.nextLine();
        }
    }
}

