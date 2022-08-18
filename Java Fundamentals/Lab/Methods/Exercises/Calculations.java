package MethodsLAB;

import java.util.Scanner;

public class Calculations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        switch (operation) {
            case "add":
                printAdd(firstNumber, secondNumber);
                break;
            case "multiply":
                printMultiply(firstNumber, secondNumber);
                break;
            case "subtract":
                printSubtract(firstNumber, secondNumber);
                break;
            case "divide":
                printDivide(firstNumber, secondNumber);
                break;
        }
    }

    public static void printAdd(int firstNumber, int secondNumber) {
        System.out.print(firstNumber + secondNumber);
    }

    public static void printMultiply(int firstNumber, int secondNumber) {
        System.out.print(firstNumber * secondNumber);
    }

    public static void printSubtract(int firstNumber, int secondNumber) {
        System.out.print(firstNumber - secondNumber);
    }

    public static void printDivide(int firstNumber, int secondNumber) {
        System.out.print(firstNumber / secondNumber);
    }

}
