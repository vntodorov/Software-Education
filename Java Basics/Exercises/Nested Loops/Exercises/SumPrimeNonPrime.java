package NestedLoops.exercises;

import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int SimpleSum = 0;
        int NonSimpleSum = 0;
        while (!number.equals("stop")) {
            int SumNumber = Integer.parseInt(number);
            if (SumNumber < 0) {
                System.out.println("Number is negative.");
            } else if ((SumNumber % 2 == 0 && SumNumber != 2) || (SumNumber % 3 == 0 && SumNumber != 3)) {
                NonSimpleSum += SumNumber;
            } else {
                SimpleSum += SumNumber;
            }
            number = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n", SimpleSum);
        System.out.printf("Sum of all non prime numbers is: %d", NonSimpleSum);
    }
}
