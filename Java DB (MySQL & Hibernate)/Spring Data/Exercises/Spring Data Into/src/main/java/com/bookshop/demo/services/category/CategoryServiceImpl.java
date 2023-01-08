package com.bookshop.demo.services.category;

import com.bookshop.demo.domain.entities.Category;
import com.bookshop.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories(List<Category> categories) {
        this.categoryRepository.saveAll(categories);
    }

    @Override
    public boolean isDataSeeded() {
        return this.categoryRepository.count() > 0;
    }

    @Override
    public Set<Category> getRandomCategories() {
        long count = this.categoryRepository.count();

        if (count != 0) {
            long randomCategoryId = new Random().nextLong(1, count);
            return Set.of(this.categoryRepository.findById(randomCategoryId).orElseThrow(NoSuchElementException::new));
        }

        throw new RuntimeException();
    }
}
