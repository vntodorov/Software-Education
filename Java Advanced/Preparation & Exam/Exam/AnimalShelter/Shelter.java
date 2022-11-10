package EXAM.AnimalShelter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shelter {

    private List<Animal> data;

    private int capacity;

    public Shelter(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Animal animal) {

        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {

        for (Animal animal : data) {
            if (animal.getName().equals(name)) {
                data.remove(animal);
                return true;
            }
        }

        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        return data.stream().filter(a -> a.getName().equals(name) && a.getCaretaker().equals(caretaker)).findFirst().orElse(null);
    }

    public Animal getOldestAnimal() {
        return data.stream().sorted((f, s) -> Integer.compare(s.getAge(), f.getAge())).collect(Collectors.toList()).get(0);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder report = new StringBuilder("The shelter has the following animals:");

        for (Animal animal : data) {
            report.append(System.lineSeparator())
                    .append(animal.getName() + " " + animal.getCaretaker());
        }

        return report.toString();

    }
}
