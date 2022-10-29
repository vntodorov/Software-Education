package SetsAndMapsAdvancedEXERCISES;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Integer>> allInfo = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> countriesOnly = new LinkedHashMap<>();

        while (!input.equals("report")){
            String currentCity = input.split("\\|")[0];
            String currentCountry = input.split("\\|")[1];
            int currentPopulation = Integer.parseInt(input.split("\\|")[2]);

            allInfo.putIfAbsent(currentCountry, new LinkedHashMap<>());

            allInfo.get(currentCountry).put(currentCity, currentPopulation);



            input = scanner.nextLine();
        }
        for (var country : allInfo.entrySet()) {
            int allPopulation = 0;
            for (var cities : country.getValue().entrySet()){
                allPopulation += cities.getValue();
            }
            countriesOnly.put(country.getKey(), allPopulation);
        }



    }
}
