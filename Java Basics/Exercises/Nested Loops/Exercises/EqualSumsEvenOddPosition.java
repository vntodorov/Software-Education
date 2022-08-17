package NestedLoops.exercises;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int First = Integer.parseInt(scanner.nextLine());
        int Second = Integer.parseInt(scanner.nextLine());
        for (int i = First; i <= Second; i++) {
            int CurrentNumber = i;
            int oddSum = 0;
            int evenSum = 0;
            for (int j = 6; j >= 1; j--) {
                int digit = CurrentNumber % 10;
                if (j % 2 == 0){
                    evenSum += digit;
                } else {
                    oddSum += digit;
                }
                CurrentNumber = CurrentNumber / 10;
            }
            if (evenSum == oddSum){
                System.out.print(i + " ");
            }
        }
    }
}
