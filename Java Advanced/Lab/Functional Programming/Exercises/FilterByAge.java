package FunctionalProgrammingLAB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {

    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());

        List<Person> allPeople = new ArrayList<>();

        for (int i = 0; i < people; i++) {

            String[] data = scanner.nextLine().split("\\,\\s");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person currentPerson = new Person(name, age);
            allPeople.add(currentPerson);


        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Person> ageFilter = getFilter(condition, age);

        Consumer<Person> printer = getPrinter(format);


        allPeople.stream()
                .filter(ageFilter)
                .forEach(printer);


    }

    private static Consumer<Person> getPrinter(String format) {

        switch (format) {
            case "name":
                return p -> System.out.println(p.name);
            case "age":
                return p -> System.out.println(p.age);
            case "name age":
                return p -> System.out.println(p.name + " - " + p.age);
            default:
                throw new IllegalArgumentException("Unknown format " + format);
        }


    }

    private static Predicate<Person> getFilter(String condition, int ageFilter) {

        switch (condition) {
            case "older":
                return p -> p.age >= ageFilter;
            case "younger":
                return p -> p.age <= ageFilter;
            default:
                throw new IllegalArgumentException("Unknown condition " + condition);
        }

    }
}
