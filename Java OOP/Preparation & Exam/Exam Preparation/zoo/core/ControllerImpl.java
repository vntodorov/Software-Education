package ExamPreparation.zoo.core;

import static ExamPreparation.zoo.common.ExceptionMessages.*;
import static ExamPreparation.zoo.common.ConstantMessages.*;

import ExamPreparation.zoo.entities.animals.Animal;
import ExamPreparation.zoo.entities.animals.AquaticAnimal;
import ExamPreparation.zoo.entities.animals.TerrestrialAnimal;
import ExamPreparation.zoo.entities.areas.Area;
import ExamPreparation.zoo.entities.areas.LandArea;
import ExamPreparation.zoo.entities.areas.WaterArea;
import ExamPreparation.zoo.entities.foods.Food;
import ExamPreparation.zoo.entities.foods.Meat;
import ExamPreparation.zoo.entities.foods.Vegetable;
import ExamPreparation.zoo.repositories.FoodRepository;
import ExamPreparation.zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;

    private Collection<Area> areas;

    public ControllerImpl() {
        foodRepository = new FoodRepositoryImpl();
        areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        switch (areaType) {
            case "WaterArea":
                area = new WaterArea(areaName);
                areas.add(area);
                break;
            case "LandArea":
                area = new LandArea(areaName);
                areas.add(area);
                break;
            default:
                throw new NullPointerException(INVALID_AREA_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        switch (foodType) {
            case "Vegetable":
                food = new Vegetable();
                foodRepository.add(food);
                break;
            case "Meat":
                food = new Meat();
                foodRepository.add(food);
                break;
            default:
                throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Area neededArea = findAreaByName(areaName);

        Food neededFood = foodRepository.findByType(foodType);
        if (neededFood == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }

        neededArea.addFood(neededFood);
        foodRepository.remove(neededFood);
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);

    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Area neededArea = findAreaByName(areaName);

        Animal animal;

        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName, kind, price);
                break;
            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName, kind, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }

        if ((neededArea.getClass().getSimpleName().equals("WaterArea") && animalType.equals("AquaticAnimal"))
                || (neededArea.getClass().getSimpleName().equals("LandArea") && animalType.equals("TerrestrialAnimal"))) {
            neededArea.addAnimal(animal);
        } else {
            return AREA_NOT_SUITABLE;
        }

        return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);

    }

    @Override
    public String feedAnimal(String areaName) {
        Area neededArea = findAreaByName(areaName);
        neededArea.feed();
        return String.format(ANIMALS_FED, neededArea.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area neededArea = findAreaByName(areaName);
        double sumKg = neededArea.getAnimals().stream().mapToDouble(Animal::getKg).sum();
        return String.format(KILOGRAMS_AREA, areaName, sumKg);
    }

    @Override
    public String getStatistics() {
        StringBuilder out = new StringBuilder();
        for (Area area : areas) {
            out.append(area.getInfo()).append(System.lineSeparator());
        }
        return out.toString().trim();
    }


    private Area findAreaByName(String areaName) {
        return areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);
    }
}
