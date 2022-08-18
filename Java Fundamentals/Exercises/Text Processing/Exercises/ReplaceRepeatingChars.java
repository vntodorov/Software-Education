package TextProcessingEXERCISE;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder newWord = new StringBuilder();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length() - 1; i++) {
            char currentSymbol = input.charAt(i);
            if (currentSymbol != input.charAt(i + 1)) {
                newWord.append(currentSymbol);
            }
        }
        newWord.append(input.charAt(input.length() - 1));
        System.out.println(newWord);
    }
}
