package RegularExpressionsEXERCISE;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] demons = scanner.nextLine().split("\\s*,\\s*");
        for (String currentDemon : demons) {
            int health = demonHealth(currentDemon);
            double damage = demonDamage(currentDemon);
            System.out.printf("%s - %d health, %.2f damage%n", currentDemon, health, damage);
        }
    }

    public static int demonHealth (String demon){
        int health = 0;
        Pattern healthPattern = Pattern.compile("[^0-9+\\-,\\/*\\.]");
        Matcher healthMatcher = healthPattern.matcher(demon);
        while (healthMatcher.find()){
            char currentSymbol = healthMatcher.group().charAt(0);
            health += currentSymbol;
        }
        return health;
    }


    public static double demonDamage (String demon){
        double damage = 0;
        Pattern basicDamage = Pattern.compile("[\\+\\-]?[0-9]+\\.?[0-9]*");
        Matcher basicDamageMatcher = basicDamage.matcher(demon);
        while (basicDamageMatcher.find()){
            damage += Double.parseDouble(basicDamageMatcher.group());
        }
        Pattern actionsFinder = Pattern.compile("[\\/\\*]");
        Matcher actionsMatcher = actionsFinder.matcher(demon);
        while (actionsMatcher.find()){
            String currentAction = actionsMatcher.group();
            if (currentAction.equals("*")){
                damage *= 2;
            } else if (currentAction.equals("/")) {
                damage /= 2;
            }
        }
        return damage;
    }
}
