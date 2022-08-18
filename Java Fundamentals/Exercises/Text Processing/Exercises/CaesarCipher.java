package TextProcessingEXERCISE;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(encryptedText(input));
    }

    public static StringBuilder encryptedText(String word) {
        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char currentSymbol = word.charAt(i);
            char newSymbol = (char) (currentSymbol + 3);
            newWord.append(newSymbol);
        }
        return newWord;
    }
}
