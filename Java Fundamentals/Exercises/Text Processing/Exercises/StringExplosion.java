package TextProcessingEXERCISE;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalStrength = 0;
        String input = scanner.nextLine();
        StringBuilder newWord = new StringBuilder(input);
        for (int i = 0; i < newWord.length() ; i++) {
            char currentSymbol = newWord.charAt(i);
            if (currentSymbol == '>'){
                int strength = Integer.parseInt(newWord.charAt(i + 1) + "");
                totalStrength += strength;
            } else if (totalStrength > 0){
                newWord.deleteCharAt(i);
                totalStrength--;
                i--;
            }
        }
        System.out.println(newWord);
    }
}
