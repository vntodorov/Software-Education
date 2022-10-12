package StacksAndQueuesLAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        int result = 0;

        for (String operator : input) {
            stack.push(operator);
        }

        while (stack.size() > 1){
            int number = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            if (operator.equals("-")){
                result -= number;
            } else {
                result += number;
            }
        }
        result += Integer.parseInt(stack.pop());
        System.out.println(result);

    }
}
