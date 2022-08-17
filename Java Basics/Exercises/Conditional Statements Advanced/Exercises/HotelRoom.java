package ConditionalStatementsAdvanced.exercises;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());
        double StudioPrice = 0;
        double ApartmentPrice = 0;
        switch (month) {
            case "May":
            case "October":
                StudioPrice = 50 * nights;
                ApartmentPrice = 65 * nights;
                if (nights > 7 && nights <= 14) {
                    StudioPrice = StudioPrice - StudioPrice * 5 / 100;
                } else if (nights > 14) {
                    StudioPrice = StudioPrice - StudioPrice * 30 / 100;
                    ApartmentPrice = ApartmentPrice - ApartmentPrice * 10 / 100;
                }
                break;
            case "June":
            case "September":
                StudioPrice = 75.20 * nights;
                ApartmentPrice = 68.70 * nights;
                if (nights > 14) {
                    StudioPrice = StudioPrice - StudioPrice * 20 / 100;
                    ApartmentPrice = ApartmentPrice - ApartmentPrice * 10 / 100;
                }
                break;
            case "July":
            case "August":
                StudioPrice = 76 * nights;
                ApartmentPrice = 77 * nights;
                if (nights > 14) {
                    ApartmentPrice = ApartmentPrice - ApartmentPrice * 10 / 100;
                }
        }
        System.out.printf("Apartment: %.2f lv.%n", ApartmentPrice);
        System.out.printf("Studio: %.2f lv.", StudioPrice);
    }
}
