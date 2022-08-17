package FirstStepsInCoding.exercises;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percentage = Double.parseDouble(scanner.nextLine());
        double total = (length * width * height) / 1000.00;
        double TotalOut = total - total * percentage / 100;
        System.out.println(TotalOut);



    }
}
