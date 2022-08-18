package MidEXAM;

import java.util.Scanner;

public class CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceFlour = Double.parseDouble(scanner.nextLine());
        double priceEgg = Double.parseDouble(scanner.nextLine());
        double priceApron = Double.parseDouble(scanner.nextLine());
        int freeFlour = students / 5;
        double allFour = priceFlour * (students - freeFlour);
        double allEggs = priceEgg * students * 10;
        double allApron = priceApron * Math.ceil(students + students * 20.00 / 100);
        double allPrice = allFour + allEggs + allApron;
        if (budget >= allPrice){
            System.out.printf("Items purchased for %.2f$.", allPrice);
        } else {
            System.out.printf("%.2f$ more needed.", allPrice - budget);
        }
    }
}
