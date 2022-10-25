package FunctionalProgrammingEXERCISES;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int numberToDivide = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);

        numbers.removeIf(number -> number % numberToDivide == 0);

        numbers.forEach(number -> System.out.print(number + " "));
    }
}
