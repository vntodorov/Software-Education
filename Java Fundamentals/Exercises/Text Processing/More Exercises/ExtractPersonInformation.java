package TextProcessing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> peopleInfo = new LinkedHashMap<>();
        int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= lines; i++) {
            String input = scanner.nextLine();
            int firstIndex = input.indexOf("@");
            int secondIndex = input.indexOf("|");
            int thirdIndex = input.indexOf("#");
            int fourthIndex = input.indexOf("*");
            String name = input.substring(firstIndex + 1, secondIndex);
            int age = Integer.parseInt(input.substring(thirdIndex + 1, fourthIndex));
            peopleInfo.put(name, age);
        }
        peopleInfo.entrySet().forEach(person -> System.out.printf("%s is %d years old.%n", person.getKey(), person.getValue()));
    }
}
