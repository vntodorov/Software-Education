package TextProcessingLAB;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstWord = scanner.nextLine();
        String secondWord = scanner.nextLine();
        while (secondWord.contains(firstWord)){
            secondWord = secondWord.replace(firstWord, "");
        }
        System.out.println(secondWord);
    }
}
