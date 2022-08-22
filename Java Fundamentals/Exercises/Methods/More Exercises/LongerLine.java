package Methods;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());
        theLongest(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public static void closerTo0(double a, double b, double c, double d) {
        if (a * a + b * b <= c * c + d * d) {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", a, b, c, d);
        } else {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", c, d, a, b);
        }

    }

    public static void theLongest(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
        double result1 = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
        double result2 = Math.pow(x3 - x4, 2) + Math.pow(y3 - y4, 2);
        if (result1 >= result2){
            closerTo0(x1, y1, x2, y2);
        } else {
            closerTo0(x3, y3, x4, y4);
        }


    }
}
