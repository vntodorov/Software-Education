package ExceptionsAndErrorHandling;

import java.util.Optional;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] range = scanner.nextLine().split("\\s+");

        int startIndex = Integer.parseInt(range[0]);
        int endIndex = Integer.parseInt(range[1]);

        boolean isValid = false;

        System.out.printf("Range: [%d...%d]%n", startIndex, endIndex);

        while (!isValid) {
            String input = scanner.nextLine();

            Optional<Integer> number = Optional.empty();

            try {
                number = Optional.of(Integer.parseInt(input));
            } catch (Exception ignored) {
            }

            String output = "Invalid number: " + input;

            if (number.isPresent() && number.get() >= startIndex && number.get() <= endIndex) {
                output = "Valid number: " + number.get();
                isValid = true;
            }

            System.out.println(output);

        }
    }
}
