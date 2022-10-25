package FunctionalProgrammingEXERCISES;

import java.util.Arrays;
import java.util.Scanner;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int min = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).min().orElse(0);
        System.out.println(min);


    }
}
