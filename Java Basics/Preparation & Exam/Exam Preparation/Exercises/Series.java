package Exam;

import java.util.Scanner;

public class Series {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int serials = Integer.parseInt(scanner.nextLine());
        double AllPrice = 0;
        for (int i = 1; i <= serials; i++) {
            String name = scanner.nextLine();
            double price = Double.parseDouble(scanner.nextLine());
            switch (name) {
                case "Thrones":
                    price -= price * 50 / 100;
                    break;
                case "Lucifer":
                    price -= price * 40 / 100;
                    break;
                case "Protector":
                    price -= price * 30 / 100;
                    break;
                case "TotalDrama":
                    price -= price * 20 / 100;
                    break;
                case "Area":
                    price -= price * 10 / 100;
                    break;
            }
            AllPrice += price;
        }
        double left = Math.abs(budget - AllPrice);
        if (budget >= AllPrice){
            System.out.printf("You bought all the series and left with %.2f lv." , left);
        } else {
            System.out.printf("You need %.2f lv. more to buy the series!" , left);
        }
    }
}
