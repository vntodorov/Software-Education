package FunctionalProgrammingLAB;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<int[], String> count = n -> "Count = "
                + Arrays.stream(n).count();
        Function<int[], String> sum = n -> "Sum = "
                + Arrays.stream(n).sum();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\,\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(count.apply(numbers));
        System.out.println(sum.apply(numbers));



    }
}
