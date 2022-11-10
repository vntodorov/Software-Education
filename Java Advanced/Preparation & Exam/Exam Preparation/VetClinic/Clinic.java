package ExamPreparation.VetClinic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {

    private List<Pet> data;

    private int capacity;

    public Clinic(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {

        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {

        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                data.remove(pet);
                return true;
            }
        }

        return false;
    }

    public Pet getPet(String name, String owner) {
        return data.stream().filter(p -> p.getName().equals(name) && p.getOwner().equals(owner)).findFirst().orElse(null);
    }

    public Pet getOldestPet() {
        return data.stream().sorted((f, s) -> Integer.compare(s.getAge(), f.getAge())).collect(Collectors.toList()).get(0);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics(){
        StringBuilder report = new StringBuilder("The clinic has the following patients:");

        for (Pet pet : data){
            report.append(System.lineSeparator())
                    .append(pet.getName() + " " + pet.getOwner());
        }

        return report.toString();
    }
}
