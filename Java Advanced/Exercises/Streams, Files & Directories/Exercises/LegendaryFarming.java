package SetsAndMapsAdvancedEXERCISES;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> keyMaterials = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        TreeMap<String, Integer> junk = new TreeMap<>();

        String legendaryItem = "";
        boolean isClaimed = false;

        while (!isClaimed) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int i = 0; i < input.length; i += 2) {
                int amount = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();

                switch (material) {
                    case "shards":
                    case "fragments":
                    case "motes":
                        int newKeyAmount = keyMaterials.get(material) + amount;
                        if (newKeyAmount >= 250) {
                            newKeyAmount -= 250;
                            isClaimed = true;
                        }
                        keyMaterials.put(material, newKeyAmount);
                        break;
                    default:
                        if (!junk.containsKey(material)) {
                            junk.put(material, amount);
                        } else {
                            int newJunkAmount = junk.get(material) + amount;
                            junk.put(material, newJunkAmount);
                        }
                        break;

                }

                if (isClaimed) {
                    if (material.equals("shards")) {
                        legendaryItem = "Shadowmourne";
                    } else if (material.equals("fragments")) {
                        legendaryItem = "Valanyr";
                    } else {
                        legendaryItem = "Dragonwrath";
                    }
                    break;
                }


            }


        }

        System.out.println(legendaryItem + " obtained!");

        keyMaterials.entrySet().stream()
                .sorted((first, second) -> second.getValue().compareTo(first.getValue()))
                .forEach(el -> System.out.println(el.getKey() + ": " + el.getValue()));

        junk.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
