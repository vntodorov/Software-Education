package SetsAndMapsAdvancedLAB;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();


        for (int i = 0; i < lines; i++) {

            String[] information = scanner.nextLine().split("\\s+");
            String currentContinent = information[0];
            String currentCountry = information[1];
            String currentCity = information[2];

           continents.putIfAbsent(currentContinent, new LinkedHashMap<>());

           Map<String, List<String>> countries = continents.get(currentContinent);

           countries.putIfAbsent(currentCountry, new ArrayList<>());

           List<String> cities = countries.get(currentCountry);

           cities.add(currentCity);


        }

        for (Map.Entry<String, Map<String, List<String>>> continent : continents.entrySet()) {
            System.out.println(continent.getKey() + ":");
            for (Map.Entry<String, List<String>> country : continent.getValue().entrySet()) {
                System.out.printf("  %s -> %s%n", country.getKey(), String.join(", ", country.getValue()));
            }

        }

    }
}
