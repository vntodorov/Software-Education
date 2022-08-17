package ConditionalStatements;

import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kilometers = Integer.parseInt(scanner.nextLine());
        String time = scanner.nextLine();
        double bus = kilometers * 0.09;
        double train = kilometers * 0.06;
        double DayTaxi = (kilometers * 0.79) + 0.70;
        double NightTaxi = (kilometers * 0.90) + 0.70;
        if (time.equals("day")) {
            if (kilometers < 20) {
                System.out.printf("%.2f", DayTaxi);
            } else if (kilometers < 100) {
                System.out.printf("%.2f", bus);
            } else {
                System.out.printf("%.2f", train);
            }
        }
        if (time.equals("night")) {
            if (kilometers < 20) {
                System.out.printf("%.2f", NightTaxi);
            } else if (kilometers < 100) {
                System.out.printf("%.2f", bus);
            } else {
                System.out.printf("%.2f", train);
            }
        }
    }
}


