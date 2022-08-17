package ConditionalStatementsAdvanced.exercises;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        double result = 0;
        String EvenOdd = "";
        switch (operator) {
            case "+":
                result = n1 + n2;
                if (result % 2 == 0) {
                    EvenOdd = "even";
                } else {
                    EvenOdd = "odd";
                }
                break;
            case "-":
                result = n1 - n2;
                if (result % 2 == 0) {
                    EvenOdd = "even";
                } else {
                    EvenOdd = "odd";
                }
                break;
            case "*":
                result = n1 * n2;
                if (result % 2 == 0) {
                    EvenOdd = "even";
                } else {
                    EvenOdd = "odd";
                }
                break;
            case "/":
                result = (n1 * 1.00) / n2;
                break;
            case "%":
                result = (n1 * 1.00) % n2;
                break;
        }
        if (operator.equals("+") || operator.equals("-") || operator.equals("*")) {
            System.out.printf("%d %s %d = %.0f - %s", n1, operator, n2, result, EvenOdd);
        } else if (operator.equals("/") && n2 != 0) {
            System.out.printf("%d / %d = %.2f", n1, n2, result);
        } else if (operator.equals("%") && n2 != 0) {
            System.out.printf("%d %% %d = %.0f", n1, n2, result);
        } else {
            System.out.printf("Cannot divide %d by zero", n1);
        }
    }
}
