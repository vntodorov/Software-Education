package MethodsEXERCISE;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        printMiddleCharacter(word);

    }

    public static void printMiddleCharacter(String word){
        if (word.length() % 2 != 0){
            char middleSymbol = word.charAt(word.length() / 2);
            System.out.println(middleSymbol);
        } else {
            char firstMiddleSymbol = word.charAt(word.length() / 2 - 1);
            char secondMiddleSymbol = word.charAt(word.length() / 2);
            System.out.printf("%c%c", firstMiddleSymbol, secondMiddleSymbol);
        }
    }
}
