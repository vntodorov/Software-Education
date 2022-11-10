package ExamPreparation.ElephantSanctuary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Habitat {

    private List<Elephant> data;

    private int capacity;

    public Habitat(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Elephant elephant) {

        if (data.size() < capacity) {
            data.add(elephant);
        }

    }

    public boolean remove(String name) {

        for (Elephant elephant : data) {
            if (elephant.getName().equals(name)) {
                data.remove(elephant);
                return true;
            }
        }

        return false;
    }

    public Elephant getElephant(String retiredFrom) {

        for (Elephant elephant : data) {
            if (elephant.getRetiredFrom().equals(retiredFrom)) {
                return elephant;
            }
        }

        return null;

    }

    public Elephant getOldestElephant() {

        return data.stream().sorted((f, s) -> Integer.compare(s.getAge(), f.getAge())).collect(Collectors.toList()).get(0);

    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("Saved elephants in the park:");
        report.append(System.lineSeparator());

        data.stream().forEach(e -> report.append(e.getName() + " came from: " + e.getRetiredFrom() + System.lineSeparator()));

        return report.toString();
    }


}
