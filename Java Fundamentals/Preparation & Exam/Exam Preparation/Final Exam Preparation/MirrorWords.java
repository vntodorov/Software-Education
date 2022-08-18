package FinalExamEXERCISE;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int wordsCount = 0;
        List<String> mirrorWords = new ArrayList<>();
        Pattern pattern = Pattern.compile("(@|#)(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(word);
        while (matcher.find()) {
            String firstWord = matcher.group("wordOne");
            String secondWord = matcher.group("wordTwo");
            StringBuilder newWord = new StringBuilder(secondWord).reverse();
            if (firstWord.equals(newWord.toString())) {
                mirrorWords.add(firstWord + " <=> " + secondWord);
            }
            wordsCount++;
        }

        if (wordsCount > 0) {
            System.out.printf("%d word pairs found!%n", wordsCount);
        } else {
            System.out.println("No word pairs found!");
        }

        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorWords));
        }
    }
}

