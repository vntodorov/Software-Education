package StacksAndQueuesLAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int tossCount = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> names = new ArrayDeque<>();

        for (String name : input) {
            names.offer(name);
        }

        int cycle = 1;

        while (names.size() > 1) {

            for (int i = 1; i <= tossCount; i++) {
                if (i == tossCount) {
                    if (isPrime(cycle)) {
                        System.out.printf("Prime %s%n", names.peek());
                    } else {
                        System.out.printf("Removed %s%n", names.poll());
                    }
                } else {
                    names.offer(names.poll());
                }

            }
            cycle++;
        }
        System.out.printf("Last is %s", names.poll());
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
