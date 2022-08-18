package Lists;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays
                .stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondList = Arrays
                .stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();

        while (!firstList.isEmpty() && !secondList.isEmpty()) {
            resultList.add(firstList.get(0));
            resultList.add(secondList.get(secondList.size() - 1));
            firstList.remove(0);
            secondList.remove(secondList.size() - 1);
        }

        List<Integer> finalList = new ArrayList<>();

        int upperRange = 0;
        int downRange = 0;

        if (!firstList.isEmpty()) {
            if (firstList.get(0) > firstList.get(1)) {
                upperRange = firstList.get(0);
                downRange = firstList.get(1);
            } else {
                upperRange = firstList.get(1);
                downRange = firstList.get(0);
            }

        } else {
            if (secondList.get(0) > secondList.get(1)) {
                upperRange = secondList.get(0);
                downRange = secondList.get(1);
            } else {
                upperRange = secondList.get(1);
                downRange = secondList.get(0);
            }

        }

        for (int currentNumber : resultList) {
            if (currentNumber > downRange && currentNumber < upperRange) {
                finalList.add(currentNumber);
            }

        }

        Collections.sort(finalList);

        System.out.println(String.join(" ", finalList.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "" )));

    }
}
