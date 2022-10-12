package StacksAndQueuesEXERCISES;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        int numbersToAdd = Integer.parseInt(input[0]);
        int numbersToRemove = Integer.parseInt(input[1]);
        int numberToCheck = Integer.parseInt(input[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] numbersQueue = scanner.nextLine().split("\\s+");

        for (int i = 0; i < numbersToAdd; i++) {
            queue.offer(Integer.parseInt(numbersQueue[i]));
        }

        for (int i = 0; i < numbersToRemove; i++) {
            queue.poll();
        }

        if (queue.isEmpty()){
            System.out.println("0");
        } else if (queue.contains(numberToCheck)){
            System.out.println(true);
        } else {
            System.out.println(Collections.min(queue));
        }

    }
}
