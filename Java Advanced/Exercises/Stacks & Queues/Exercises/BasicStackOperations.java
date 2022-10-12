package StacksAndQueuesEXERCISES;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int numbersToPush = Integer.parseInt(input[0]);
        int numbersToPop = Integer.parseInt(input[1]);
        int numberToCheck = Integer.parseInt(input[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] numbers = scanner.nextLine().split("\\s+");

        for (int i = 0; i < numbersToPush; i++) {
            stack.push(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println("0");
        } else if (stack.contains(numberToCheck)) {
            System.out.println(true);
        } else {
            int minElement = Collections.min(stack);
            System.out.println(minElement);
        }


    }
}
