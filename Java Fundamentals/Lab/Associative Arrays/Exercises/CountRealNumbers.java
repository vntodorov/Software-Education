package MapsLambdaAndStreamApiLAB;

import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> doubleList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        Map<Double, Integer> countNumbersMap = new TreeMap<>();
        for (Double number : doubleList) {
            if (countNumbersMap.containsKey(number)) {
                int currentValue = countNumbersMap.get(number);
                countNumbersMap.put(number, currentValue + 1);
            } else {
                countNumbersMap.put(number, 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : countNumbersMap.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
