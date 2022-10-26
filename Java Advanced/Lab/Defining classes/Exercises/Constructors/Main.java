package DefiningClassesLAB.Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        List<Car> allCars = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String[] carData = scanner.nextLine().split("\\s+");

            Car currentCar = carData.length == 1 ? new Car(carData[0]) : new Car(carData[0], carData[1], Integer.parseInt(carData[2]));

            allCars.add(currentCar);


        }

        allCars.forEach(Car::carInfo);
    }
}
