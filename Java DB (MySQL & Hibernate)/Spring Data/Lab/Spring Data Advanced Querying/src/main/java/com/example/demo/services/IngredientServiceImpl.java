package com.example.demo.services;

import com.example.demo.entities.Ingredient;
import com.example.demo.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findByNameStartingWith(String letter) {
        return this.ingredientRepository.findByNameStartingWith(letter);
    }

    @Override
    public List<Ingredient> findByNameContaining(List<String> ingredients) {
        return this.ingredientRepository.findByNameContaining(ingredients);
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        this.ingredientRepository.deleteByName(name);
    }

    @Override
    @Transactional
    public void updateAllPrice() {
        this.ingredientRepository.updateAllPrice();
    }
}
