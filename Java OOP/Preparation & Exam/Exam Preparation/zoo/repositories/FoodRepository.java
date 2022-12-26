package ExamPreparation.zoo.repositories;

import ExamPreparation.zoo.entities.foods.Food;

public interface FoodRepository {
    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
