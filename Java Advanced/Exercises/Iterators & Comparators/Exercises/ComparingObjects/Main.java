package IteratorsAndComparatorsEXERCISES.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Person> people = new ArrayList<>();

        while (!input.equals("END")){

            String[] data = input.split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String town = data[2];
            Person currentPerson = new Person(name, age, town);
            people.add(currentPerson);
            input = scanner.nextLine();
        }

        int indexOfPerson = Integer.parseInt(scanner.nextLine());
        int equal = 0;
        int notEqual = 0;

        for (Person person : people){
            int result = person.compareTo(people.get(indexOfPerson - 1));
            if (result == 0){
                equal++;
            } else {
                notEqual++;
            }
        }

        if (equal <= 1){
            System.out.println("No matches");
        } else {
            System.out.print(equal + " " + notEqual + " " + people.size());
        }


    }
}
