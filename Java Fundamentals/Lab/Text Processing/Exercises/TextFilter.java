package TextProcessingLAB;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(", ");
        String input = scanner.nextLine();
        for (String currentBannedWord : bannedWords){
            String replacement = replacementCount(currentBannedWord);
            input = input.replace(currentBannedWord, replacement);
        }
        System.out.println(input);
    }

    public static String replacementCount (String word){
        String replacement = "";
        for (int i = 0; i < word.length() ; i++) {
            replacement += "*";
        }
        return  replacement;
    }
}
