package StacksAndQueuesLAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryStack = new ArrayDeque<>();

        while (number > 0){
            binaryStack.push(number % 2);
            number /= 2;
        }

        if (binaryStack.isEmpty()){
            System.out.println(number);
        } else {
            for (Integer num : binaryStack){
                System.out.print(num);
            }
        }

    }
}
