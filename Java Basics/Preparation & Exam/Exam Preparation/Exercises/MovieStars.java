package Exam;

import java.util.Scanner;

public class MovieStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String actor = scanner.nextLine();
        double salary = 0;
        while (!actor.equals("ACTION")) {
            if (actor.length() <= 15) {
                salary = Double.parseDouble(scanner.nextLine());
            } else {
                salary = budget * 20 / 100;
            }
            budget -= salary;
            if (budget <= 0) {
                break;
            }
            actor = scanner.nextLine();
        }
        if (budget >= 0) {
            System.out.printf("We are left with %.2f leva.", budget);
        } else {
            System.out.printf("We need %.2f leva for our actors.", Math.abs(budget));
        }
    }
}
