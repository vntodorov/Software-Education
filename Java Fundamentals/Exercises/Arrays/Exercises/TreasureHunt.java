package ArraysEXERCISE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lootsList = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("Yohoho!")) {
            String[] commands = command.split(" ");
            String currentCommand = commands[0];
            switch (currentCommand) {
                case "Loot":
                    for (int i = 1; i < commands.length; i++) {
                        String currentLoot = commands[i];
                        if (!lootsList.contains(currentLoot)) {
                            lootsList.add(0, currentLoot);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(commands[1]);
                    if (index < 0 || index > lootsList.size() - 1) {
                        break;
                    }
                    String currentLoot = lootsList.get(index);
                    lootsList.remove(index);
                    lootsList.add(currentLoot);
                    break;
                case "Steal":
                    int count = Integer.parseInt(commands[1]);
                    if (lootsList.size() <= count) {
                        count = lootsList.size();
                    }
                    List<String> subList = lootsList.subList(lootsList.size() - count, lootsList.size());
                    System.out.println(String.join(", ", subList));
                    lootsList = lootsList.subList(0, lootsList.size() - count);
                    break;
            }
            command = scanner.nextLine();
        }
        if (!lootsList.isEmpty()) {
            String items = String.join("", lootsList);
            double sum = items.length() * 1.00 / lootsList.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", sum);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
