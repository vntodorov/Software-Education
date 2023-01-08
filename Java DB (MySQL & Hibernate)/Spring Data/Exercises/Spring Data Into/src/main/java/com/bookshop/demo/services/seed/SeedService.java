package com.bookshop.demo.services.seed;

import java.io.IOException;

public interface SeedService {

    void seedAuthors() throws IOException;

    void seedBooks() throws IOException;

    void seedCategory() throws IOException;

    default void seedAllData() throws IOException {
        seedAuthors();
        seedCategory();
        seedBooks();
    }
}
