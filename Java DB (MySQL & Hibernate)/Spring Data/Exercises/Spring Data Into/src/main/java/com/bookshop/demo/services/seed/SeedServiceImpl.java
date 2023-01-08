package com.bookshop.demo.services.seed;

import com.bookshop.demo.domain.entities.Author;
import com.bookshop.demo.domain.entities.Book;
import com.bookshop.demo.domain.entities.Category;
import com.bookshop.demo.domain.enums.AgeRestriction;
import com.bookshop.demo.domain.enums.EditionType;
import com.bookshop.demo.services.author.AuthorService;
import com.bookshop.demo.services.book.BookService;
import com.bookshop.demo.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bookshop.demo.Constants.FilePath.*;

@Service
public class SeedServiceImpl implements SeedService {

    private final BookService bookService;

    private final AuthorService authorService;

    private final CategoryService categoryService;

    @Autowired
    public SeedServiceImpl(BookService bookService, AuthorService authorService, CategoryService categoryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }


    @Override
    public void seedAuthors() throws IOException {
        if (!this.authorService.isDataSeeded()) {
            this.authorService.seedAuthors(Files.readAllLines(Path.of(RESOURCE_URL + AUTHOR_FILE))
                    .stream().filter(a -> !a.isBlank())
                    .map(a -> Author.builder()
                            .firstName(a.split(" ")[0])
                            .lastName(a.split(" ")[1])
                            .build())
                    .collect(Collectors.toList()));

        }
    }

    @Override
    public void seedBooks() throws IOException {
        if (!bookService.isDataSeeded()) {
            this.bookService.seedBooks(Files.readAllLines(Path.of(RESOURCE_URL + BOOK_FILE))
                    .stream()
                    .map(line -> {
                                String[] data = line.split("\\s+");

                                Author author = this.authorService.findRandomAuthorId();

                                EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];

                                LocalDate releaseDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));

                                int copies = Integer.parseInt(data[2]);

                                BigDecimal price = new BigDecimal(data[3]);

                                AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];

                                String title = Arrays.stream(data).skip(5).collect(Collectors.joining(" "));

                                Set<Category> categories = categoryService.getRandomCategories();

                                return Book.builder()
                                        .author(author)
                                        .editionType(editionType)
                                        .releaseDate(releaseDate)
                                        .copies(copies)
                                        .price(price)
                                        .ageRestriction(ageRestriction)
                                        .title(title)
                                        .categories(categories).build();
                            }
                    ).collect(Collectors.toList()));
        }
    }

    @Override
    public void seedCategory() throws IOException {
        if (!categoryService.isDataSeeded()) {
            this.categoryService.seedCategories(
                    Files.readAllLines(Path.of(RESOURCE_URL + CATEGORY_FILE))
                            .stream()
                            .filter(c -> !c.isBlank())
                            .map(categoryName -> Category.builder().name(categoryName).build())
                            .collect(Collectors.toList()));
        }
    }
}
