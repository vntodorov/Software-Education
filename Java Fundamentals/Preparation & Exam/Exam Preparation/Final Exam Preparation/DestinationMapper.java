package FinalExamEXERCISE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> destinations = new ArrayList<>();
        int sum = 0;
        Pattern pattern = Pattern.compile("(=|\\/)(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            String currentDestination = matcher.group("destination");
            destinations.add(currentDestination);
            sum += currentDestination.length();
        }
        System.out.println("Destinations: " + String.join(", ", destinations));
        System.out.printf("Travel Points: %d", sum);
    }
}
