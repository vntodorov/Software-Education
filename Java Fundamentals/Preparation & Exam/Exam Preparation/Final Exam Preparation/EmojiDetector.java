package FinalExamEXERCISE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern emojiPattern = Pattern.compile("(\\:\\:|\\*\\*)[A-Z][a-z]{2,}\\1");
        long thresholdAmount = thresholdAmount(input);
        int emojiCount = 0;
        List<String> coolEmojis = new ArrayList<>();
        Matcher emojiMatcher = emojiPattern.matcher(input);
        while (emojiMatcher.find()) {
            emojiCount++;
            long currentCoolness = emojiCoolness(emojiMatcher.group());
            if (currentCoolness > thresholdAmount) {
                coolEmojis.add(emojiMatcher.group());
            }
        }
        System.out.printf("Cool threshold: %d%n", thresholdAmount);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojiCount);
        coolEmojis.forEach(System.out::println);
    }

    public static long emojiCoolness(String emoji) {
        Pattern coolnessPattern = Pattern.compile("[A-Za-z]");
        Matcher coolnessMatcher = coolnessPattern.matcher(emoji);
        long coolnessAmount = 0;
        while (coolnessMatcher.find()) {
            char currentSymbol = coolnessMatcher.group().charAt(0);
            coolnessAmount += currentSymbol;
        }
        return coolnessAmount;
    }


    public static long thresholdAmount(String input) {
        Pattern thresholdPattern = Pattern.compile("\\d");
        long thresholdAmount = 1;
        Matcher thresholdMatcher = thresholdPattern.matcher(input);
        while (thresholdMatcher.find()) {
            thresholdAmount *= Long.parseLong(thresholdMatcher.group());
        }
        return thresholdAmount;

    }
}
