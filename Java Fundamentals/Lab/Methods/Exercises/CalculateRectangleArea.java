package MethodsLAB;

import java.util.Scanner;

public class CalculateRectangleArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = Double.parseDouble(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());
        double result = calculatedRectangleArea(width, length);
        System.out.printf("%.0f", result);
    }

    public static double calculatedRectangleArea(double width, double length) {
        return width * length;
    }
}
