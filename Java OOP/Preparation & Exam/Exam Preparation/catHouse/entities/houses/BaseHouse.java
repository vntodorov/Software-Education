package ExamPreparation.catHouse.entities.houses;

import static ExamPreparation.catHouse.common.ExceptionMessages.*;

import static ExamPreparation.catHouse.common.ConstantMessages.*;

import ExamPreparation.catHouse.entities.cat.Cat;
import ExamPreparation.catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseHouse implements House {

    private String name;

    private int capacity;

    private Collection<Toy> toys;

    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        toys = new ArrayList<>();
        cats = new ArrayList<>();

    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int sumSoftness() {
        return toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (cats.size() + 1 > capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("%s %s:", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Cats: ");
        if (cats.isEmpty()) {
            out.append("none").append(System.lineSeparator());
        } else {
            out.append(String.join(" ", cats.stream().map(Cat::getName).collect(Collectors.toList())))
                    .append(System.lineSeparator());
        }
        out.append(String.format("Toys: %d Softness: %d", toys.size(), sumSoftness()));

        return out.toString().trim();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }
}
