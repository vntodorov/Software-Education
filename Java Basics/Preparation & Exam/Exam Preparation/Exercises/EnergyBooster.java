package ExamMarch2020;

import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruits = scanner.nextLine();
        String size = scanner.nextLine();
        int NumOrdered = Integer.parseInt(scanner.nextLine());
        double Price = 0;
        switch (fruits) {
            case "Watermelon":
                if (size.equals("small")) {
                    Price = 56 * 2 * NumOrdered;
                } else {
                    Price = 28.70 * 5 * NumOrdered;
                }
                break;
            case "Mango":
                if (size.equals("small")) {
                    Price = 36.66 * 2 * NumOrdered;
                } else {
                    Price = 19.60 * 5 * NumOrdered;
                }
                break;
            case "Pineapple":
                if (size.equals("small")) {
                    Price = 42.10 * 2 * NumOrdered;
                } else {
                    Price = 24.80 * 5 * NumOrdered;
                }
                break;
            case "Raspberry":
                if (size.equals("small")) {
                    Price = 20 * 2 * NumOrdered;
                } else {
                    Price = 15.20 * 5 * NumOrdered;
                }
                break;
        }
        if (Price >= 400 && Price <= 1000) {
            Price -= Price * 15 / 100;
        } else if (Price > 1000) {
            Price -= Price * 50 / 100;
        }
        System.out.printf("%.2f lv.", Price);
    }
}
