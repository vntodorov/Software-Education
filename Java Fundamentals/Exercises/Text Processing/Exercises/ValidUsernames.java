package TextProcessingEXERCISE;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(", ");
        for (String currentWord : words) {
            if (isValid(currentWord)){
                System.out.println(currentWord);;
            }
        }
    }

    public static boolean isValid(String username) {
        if (username.length() >= 3 && username.length() <= 16) {
            for (int j = 0; j < username.length(); j++) {
                char currentSymbol = username.charAt(j);
                if (!Character.isLetterOrDigit(currentSymbol) && currentSymbol != '_' && currentSymbol != '-') {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}