package ConditionalStatements.exercises;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int gpu = Integer.parseInt(scanner.nextLine());
        int cpu = Integer.parseInt(scanner.nextLine());
        int ram = Integer.parseInt(scanner.nextLine());
        double GpuPrice = gpu * 250;
        double CpuPrice = GpuPrice * 35 / 100;
        double RamPrice = GpuPrice * 10 / 100;
        double AllSum = GpuPrice + (cpu * CpuPrice) + (ram * RamPrice);
        if (gpu > cpu) {
            AllSum = AllSum - AllSum * 15 / 100;
        }
        if (AllSum <= budget) {
            System.out.printf("You have %.2f leva left!", budget - AllSum);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", AllSum - budget);
        }
    }
}
