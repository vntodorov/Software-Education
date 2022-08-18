package FinalExamEXERCISE;

import java.util.*;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Integer>> allHeroes = new LinkedHashMap<>();
        int heroes = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= heroes; i++) {
            String[] commands = scanner.nextLine().split("\\s");
            String currentHero = commands[0];
            int currentHP = Integer.parseInt(commands[1]);
            int currentMP = Integer.parseInt(commands[2]);
            List<Integer> currentInfo = new ArrayList<>();
            currentInfo.add(currentHP);
            currentInfo.add(currentMP);
            allHeroes.put(currentHero, currentInfo);
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String currentCommand = command.split("\\s\\-\\s")[0];
            String currentHero = command.split("\\s\\-\\s")[1];
            switch (currentCommand) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(command.split("\\s\\-\\s")[2]);
                    String spellName = command.split("\\s\\-\\s")[3];
                    if (allHeroes.get(currentHero).get(1) >= neededMP) {
                        int newMP = allHeroes.get(currentHero).get(1) - neededMP;
                        allHeroes.get(currentHero).set(1, newMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", currentHero, spellName, newMP);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", currentHero, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(command.split("\\s\\-\\s")[2]);
                    String attacker = command.split("\\s\\-\\s")[3];
                    int newHP = allHeroes.get(currentHero).get(0) - damage;
                    if (newHP > 0) {
                        allHeroes.get(currentHero).set(0, newHP);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", currentHero, damage, attacker, newHP);
                    } else {
                        allHeroes.remove(currentHero);
                        System.out.printf("%s has been killed by %s!%n", currentHero, attacker);
                    }
                    break;
                case "Recharge":
                    int healMP = Integer.parseInt(command.split("\\s\\-\\s")[2]);
                    int newHealedMP = allHeroes.get(currentHero).get(1) + healMP;
                    if (newHealedMP > 200) {
                        newHealedMP = 200;
                        healMP = 200 - allHeroes.get(currentHero).get(1);
                    }
                    allHeroes.get(currentHero).set(1, newHealedMP);
                    System.out.printf("%s recharged for %d MP!%n", currentHero, healMP);
                    break;
                case "Heal":
                    int healHP = Integer.parseInt(command.split("\\s\\-\\s")[2]);
                    int newHealedHP = allHeroes.get(currentHero).get(0) + healHP;
                    if (newHealedHP > 100) {
                        newHealedHP = 100;
                        healHP = 100 - allHeroes.get(currentHero).get(0);
                    }
                    allHeroes.get(currentHero).set(0, newHealedHP);
                    System.out.printf("%s healed for %d HP!%n", currentHero, healHP);
                    break;
            }
            command = scanner.nextLine();
        }
        allHeroes.entrySet().forEach(hero -> System.out.printf("%s%n  HP: %d%n  MP: %d%n", hero.getKey(), hero.getValue().get(0), hero.getValue().get(1)));
    }
}
