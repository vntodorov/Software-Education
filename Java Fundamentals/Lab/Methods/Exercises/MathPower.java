package MethodsLAB;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber = Double.parseDouble(scanner.nextLine());
        double secondNumber = Double.parseDouble(scanner.nextLine());
        double result = numberRaisedResult(firstNumber, secondNumber);
        DecimalFormat df = new DecimalFormat("0.####");
        System.out.println(df.format(result));

    }

    public static double numberRaisedResult(double firstNumber, double secondNumber){
        return Math.pow(firstNumber, secondNumber);
    }
}
