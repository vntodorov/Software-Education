package EncapsulationLAB.SalaryIncrease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] personData = scanner.nextLine().split("\\s+");
            people.add(new Person(personData[0], personData[1], Integer.parseInt(personData[2]), Double.parseDouble(personData[3])));
        }

        double percent = Double.parseDouble(scanner.nextLine());
        people.forEach(p -> p.increaseSalary(percent));
        people.forEach(System.out::println);

    }
}
