package MethodsEXERCISE;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= number; i++) {
            if (isSumDigitsDivisibleBy8(i) && isThereOddDigit(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isSumDigitsDivisibleBy8(int number) {
        int sumOfDigits = 0;
        while (number > 0) {
            int currentNumber = number % 10;
            sumOfDigits += currentNumber;
            number /= 10;
        }
        return sumOfDigits % 8 == 0;
    }

    public static boolean isThereOddDigit(int number) {
        while (number > 0) {
            int currentNumber = number % 10;
            if (currentNumber % 2 != 0) {
                return true;
            }
            number /= 10;
        }
        return false;
    }
}

