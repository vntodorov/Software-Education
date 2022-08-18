package MethodsEXERCISE;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstCharacter = scanner.nextLine().charAt(0);
        char secondCharacter = scanner.nextLine().charAt(0);
        printAllCharactersInBetween(firstCharacter, secondCharacter);

    }

    public static void printAllCharactersInBetween(char first, char second){
        for (int i = first + 1; i < second ; i++) {
            System.out.printf("%c ", i);
        }
        for (int i = second + 1; i < first ; i++) {
            System.out.printf("%c ", i);
        }
    }
}
