package FirstStepsInCoding.exercises;

import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pen = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        int liters = Integer.parseInt(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());
        double price = (pen * 5.80) + (markers * 7.20) + (liters * 1.20);
        double result = price - (price * percent / 100);
        System.out.println(result);
    }
}
