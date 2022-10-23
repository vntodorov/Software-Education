package SetsAndMapsAdvancedEXERCISES;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int length = Integer.parseInt(input.split("\\s+")[0]);
        int check = Integer.parseInt(input.split("\\s+")[1]);

        Set<Integer> firstNumbers = new LinkedHashSet<>();

        for (int i = 0; i < length; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstNumbers.add(number);
        }

        Set<Integer> secondNumbers = new LinkedHashSet<>();

        for (int i = 0; i < check; i++) {
            int numberToCheck = Integer.parseInt(scanner.nextLine());
            secondNumbers.add(numberToCheck);

        }

        for (int number : firstNumbers){
            if (secondNumbers.contains(number)){
                System.out.print(number + " ");
            }
        }
    }
}
