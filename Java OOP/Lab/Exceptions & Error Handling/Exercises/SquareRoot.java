package ExceptionsAndErrorHandling;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try{
            System.out.printf("%.2f%n", sqrtResult(input));
        } catch (Exception e){
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }

    private static double sqrtResult (String input){
        int number = Integer.parseInt(input);

        if (number < 0){
            throw new NumberFormatException("Number should be positive!");
        }
        return Math.sqrt(number);
    }
}
