package SetsAndMapsAdvancedEXERCISES;

import java.util.Arrays;
import java.util.Scanner;

public class SetsOfElements2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sizes = scanner.nextLine();

        int sizeOfFirst = Integer.parseInt(sizes.split("\\s+")[0]);
        int sizeOfSecond = Integer.parseInt(sizes.split("\\s+")[1]);

        int[] firstNumbers = new int[sizeOfFirst];

        for (int i = 0; i < sizeOfFirst; i++) {
            firstNumbers[i] = Integer.parseInt(scanner.nextLine());

        }

        Arrays.sort(firstNumbers);

        int[] secondNumbers = new int[sizeOfSecond];

        for (int i = 0; i < sizeOfSecond; i++) {
            secondNumbers[i] = Integer.parseInt(scanner.nextLine());
        }

        Arrays.sort(secondNumbers);

        int[] theMinArray;
        int[] theMaxArray;

        if (firstNumbers.length > secondNumbers.length) {
            theMinArray = secondNumbers;
            theMaxArray = firstNumbers;
        } else {
            theMinArray = firstNumbers;
            theMaxArray = secondNumbers;
        }

        for (int indexMin = 0, indexMax = 0; indexMin < theMinArray.length; indexMin++) {
            int numberOfMin = theMinArray[indexMin];
            int numberOfMax = theMaxArray[indexMax];
            if (numberOfMin > numberOfMax) {
                indexMax++;
                indexMin--;
            } else if (numberOfMin == numberOfMax) {
                System.out.print(numberOfMin + " ");
                indexMax++;
            }

            if (indexMax >= theMaxArray.length){
                indexMax = theMaxArray.length - 1;
            }


        }

    }
}
