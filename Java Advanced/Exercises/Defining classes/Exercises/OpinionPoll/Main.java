package DefiningClassesEXERCISES.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String[] personData = scanner.nextLine().split("\\s+");

            String currentName = personData[0];
            int currentAge = Integer.parseInt(personData[1]);

            Person person = new Person(currentName, currentAge);

            people.add(person);

        }

        people.stream()
                .filter(p -> p.getAge() > 30)
                .sorted((left, right) -> left.getName().compareTo(right.getName()))
                .forEach(System.out::println);

    }
}
