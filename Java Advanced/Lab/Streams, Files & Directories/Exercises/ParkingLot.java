package SetsAndMapsAdvancedLAB;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String inOrOut = input.split("\\,\\s")[0];
            String carNumber = input.split("\\,\\s")[1];

            if (inOrOut.equals("IN")) {
                cars.add(carNumber);

            } else {
                cars.remove(carNumber);
            }


            input = scanner.nextLine();
        }

        if (!cars.isEmpty()) {
            for (String car : cars) {
                System.out.println(car);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }

    }
}
