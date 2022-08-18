package FinalExamEXERCISE;

import java.util.*;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> carsCollection = new LinkedHashMap<>();
        int cars = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= cars ; i++) {
            String[] info = scanner.nextLine().split("\\|");
            String currentCar = info[0];
            int currentMileage = Integer.parseInt(info[1]);
            int currentFuel = Integer.parseInt(info[2]);
            List<Integer> currentInfo = new ArrayList<>();
            currentInfo.add(currentMileage);
            currentInfo.add(currentFuel);
            carsCollection.put(currentCar, currentInfo);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")){
            String currentCommand = command.split(" : ")[0];
            String currentCar = command.split(" : ")[1];
            switch (currentCommand){
                case "Drive":
                    int driveDistance = Integer.parseInt(command.split(" : ")[2]);
                    int driveFuel = Integer.parseInt(command.split(" : ")[3]);
                    int currentFuel = carsCollection.get(currentCar).get(1);
                    if (driveFuel > currentFuel){
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        int newMileage = carsCollection.get(currentCar).get(0) + driveDistance;
                        int newFuel = currentFuel - driveFuel;
                        List<Integer> newInfo = new ArrayList<>();
                        newInfo.add(newMileage);
                        newInfo.add(newFuel);
                        carsCollection.put(currentCar, newInfo);
                        System.out.printf("%s driven for %s kilometers. %s liters of fuel consumed.%n", currentCar, driveDistance, driveFuel);
                    }
                    if (carsCollection.get(currentCar).get(0) >= 100000){
                        carsCollection.remove(currentCar);
                        System.out.printf("Time to sell the %s!%n", currentCar);
                    }
                    break;
                case "Refuel":
                    int refuelFuel = Integer.parseInt(command.split(" : ")[2]);
                    int newFuel = carsCollection.get(currentCar).get(1) + refuelFuel;
                    if (newFuel > 75){
                        newFuel = 75;
                        refuelFuel = newFuel - carsCollection.get(currentCar).get(1);
                    }
                    System.out.printf("%s refueled with %d liters%n", currentCar, refuelFuel);
                    carsCollection.get(currentCar).set(1, newFuel);
                    break;
                case "Revert":
                    int revertKilometers = Integer.parseInt(command.split(" : ")[2]);
                    int newKilometers = carsCollection.get(currentCar).get(0) - revertKilometers;
                    if (newKilometers < 10000){
                        newKilometers = 10000;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", currentCar, revertKilometers);
                    }
                    carsCollection.get(currentCar).set(0, newKilometers); //////!
                    break;
            }
            command = scanner.nextLine();
        }
        carsCollection.entrySet().forEach(car -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", car.getKey(), car.getValue().get(0), car.getValue().get(1)));
    }
}
