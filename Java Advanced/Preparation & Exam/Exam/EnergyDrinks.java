package EXAM;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] milligrams = scanner.nextLine().split("\\,\\s");

        ArrayDeque<Integer> caffeineStack = new ArrayDeque<>();

        for (String mill : milligrams) {
            caffeineStack.push(Integer.parseInt(mill));
        }

        String[] energy = scanner.nextLine().split("\\,\\s");

        ArrayDeque<Integer> drinksQueue = new ArrayDeque<>();

        for (String e : energy) {
            drinksQueue.offer(Integer.parseInt(e));
        }

        ArrayDeque<Integer> caffeineQueue = new ArrayDeque<>();

        for (int e : caffeineStack) {
            caffeineQueue.offer(e);
        }

        int caffeine = 0;

        while (!caffeineQueue.isEmpty() && !drinksQueue.isEmpty()) {

            int currentCaffeine = caffeineQueue.poll();
            int currentEnergy = drinksQueue.poll();

            int total = currentCaffeine * currentEnergy;

            if (caffeine + total <= 300) {
                caffeine += total;
            } else {
                drinksQueue.offer(currentEnergy);
                if (caffeine > 30) {
                    caffeine -= 30;
                } else {
                    caffeine = 0;
                }
            }

        }

        if (drinksQueue.isEmpty()){
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            System.out.println("Drinks left: " + String.join(", ", drinksQueue.stream().map(String::valueOf).collect(Collectors.toList())));
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", caffeine);

    }
}
