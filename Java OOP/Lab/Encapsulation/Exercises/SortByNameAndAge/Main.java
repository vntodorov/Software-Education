package EncapsulationLAB.SortByNameAndAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] personData = scanner.nextLine().split("\\s+");
            String firstName = personData[0];
            String lastName = personData[1];
            int age = Integer.parseInt(personData[2]);
            Person person = new Person(firstName, lastName, age);
            people.add(person);
        }

        people.stream().sorted(Comparator.comparing(Person::getFirstName).thenComparingInt(Person::getAge)).forEach(System.out::println);

    }
}
