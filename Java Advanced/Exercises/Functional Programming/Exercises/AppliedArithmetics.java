package FunctionalProgrammingEXERCISES;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<Integer, Integer> add = n -> n + 1;
        Function<Integer, Integer> multiply = n -> n * 2;
        Function<Integer, Integer> subtract = n -> n - 1;
        Consumer<Integer> print = n -> System.out.print(n + " ");

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    numbers = numbers.stream().map(add).collect(Collectors.toList());
                    break;
                case "multiply":
                    numbers = numbers.stream().map(multiply).collect(Collectors.toList());
                    break;
                case "subtract":
                    numbers = numbers.stream().map(subtract).collect(Collectors.toList());
                    break;
                case "print":
                    numbers.forEach(print);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }


    }
}