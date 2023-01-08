package com.bookshop.demo.services.category;

import com.bookshop.demo.domain.entities.Book;
import com.bookshop.demo.domain.entities.Category;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CategoryService {

    void seedCategories(List<Category> categories);

    boolean isDataSeeded();

    Set<Category> getRandomCategories();
}
