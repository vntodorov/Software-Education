package MethodsLAB;

import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(MultiplySums(number));

    }

    public static int MultiplySums(int number){
        int evenSum = 0;
        int OddSum = 0;
        while (Math.abs(number) > 0){
            int currentNum = number % 10;
            if (currentNum % 2 == 0){
                evenSum += currentNum;
            } else {
                OddSum += currentNum;
            }
            number /= 10;
        }
        return evenSum * OddSum;
    }
}
