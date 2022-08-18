package FinalExamEXERCISE;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<Integer>> allCities = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String currentCity = input.split("\\|\\|")[0];
            int currentPopulation = Integer.parseInt(input.split("\\|\\|")[1]);
            int currentGold = Integer.parseInt(input.split("\\|\\|")[2]);
            if (!allCities.containsKey(currentCity)) {
                List<Integer> currentInfo = new ArrayList<>();
                currentInfo.add(currentPopulation);
                currentInfo.add(currentGold);
                allCities.put(currentCity, currentInfo);
            } else {
                int newPopulation = allCities.get(currentCity).get(0) + currentPopulation;
                int newGold = allCities.get(currentCity).get(1) + currentGold;
                allCities.get(currentCity).set(0, newPopulation);
                allCities.get(currentCity).set(1, newGold);
            }
            input = scanner.nextLine();
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String currentCommand = command.split("=>")[0];
            String currentCity = command.split("=>")[1];
            switch (currentCommand) {

                case "Plunder":
                    int plunderPeople = Integer.parseInt(command.split("=>")[2]);
                    int plunderGold = Integer.parseInt(command.split("=>")[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", currentCity, plunderGold, plunderPeople);
                    int populationAfterPlunder = allCities.get(currentCity).get(0) - plunderPeople;
                    int goldAfterPlunder = allCities.get(currentCity).get(1) - plunderGold;
                    allCities.get(currentCity).set(0, populationAfterPlunder);
                    allCities.get(currentCity).set(1, goldAfterPlunder);
                    if (allCities.get(currentCity).get(0) == 0 || allCities.get(currentCity).get(1) == 0) {
                        System.out.printf("%s has been wiped off the map!%n", currentCity);
                        allCities.remove(currentCity);
                    }
                    break;

                case "Prosper":
                    int prosperGold = Integer.parseInt(command.split("=>")[2]);
                    if (prosperGold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        int goldAfterProsper = allCities.get(currentCity).get(1) + prosperGold;
                        allCities.get(currentCity).set(1, goldAfterProsper);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", prosperGold, currentCity, goldAfterProsper);
                    }
                    break;
            }

            command = scanner.nextLine();

        }
        if (allCities.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", allCities.size());
            allCities.entrySet().forEach(entry -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
