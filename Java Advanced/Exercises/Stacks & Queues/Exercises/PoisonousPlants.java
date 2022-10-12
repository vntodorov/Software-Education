package StacksAndQueuesEXERCISES;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int plants = Integer.parseInt(scanner.nextLine());

        String[] plantsPesticide = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> pesticideQueue = new ArrayDeque<>();

        for (String plant : plantsPesticide) {
            pesticideQueue.offer(Integer.parseInt(plant));
        }

        int days = 0;
        boolean isDeathDay = true;

        while (isDeathDay) {

            isDeathDay = false;

            ArrayDeque<Integer> updatedPesticideQueue = new ArrayDeque<>();
            updatedPesticideQueue.offer(pesticideQueue.peek());

            for (int i = 0; i < plants - 1; i++) {

                boolean isThisDead = false;

                int valueOfFirst = pesticideQueue.peek();
                pesticideQueue.offer(pesticideQueue.poll());
                int valueOfSecond = pesticideQueue.peek();

                if (valueOfSecond > valueOfFirst) {
                    isThisDead = true;
                    isDeathDay = true;
                }

                if (!isThisDead) {
                    updatedPesticideQueue.offer(pesticideQueue.peek());
                }

            }

            if (isDeathDay) {

                days++;
                pesticideQueue = updatedPesticideQueue;
                plants = pesticideQueue.size();

            }

        }

        System.out.println(days);

    }
}
