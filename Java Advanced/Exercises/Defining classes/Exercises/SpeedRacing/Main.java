package DefiningClassesEXERCISES.SpeedRacing;

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

            String model = carData[0];
            double fuel = Double.parseDouble(carData[1]);
            double fuelForKil = Double.parseDouble(carData[2]);

            Car car = new Car(model, fuel, fuelForKil);

            allCars.add(car);



        }

        String command = scanner.nextLine();

        while (!command.equals("End")){
            String[] commandData = command.split("\\s+");

            String currentModel = commandData[1];
            int amountOfKil = Integer.parseInt(commandData[2]);

            Car currentCar = allCars.stream().filter(c -> c.getModel().equals(currentModel)).findFirst().get();
            currentCar.drive(amountOfKil);
            command = scanner.nextLine();
        }

        allCars.forEach(System.out::println);


    }
}
