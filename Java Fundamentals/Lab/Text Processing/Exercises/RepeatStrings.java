package TextProcessingLAB;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        String newWord = "";
        for (String currentWord : words) {
            for (int j = 1; j <= currentWord.length(); j++) {
                newWord += currentWord;
            }
        }
        System.out.println(newWord);
    }
}
