package MethodsLAB;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        char operation = scanner.nextLine().charAt(0);
        int number2 = Integer.parseInt(scanner.nextLine());
        DecimalFormat df = new DecimalFormat ("##.##");
        System.out.println(df.format(calculate(number1, operation, number2)));

    }

    public static double calculate(int number1, char operation, int number2){
        double result = 0.0;
        switch (operation){
            case '/':
                result = number1 * 1.0 / number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
        }
        return result;
    }
}
