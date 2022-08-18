package MethodsEXERCISE;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        printDividedFactorial(number1, number2);
    }

    public static void printDividedFactorial(int number1, int number2){
        double firstResult = 1;
        double secondResult= 1;
        for (int i = 1; i <= number1 ; i++) {
            firstResult *= i;
        }
        for (int i = 1; i <= number2 ; i++) {
            secondResult *= i;
        }
        System.out.printf("%.2f", firstResult / secondResult);
    }
}
