package RegularExpressionsEXERCISE;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> participantsInfo = new LinkedHashMap<>();
        List<String> participants = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        participants.forEach(participant -> participantsInfo.put(participant, 0));
        Pattern namePattern = Pattern.compile("[A-Za-z]+");
        Pattern kilometersPattern = Pattern.compile("[0-9]");
        String input = scanner.nextLine();
        while (!input.equals("end of race")){
            Matcher nameMatcher = namePattern.matcher(input);
            StringBuilder nameBuilder = new StringBuilder();
            while (nameMatcher.find()){
                nameBuilder.append(nameMatcher.group());
            }
            String currentName = nameBuilder.toString();
            Matcher kilometersMatcher = kilometersPattern.matcher(input);
            int currentKilometers = 0;
            while (kilometersMatcher.find()){
                currentKilometers += Integer.parseInt(kilometersMatcher.group());
            }
            if (participants.contains(currentName)){
                int newKilometers = participantsInfo.get(currentName) + currentKilometers;
                participantsInfo.put(currentName, newKilometers);
            }
            input = scanner.nextLine();
        }
        List<String> firstOfThree = participantsInfo.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        System.out.println("1st place: " + firstOfThree.get(0));
        System.out.println("2nd place: " + firstOfThree.get(1));
        System.out.println("3rd place: " + firstOfThree.get(2));
    }
}
