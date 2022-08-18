package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int middleElementIndex = numbers.size() / 2;

        double leftCar = 0;
        double rightCar = 0;

        for (int i = 0; i < middleElementIndex; i++) {
            int currentElement = numbers.get(i);
            if (currentElement == 0) {
                leftCar -= leftCar * 20 / 100;
            } else {
                leftCar += currentElement;
            }
        }

        for (int i = numbers.size() - 1; i > middleElementIndex; i--) {
            int currentElement = numbers.get(i);
            if (currentElement == 0) {
                rightCar -= rightCar * 20 / 100;
            } else {
                rightCar += currentElement;
            }
        }

        if (leftCar > rightCar) {
            System.out.printf("The winner is right with total time: %.1f", rightCar);
        } else {
            System.out.printf("The winner is left with total time: %.1f", leftCar);
        }

    }
}
