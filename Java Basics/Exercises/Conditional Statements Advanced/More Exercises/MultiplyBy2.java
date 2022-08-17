package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class MultiplyBy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());
        while (!(number < 0)){
            double result = number * 2;
            System.out.printf("Result: %.2f%n", result);
            number = Double.parseDouble(scanner.nextLine());
        }
        System.out.println("Negative number!");
    }
}
