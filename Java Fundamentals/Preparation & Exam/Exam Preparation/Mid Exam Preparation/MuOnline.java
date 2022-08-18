package MidExamEXERCISE;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] roomsArray = scanner.nextLine().split("\\|");
        int health = 100;
        int bitcoins = 0;
        boolean didMakeIt = true;
        for (int i = 0; i < roomsArray.length; i++) {
            String[] currentRoom = roomsArray[i].split(" ");
            String currentCommand = currentRoom[0];
            int currentNumber = Integer.parseInt(currentRoom[1]);
            switch (currentCommand) {
                case "potion":
                    health += currentNumber;
                    int healedHp = 0;
                    if (health > 100) {
                        healedHp = currentNumber - (health - 100);
                        health = 100;
                    } else {
                        healedHp = currentNumber;
                    }
                    System.out.printf("You healed for %d hp.%n", healedHp);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    bitcoins += currentNumber;
                    System.out.printf("You found %d bitcoins.%n", currentNumber);
                    break;
                default:
                    health -= currentNumber;
                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", currentCommand);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", currentCommand);
                        System.out.printf("Best room: %d", i + 1);
                        didMakeIt = false;
                    }
                    break;
            }
            if (!didMakeIt){
                break;
            }
        }
        if (didMakeIt) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d", health);
        }
    }
}
