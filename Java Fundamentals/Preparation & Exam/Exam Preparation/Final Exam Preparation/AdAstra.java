package FinalExamEXERCISE;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int allCalories = 0;
        List<String> items = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\||#)(?<item>[A-Za-z\\s]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]+)\\1");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            allCalories += Integer.parseInt(matcher.group("calories"));
            String currentItem = matcher.group("item");
            String currentDate = matcher.group("date");
            int currentCalories = Integer.parseInt(matcher.group("calories"));
            items.add(String.format("Item: %s, Best before: %s, Nutrition: %d", currentItem, currentDate, currentCalories));

        }
        int daysToLast = allCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", daysToLast);
        items.forEach(System.out::println);
    }
}
