package FinalEXAM;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^(\\$|\\%)(?<message>[A-Z][a-z]{2,})\\1: \\[(?<first>[0-9]+)\\]\\|\\[(?<second>[0-9]+)\\]\\|\\[(?<third>[0-9]+)\\]\\|$");
        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= lines; i++) {
            String message = scanner.nextLine();
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()){
                String word = matcher.group("message");

                char first = (char) Integer.parseInt(matcher.group("first"));
                char second = (char) Integer.parseInt(matcher.group("second"));
                char third = (char) Integer.parseInt(matcher.group("third"));

                System.out.println(word + ": " + first + second + third);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}

