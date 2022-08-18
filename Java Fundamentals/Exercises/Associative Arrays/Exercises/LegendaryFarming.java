package MapsLambdaAndStreamApiEXERCISE;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> KeyMaterials = new LinkedHashMap<>();
        KeyMaterials.put("shards", 0);
        KeyMaterials.put("fragments", 0);
        KeyMaterials.put("motes", 0);
        Map<String, Integer> TrashMaterials = new LinkedHashMap<>();
        boolean didWin = false;
        while (!didWin) {
            String[] allMaterials = scanner.nextLine().split(" ");
            for (int i = 0; i < allMaterials.length; i += 2) {
                int quantity = Integer.parseInt(allMaterials[i]);
                String element = allMaterials[i + 1].toLowerCase();
                if (KeyMaterials.containsKey(element)) {
                    int newValue = KeyMaterials.get(element) + quantity;
                    if (newValue >= 250) {
                        String winningElement = "";
                        switch (element) {
                            case "shards":
                                winningElement = "Shadowmourne";
                                break;
                            case "fragments":
                                winningElement = "Valanyr";
                                break;
                            case "motes":
                                winningElement = "Dragonwrath";
                                break;
                        }
                        System.out.printf("%s obtained!%n", winningElement);
                        newValue -= 250;
                        KeyMaterials.put(element, newValue);
                        didWin = true;
                        break;
                    }
                    KeyMaterials.put(element, newValue);
                } else if (TrashMaterials.containsKey(element)) {
                    TrashMaterials.put(element, TrashMaterials.get(element) + quantity);
                } else {
                    TrashMaterials.put(element, quantity);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : KeyMaterials.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : TrashMaterials.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}

