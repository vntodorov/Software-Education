package Methods;

import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        numTribonacci(length);
    }

    public static void numTribonacci(int length) {
        int[] numbers = new int[length];
        if (length == 1) {
            numbers[0] = 1;
        } else if (length == 2) {
            numbers[0] = 1;
            numbers[1] = 1;
        } else {
            numbers[0] = numbers[1] = 1;
            numbers[2] = 2;
            for (int i = 3; i < numbers.length; i++) {
                numbers[i] = numbers[i - 1] + numbers[i - 2] + numbers[i - 3];
            }
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
