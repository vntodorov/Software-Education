package FunctionalProgrammingEXERCISES;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findIndexSmallest = list -> {
            int min = list.stream().mapToInt(e -> e).min().getAsInt();
            return list.lastIndexOf(min);

        };

        System.out.println(findIndexSmallest.apply(numbers));



    }
}
