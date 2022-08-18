package MapsLambdaAndStreamApiEXERCISE;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] wordArray = scanner.nextLine().split(" ");
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (int i = 0; i < wordArray.length ; i++) {
            String currentWord = wordArray[i];
            for (int j = 0; j < currentWord.length() ; j++) {
                char currentChar = currentWord.charAt(j);
                if (!countMap.containsKey(currentChar)){
                    countMap.put(currentChar, 1);
                } else {
                    countMap.put(currentChar, countMap.get(currentChar) + 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
