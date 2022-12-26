package ExamPreparation.zoo.entities.areas;

import static ExamPreparation.zoo.common.ExceptionMessages.*;

import ExamPreparation.zoo.entities.animals.Animal;
import ExamPreparation.zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseArea implements Area {

    private String name;

    private int capacity;

    private Collection<Food> foods;

    private Collection<Animal> animals;

    protected BaseArea(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        foods = new ArrayList<>();
        animals = new ArrayList<>();
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    @Override
    public int sumCalories() {
        return foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animals.size() + 1 > capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        animals.forEach(Animal::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder out = new StringBuilder();

        out.append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Animals: ");

        if (animals.isEmpty()) {
            out.append("none");
        } else {
            out.append(String.join(" ", animals.stream().map(Animal::getName).collect(Collectors.toList())));
        }

        out.append(System.lineSeparator())
                .append("Foods: ")
                .append(foods.size())
                .append(System.lineSeparator())
                .append("Calories: ")
                .append(sumCalories());

        return out.toString().trim();
    }
}
