package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.TreeMap;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milk = new ArrayDeque<>();

        String[] milkValues = scanner.nextLine().split("\\s+");

        for (String milkValue : milkValues) {
            double currentValue = Double.parseDouble(milkValue);
            milk.offer(currentValue);
        }

        ArrayDeque<Double> cacao = new ArrayDeque<>();

        String[] cacaoValues = scanner.nextLine().split("\\s+");

        for (String cacaoValue : cacaoValues) {
            double currentValue = Double.parseDouble(cacaoValue);
            cacao.push(currentValue);
        }

        boolean allChocolates = false;

        TreeMap<String, Integer> chocolates = new TreeMap<>();

        while (!milk.isEmpty() && !cacao.isEmpty()) {

            double currentMilk = milk.poll();
            double currentCacao = cacao.pop();

            double result = currentCacao * 100 / (currentMilk + currentCacao);

            if (result == 100.0) {
                chocolates.putIfAbsent("Baking Chocolate", 0);
                int newBakingValue = chocolates.get("Baking Chocolate") + 1;
                chocolates.put("Baking Chocolate", newBakingValue);
            } else if (result == 50.0) {
                chocolates.putIfAbsent("Dark Chocolate", 0);
                int newDarkValue = chocolates.get("Dark Chocolate") + 1;
                chocolates.put("Dark Chocolate", newDarkValue);
            } else if (result == 30.0) {
                chocolates.putIfAbsent("Milk Chocolate", 0);
                int newMilkValue = chocolates.get("Milk Chocolate") + 1;
                chocolates.put("Milk Chocolate", newMilkValue);
            } else {
                milk.offer(currentMilk + 10);

            }

            if (chocolates.size() == 3) {
                allChocolates = true;
            }

        }

        if (allChocolates) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolates.forEach((key, value) -> System.out.printf("# %s --> %d%n", key, value));

    }
}
