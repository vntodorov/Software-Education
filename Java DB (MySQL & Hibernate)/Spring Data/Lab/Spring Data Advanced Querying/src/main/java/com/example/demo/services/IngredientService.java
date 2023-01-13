package com.example.demo.services;

import com.example.demo.entities.Ingredient;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredientService {

    List<Ingredient> findByNameStartingWith(String letter);

    List<Ingredient> findByNameContaining(List<String> ingredients);


    void deleteByName(String name);

    void updateAllPrice();

}
