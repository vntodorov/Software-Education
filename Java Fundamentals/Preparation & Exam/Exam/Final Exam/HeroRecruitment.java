package FinalEXAM;

import java.util.*;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> allHeroes = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String currentCommand = command.split("\\s")[0];
            String currentHero = command.split("\\s")[1];
            switch (currentCommand) {
                case "Enroll":
                    if (allHeroes.containsKey(currentHero)) {
                        System.out.printf("%s is already enrolled.%n", currentHero);
                    } else {
                        allHeroes.put(currentHero, new ArrayList<>());
                    }
                    break;
                case "Learn":
                    String learnSpell = command.split("\\s")[2];
                    if (!allHeroes.containsKey(currentHero)) {
                        System.out.printf("%s doesn't exist.%n", currentHero);
                    } else if (allHeroes.get(currentHero).contains(learnSpell)) {
                        System.out.printf("%s has already learnt %s.%n", currentHero, learnSpell);
                    } else {
                        allHeroes.get(currentHero).add(learnSpell);
                    }
                    break;
                case "Unlearn":
                    String unlearnSpell = command.split("\\s")[2];
                    if (!allHeroes.containsKey(currentHero)) {
                        System.out.printf("%s doesn't exist.%n", currentHero);
                    } else if (!allHeroes.get(currentHero).contains(unlearnSpell)) {
                        System.out.printf("%s doesn't know %s.%n", currentHero, unlearnSpell);
                    } else {
                        allHeroes.get(currentHero).remove(unlearnSpell);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Heroes:");
        allHeroes.entrySet().forEach(hero -> System.out.printf("== %s: %s%n", hero.getKey(), String.join(", ", hero.getValue())));
    }
}
