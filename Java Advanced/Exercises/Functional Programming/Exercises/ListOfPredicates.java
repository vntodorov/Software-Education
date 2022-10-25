package FunctionalProgrammingEXERCISES;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int range = Integer.parseInt(scanner.nextLine());

        int[] numbersToDivide = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Predicate<Integer> divide = n -> {

            for (int number : numbersToDivide){
                if (n % number != 0){
                    return false;
                }
            }
            return true;

        };

        for (int i = 1; i <= range; i++) {
            if (divide.test(i)){
                System.out.print(i + " ");
            }


        }


    }
}
