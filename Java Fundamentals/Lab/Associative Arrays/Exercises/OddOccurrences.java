package MapsLambdaAndStreamApiLAB;


import java.util.*;


public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stringsArray = scanner.nextLine().split(" ");
        Map<String, Integer> stringsMap = new LinkedHashMap<>();
        for (int i = 0; i < stringsArray.length; i++) {
            String currentElement = stringsArray[i].toLowerCase();
            if (!stringsMap.containsKey(currentElement)) {
                stringsMap.put(currentElement, 1);
            } else {
                int currentValue = stringsMap.get(currentElement);
                stringsMap.put(currentElement, currentValue + 1);
            }
        }
        List<String> oddWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : stringsMap.entrySet()) {
            int currentValue = entry.getValue();
            if (currentValue % 2 != 0){
                oddWords.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", oddWords));
    }
}
