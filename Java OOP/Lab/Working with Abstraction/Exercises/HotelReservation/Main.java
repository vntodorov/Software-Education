package WorkingWithAbstractionLAB.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(data[0]);
        int day = Integer.parseInt(data[1]);
        Season season = Season.valueOf(data[2].toUpperCase());
        DiscountType discountType = DiscountType.valueOf(data[3].toUpperCase());


        System.out.printf("%.2f", PriceCalculator.calculate(pricePerDay, day, season, discountType));
    }
}
