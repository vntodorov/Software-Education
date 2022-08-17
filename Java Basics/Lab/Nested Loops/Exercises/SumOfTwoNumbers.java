package NestedLoops.lab;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int begin = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magic = Integer.parseInt(scanner.nextLine());
        boolean isEquals = false;
        int combination = 0;
        for (int i = begin; i <= end; i++) {
            for (int j = begin; j <= end; j++) {
                combination++;
                int result = i + j;
                if (result == magic) {
                    isEquals = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", combination, i, j, magic);
                    break;
                }
            }
            if (isEquals){
                break;
            }
        }
        if (!isEquals){
            System.out.printf("%d combinations - neither equals %d", combination, magic);
        }
    }
}
