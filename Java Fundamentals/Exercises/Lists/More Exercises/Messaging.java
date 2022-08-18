package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String message = scanner.nextLine();
        StringBuilder messageBuilder = new StringBuilder(message);
        StringBuilder newWord = new StringBuilder();
        for (int number : numbers) {
            int currentIndex = 0;
            while (number > 0) {
                int currentNumber = number % 10;
                currentIndex += currentNumber;
                number /= 10;
            }
            if (currentIndex < messageBuilder.length()) {
                newWord.append(messageBuilder.charAt(currentIndex));
                messageBuilder.deleteCharAt(currentIndex);
            } else {
                int realIndex = 0;
                for (int i = 0; i < currentIndex; i++) {
                    realIndex++;
                    if (realIndex > messageBuilder.length() - 1) {
                        realIndex = 0;
                    }

                }
                newWord.append(messageBuilder.charAt(realIndex));
                messageBuilder.deleteCharAt(realIndex);
            }
        }
        System.out.println(newWord);
    }
}
