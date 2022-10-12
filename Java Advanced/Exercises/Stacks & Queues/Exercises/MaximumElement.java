package StacksAndQueuesEXERCISES;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < commands; i++) {
            String input = scanner.nextLine();
            String currentCommand = input.split("\\s+")[0];
            switch (currentCommand){
                case "1":
                    int element = Integer.parseInt(input.split("\\s+")[1]);
                    stack.push(element);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}
