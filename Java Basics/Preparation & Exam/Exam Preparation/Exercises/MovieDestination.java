package Exam;

import java.util.Scanner;

public class MovieDestination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String destination = scanner.nextLine();
        String season = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        double Price = 0;
        switch (season){
            case "Winter":
                if (destination.equals("Dubai")){
                    Price = 45000 * days;
                    Price -= Price * 30 / 100;
                } else if (destination.equals("Sofia")){
                    Price = 17000 * days;
                    Price += Price * 25 / 100;
                } else {
                    Price = 24000 * days;
                }
                break;
            case "Summer":
                if (destination.equals("Dubai")){
                    Price = 40000 * days;
                    Price -= Price * 30 / 100;
                } else if (destination.equals("Sofia")){
                    Price = 12500 * days;
                    Price += Price * 25 / 100;
                } else {
                    Price = 20250 * days;
                }
                break;
        }
        double left = Math.abs(budget - Price);
        if (budget >= Price){
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", left);
        } else {
            System.out.printf("The director needs %.2f leva more!", left);
        }
    }
}
