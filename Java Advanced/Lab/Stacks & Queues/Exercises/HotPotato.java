package StacksAndQueuesLAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int tossCount = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> names = new ArrayDeque<>();

        for (String name : input){
            names.offer(name);
        }
        int round = 0;
        while (names.size() > 1){
            round++;
            if (round != tossCount){
                names.offer(names.poll());
            } else {
                System.out.printf("Removed %s%n", names.poll());
                round = 0;
            }
        }
        System.out.printf("Last is %s", names.poll());
    }
}
