package NestedLoops.exercises;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean isSpecial = false;
        for (int i = 1111; i <= 9999; i++) {
            int CurrentNumber = i;
            for (int j = 4; j > 0; j--) {
                int digit = CurrentNumber % 10;
                if (digit == 0 || n % digit != 0) {
                    isSpecial = false;
                    break;
                } else {
                    isSpecial = true;
                    CurrentNumber = CurrentNumber / 10;
                }
            }
            if (isSpecial) {
                System.out.print(i + " ");
            }
        }
    }
}
