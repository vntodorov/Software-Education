package MethodsEXERCISE;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        printVowelsCount(word);
    }

    public static void printVowelsCount(String word){
        int vowelsCount = 0;
        for (int i = 0; i < word.length() ; i++) {
            char currentSymbol = word.charAt(i);
            switch (currentSymbol){
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowelsCount++;
                    break;
            }
        }
        System.out.println(vowelsCount);
    }
}
