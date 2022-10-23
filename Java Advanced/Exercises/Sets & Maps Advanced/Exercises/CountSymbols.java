package SetsAndMapsAdvancedEXERCISES;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> charUsage = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (!charUsage.containsKey(currentChar)) {
                charUsage.put(currentChar, 1);
            } else {
                charUsage.put(currentChar, charUsage.get(currentChar) + 1);
            }

        }

        charUsage.entrySet().stream().forEach(symbol -> System.out.println(symbol.getKey() + ": " + symbol.getValue() + " time/s"));


    }
}
