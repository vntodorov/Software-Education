package ForLoop;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int moves = Integer.parseInt(scanner.nextLine());
        double result = 0;
        int invalid = 0;
        int blw10 = 0;
        int blw20 = 0;
        int blw30 = 0;
        int blw40 = 0;
        int blw50 = 0;
        for (int i = 1; i <= moves; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 0 || number > 50) {
                invalid++;
                result /= 2;
            } else if (number < 10) {
                blw10++;
                result += number * 20.00 / 100;
            } else if (number < 20) {
                blw20++;
                result += number * 30.00 / 100;
            } else if (number < 30) {
                blw30++;
                result += number * 40.00 / 100;
            } else if (number < 40) {
                blw40++;
                result += 50;
            } else {
                blw50++;
                result += 100;
            }
        }
        double p1 = blw10 * 1.00 / moves * 100;
        double p2 = blw20 * 1.00 / moves * 100;
        double p3 = blw30 * 1.00 / moves * 100;
        double p4 = blw40 * 1.00 / moves * 100;
        double p5 = blw50 * 1.00 / moves * 100;
        double p6 = invalid * 1.00 / moves * 100;
        System.out.printf("%.2f%n", result);
        System.out.printf("From 0 to 9: %.2f%%%n", p1);
        System.out.printf("From 10 to 19: %.2f%%%n", p2);
        System.out.printf("From 20 to 29: %.2f%%%n", p3);
        System.out.printf("From 30 to 39: %.2f%%%n", p4);
        System.out.printf("From 40 to 50: %.2f%%%n", p5);
        System.out.printf("Invalid numbers: %.2f%%", p6);
    }
}
