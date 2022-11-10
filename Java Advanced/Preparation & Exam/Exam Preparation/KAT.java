package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Scanner;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> licenseQueue = new ArrayDeque<>();

        String[] licensePlates = scanner.nextLine().split("\\,\\s");

        for (String plate : licensePlates){
            licenseQueue.offer(Integer.parseInt(plate));
        }

        ArrayDeque<Integer> carsStack = new ArrayDeque<>();

        String[] allCars = scanner.nextLine().split("\\,\\s");

        for (String car : allCars){
            carsStack.push(Integer.parseInt(car));
        }

        ArrayDeque<Integer> carsQueue = new ArrayDeque<>();

        for (int car : carsStack){
            carsQueue.offer(car);
        }

        int cars = 0;
        int days = 0;

        while (!licenseQueue.isEmpty() && !carsQueue.isEmpty()){
            days++;

            int currentCars = carsQueue.poll();
            int currentLicenses = licenseQueue.poll();

            int carsForLicenses = currentLicenses / 2;

            if (currentCars > carsForLicenses){
                cars += carsForLicenses;
                currentCars -= carsForLicenses;
                carsQueue.offer(currentCars);


            } else if (carsForLicenses > currentCars) {
                cars += currentCars;
                currentLicenses -= currentCars * 2;
                licenseQueue.offer(currentLicenses);

            } else {
                cars += carsForLicenses;
            }


        }

        System.out.printf("%d cars were registered for %d days!%n", cars, days);

        if (!licenseQueue.isEmpty()){
            System.out.printf("%d license plates remain!", licenseQueue.stream().mapToInt(e -> e).sum());
        } else if (!carsQueue.isEmpty()){
            System.out.printf("%d cars remain without license plates!", carsQueue.stream().mapToInt(e -> e).sum());
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }


    }
}
