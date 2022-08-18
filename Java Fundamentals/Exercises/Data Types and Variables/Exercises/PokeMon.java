package DataTypesAndVariablesEXERCISE;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long pokePower = Long.parseLong(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        byte exhaustionFactor = Byte.parseByte(scanner.nextLine());
        int allTargets = 0;
        double halfPokePower = pokePower * 50 / 100.0;
        while (pokePower >= distance) {
            allTargets++;
            pokePower -= distance;
            if ((pokePower == halfPokePower) && exhaustionFactor > 0) {
                pokePower /= exhaustionFactor;
            }
        }
        System.out.printf("%d%n%d", pokePower, allTargets);
    }
}
