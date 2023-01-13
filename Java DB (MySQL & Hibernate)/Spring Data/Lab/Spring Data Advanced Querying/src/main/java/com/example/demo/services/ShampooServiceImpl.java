package com.example.demo.services;

import com.example.demo.entities.Shampoo;
import com.example.demo.entities.Size;
import com.example.demo.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findBySizeOrderById(String size) {
        Size parsed = Size.valueOf(size.toUpperCase());

        return shampooRepository.findBySizeOrderById(parsed);
    }

    @Override
    public List<Shampoo> findByIngredient(String ingredient) {
        return this.shampooRepository.findByIngredient(ingredient);
    }

    @Override
    public List<Shampoo> findByIngredients(List<String> ingredients) {
        return this.shampooRepository.findByIngredients(ingredients);
    }

    @Override
    public List<Shampoo> findBySizeOrLabelIdOrderByPrice(String size, long labelId) {
        Size parsed = Size.valueOf(size.toUpperCase());

        return this.shampooRepository.findBySizeOrLabelIdOrderByPrice(parsed, labelId);
    }

    @Override
    public List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price) {
        return this.shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public Long countByPriceLessThan(String price) {
        BigDecimal parsed = new BigDecimal(price);

        return this.shampooRepository.countByPriceLessThan(parsed);
    }

    @Override
    public List<Shampoo> findByIngredientsLessThan(int count) {
        return this.shampooRepository.findByIngredientsCountLessThan(count);
    }
}
