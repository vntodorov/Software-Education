package TextProcessingEXERCISE;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String firstWord = input.split(" ")[0];
        String secondWord = input.split(" ")[1];
        System.out.println(sumOfCharacters(firstWord, secondWord));
    }

    public static int sumOfCharacters (String firstWord, String secondWord){
        int result = 0;
        int smallerWord = Math.min(firstWord.length(), secondWord.length());
        for (int i = 0; i < smallerWord; i++) {
            char firstSymbol = firstWord.charAt(i);
            char secondSymbol = secondWord.charAt(i);
            result += firstSymbol * secondSymbol;
        }
        if (firstWord.length() > secondWord.length()){
            for (int i = smallerWord; i < firstWord.length() ; i++) {
                char currentSymbol = firstWord.charAt(i);
                result += currentSymbol;
            }
        } else if (secondWord.length() > firstWord.length()){
            for (int i = smallerWord; i < secondWord.length() ; i++) {
                char currentSymbol = secondWord.charAt(i);
                result += currentSymbol;
            }
        }
        return result;
    }
}
