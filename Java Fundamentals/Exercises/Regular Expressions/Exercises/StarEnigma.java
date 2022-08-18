package RegularExpressionsEXERCISE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();
        Pattern pattern = Pattern.compile("^[^@\\-!:>]*@(?<planet>[A-Za-z]+)[^@\\-!:>]*:[0-9]+[^@\\-!:>]*!(?<action>[A,D])![^@\\-!:>]*->[0-9]+[^@\\-!:>]*$");
        int attackedCount = 0;
        int destroyedCount = 0;
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= number; i++) {
            String message = scanner.nextLine();
            String decryptedMessage = decryptedMessage(message);
            Matcher matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()) {
                String currentPlanet = matcher.group("planet");
                String currentAction = matcher.group("action");
                switch (currentAction) {
                    case "A":
                        attackedPlanets.add(currentPlanet);
                        attackedCount++;
                        break;
                    case "D":
                        destroyedPlanets.add(currentPlanet);
                        destroyedCount++;
                        break;
                }
            }
        }
        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);
        System.out.printf("Attacked planets: %d%n", attackedCount);
        attackedPlanets.forEach(planet -> System.out.println("-> " + planet));
        System.out.printf("Destroyed planets: %d%n", destroyedCount);
        destroyedPlanets.forEach(planet -> System.out.println("-> " + planet));

    }

    public static String decryptedMessage(String message) {
        int lettersCount = lettersOfMessage(message);
        StringBuilder decryptedMessageBuilding = new StringBuilder();
        for (char currentSymbol : message.toCharArray()) {
            char newSymbol = (char) (currentSymbol - lettersCount);
            decryptedMessageBuilding.append(newSymbol);
        }
        return decryptedMessageBuilding.toString();
    }


    public static int lettersOfMessage(String message) {
        int count = 0;
        for (char currentSymbol : message.toCharArray()) {
            switch (currentSymbol) {
                case 'S':
                case 'T':
                case 'A':
                case 'R':
                case 's':
                case 't':
                case 'a':
                case 'r':
                    count++;
                    break;
            }
        }
        return count;
    }
}
