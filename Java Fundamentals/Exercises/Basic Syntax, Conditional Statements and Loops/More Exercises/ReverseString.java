package BasicSyntax;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String newWord = "";
        for (int i = word.length() - 1; i >= 0 ; i--) {
            char currentSymbol = word.charAt(i);
            newWord += currentSymbol;
        }
        System.out.println(newWord);
    }
}
