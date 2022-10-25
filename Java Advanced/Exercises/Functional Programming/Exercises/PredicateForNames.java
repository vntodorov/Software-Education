package FunctionalProgrammingEXERCISES;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxLength = Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> size = name -> name.length() <= maxLength;

        Arrays.stream(names).filter(size).forEach(System.out::println);
    }
}
