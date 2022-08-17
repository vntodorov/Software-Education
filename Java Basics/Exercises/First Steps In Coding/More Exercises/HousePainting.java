package FirstStepsInCoding;

import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double walls = ((x*y) * 2) - 2 * 2.25;
        double WallsFrontBehind = ((x * x) * 2) - 2.4;
        double RoofWalls = (x * y) * 2;
        double RoofFrontBehind = (((x * h) /2) * 2);
        double GreenPaint = (walls + WallsFrontBehind) / 3.4;
        double RedPaint = (RoofWalls +RoofFrontBehind) / 4.3;
        System.out.printf("%.2f %n", GreenPaint);
        System.out.printf("%.2f", RedPaint);


    }
}
