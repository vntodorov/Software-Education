package DefiningClassesLAB.CarInfo;

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
            String carBrand = carData[0];
            String carModel = carData[1];
            int carHorsePower = Integer.parseInt(carData[2]);
            Car currentCar = new Car(carBrand, carModel, carHorsePower);

            allCars.add(currentCar);



        }

        allCars.forEach(Car::carInfo);



    }
}
