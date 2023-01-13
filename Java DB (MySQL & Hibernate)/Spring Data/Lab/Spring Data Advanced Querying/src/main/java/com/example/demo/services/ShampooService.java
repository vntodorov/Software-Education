package com.example.demo.services;

import com.example.demo.entities.Shampoo;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {

    List<Shampoo> findBySizeOrderById(String size);

    List<Shampoo> findByIngredient(String ingredient);

    List<Shampoo> findByIngredients(List<String> ingredients);

    List<Shampoo> findBySizeOrLabelIdOrderByPrice(String size, long labelId);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    Long countByPriceLessThan(String price);

    List<Shampoo> findByIngredientsLessThan(int count);



}
