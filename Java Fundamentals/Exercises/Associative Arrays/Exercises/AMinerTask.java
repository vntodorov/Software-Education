package MapsLambdaAndStreamApiEXERCISE;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        Map<String, Integer> wordsMap = new LinkedHashMap<>();
        while (!word.equals("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!wordsMap.containsKey(word)) {
                wordsMap.put(word, quantity);
            } else {
                wordsMap.put(word, wordsMap.get(word) + quantity);
            }
            word = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
