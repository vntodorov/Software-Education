package FunctionalProgrammingLAB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int start = Integer.parseInt(input.split("\\s+")[0]);
        int end = Integer.parseInt(input.split("\\s+")[1]);

        String type = scanner.nextLine();

        List<Integer> numbers = new ArrayList<>();

        IntPredicate predicate = n ->
                type.equals("odd") == (n % 2 != 0);

        System.out.println(IntStream.rangeClosed(start, end)
                .filter(predicate)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));

    }
}
