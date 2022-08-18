package TextProcessingEXERCISE;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        String[] input = scanner.nextLine().split("\\s+");
        for (String currentElement : input) {
            result += numbersGame(currentElement);
        }
        System.out.printf("%.2f", result);
    }

    public static double numbersGame (String word) {
        StringBuilder numberInString = new StringBuilder();
        char firstSymbol = word.charAt(0);
        char lastSymbol = word.charAt(word.length() - 1);
        double number = Double.parseDouble(
                word.replace(firstSymbol, ' ')
                        .replace(lastSymbol, ' ')
                        .trim());
        int operationNumber = 0;
        if (firstSymbol >= 'A' && firstSymbol <= 'Z'){
            operationNumber = firstSymbol - 64;
            number /= operationNumber;
        } else {
            operationNumber = firstSymbol - 96;
            number *= operationNumber;
        }
        if (lastSymbol >= 'A' && lastSymbol <= 'Z'){
            operationNumber = lastSymbol - 64;
            number -= operationNumber;
        } else {
            operationNumber = lastSymbol - 96;
            number += operationNumber;
        }
        return number;
    }
}