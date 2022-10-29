package SetsAndMapsAdvancedEXERCISES;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, HashSet<String>> playersCards = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String currentName = input.split("\\:")[0];
            String[] allCards = input.split("\\:\\s")[1].split("\\,\\s");

            playersCards.putIfAbsent(currentName, new HashSet<>());

            for (String currentCard : allCards) {
                playersCards.get(currentName).add(currentCard);
            }


            input = scanner.nextLine();
        }

        for (var player : playersCards.entrySet()) {
            int points = calculatePoints(player.getValue());
            System.out.printf("%s: %d%n", player.getKey(), points);

        }


    }

    private static int calculatePoints(HashSet<String> cards) {
        int points = 0;
        for (String card : cards) {
            String power = card.substring(0, card.length() - 1);
            String color = card.substring(card.length() - 1);
            points += getSum(power, color);

        }
        return points;
    }

    private static int getSum(String power, String color) {

        int finalPower = 0;

        switch (power){
            case "J":
                finalPower += 11;
                break;
            case "Q":
                finalPower += 12;
                break;
            case "K":
                finalPower += 13;
                break;
            case "A":
                finalPower += 14;
                break;
            default:
                finalPower += Integer.parseInt(power);
        }

        switch (color){
            case "S":
                finalPower *= 4;
                break;
            case "H":
                finalPower *= 3;
                break;
            case "D":
                finalPower *= 2;
                break;
        }

        return finalPower;

    }
}
