package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();

        String[] allSteels = scanner.nextLine().split("\\s+");

        for (String steel : allSteels) {
            steelQueue.offer(Integer.parseInt(steel));
        }

        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();

        String[] allCarbons = scanner.nextLine().split("\\s+");

        for (String carbon : allCarbons) {
            carbonStack.push(Integer.parseInt(carbon));
        }

        TreeMap<String, Integer> swords = new TreeMap<>();
        swords.put("Gladius", 0);
        swords.put("Shamshir", 0);
        swords.put("Katana", 0);
        swords.put("Sabre", 0);

        int totalSwords = 0;


        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {

            int currentSteel = steelQueue.poll();
            int currentCarbon = carbonStack.pop();
            int sum = currentSteel + currentCarbon;

            switch (sum) {
                case 70:
                    swords.put("Gladius", swords.get("Gladius") + 1);
                    totalSwords++;
                    break;
                case 80:
                    swords.put("Shamshir", swords.get("Shamshir") + 1);
                    totalSwords++;
                    break;
                case 90:
                    swords.put("Katana", swords.get("Katana") + 1);
                    totalSwords++;
                    break;
                case 110:
                    swords.put("Sabre", swords.get("Sabre") + 1);
                    totalSwords++;
                    break;
                default:
                    currentCarbon += 5;
                    carbonStack.push(currentCarbon);
                    break;
            }

        }

        if (totalSwords > 0) {
            System.out.println("You have forged " + totalSwords + " swords.");
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.println("Steel left: " + steelQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.println("Carbon left: " + carbonStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        for (var sword : swords.entrySet()) {
            if (sword.getValue() > 0) {
                System.out.printf("%s: %d%n", sword.getKey(), sword.getValue());
            }
        }

    }
}
