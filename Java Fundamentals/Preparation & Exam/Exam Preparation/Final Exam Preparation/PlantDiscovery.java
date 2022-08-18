package FinalExamEXERCISE;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> plantsInfo = new LinkedHashMap<>();
        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= lines; i++) {
            String plant = scanner.nextLine();
            String currentPlant = plant.split("<->")[0];
            int rarity = Integer.parseInt(plant.split("<->")[1]);
            plantsInfo.put(currentPlant, new ArrayList<>());
            plantsInfo.get(currentPlant).add(rarity);
        }
        String command = scanner.nextLine();
        while (!command.equals("Exhibition")) {
            String currentCommand = command.split(":")[0];
            String currentPlant = command.split(":\\s")[1].split(" - ")[0];
            switch (currentCommand) {
                case "Rate":
                    if (plantsInfo.containsKey(currentPlant)) {
                        int rating = Integer.parseInt(command.split(" - ")[1]);
                        plantsInfo.get(currentPlant).add(rating);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    if (plantsInfo.containsKey(currentPlant)) {
                        int updateRARITY = Integer.parseInt(command.split(" - ")[1]);
                        plantsInfo.get(currentPlant).set(0, updateRARITY);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    if (plantsInfo.containsKey(currentPlant)) {
                        List<Integer> currentRatings = plantsInfo.get(currentPlant).subList(1, plantsInfo.get(currentPlant).size());
                        plantsInfo.get(currentPlant).removeAll(currentRatings);
                    } else {
                        System.out.println("error");
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, List<Integer>> entry : plantsInfo.entrySet()) {
            List<Integer> currentPlantRatings = entry.getValue().subList(1, entry.getValue().size());
            double overallRating = 0;
            int count = entry.getValue().size() - 1;
            for (double rating : currentPlantRatings) {
                overallRating += rating;
            }
            if (count > 0){
                overallRating /= count;
            }
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue().get(0), overallRating);
        }
    }
}
