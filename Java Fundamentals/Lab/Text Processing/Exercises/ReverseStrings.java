package TextProcessingLAB;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        while (!word.equals("end")){
            String reversedWord = "";
            for (int i = word.length() - 1; i >= 0 ; i--) {
                char currentLetter = word.charAt(i);
                reversedWord += currentLetter;
            }
            System.out.printf("%s = %s%n", word, reversedWord);
            word = scanner.nextLine();
        }
    }
}
