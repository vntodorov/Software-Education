package com.bookshop.demo.services.book;

import com.bookshop.demo.domain.dto.BookInformation;
import com.bookshop.demo.domain.entities.Author;
import com.bookshop.demo.domain.entities.Book;
import com.bookshop.demo.domain.enums.AgeRestriction;
import com.bookshop.demo.domain.enums.EditionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookService {

    void seedBooks(List<Book> books);

    boolean isDataSeeded();

    List<Book> findByAgeRestriction(String age);

    List<Book> findByEditionTypeAndCopiesLessThan(String edition, int copies);

    List<Book> findByPriceLessThanOrPriceGreaterThan(int lower, int greater);

    List<Book> findAllByReleaseDateNot(LocalDate date);

    List<Book> findByReleaseDateBefore(LocalDate date);

    List<Book> findByTitleContainingIgnoreCase(String contain);

    List<Book> findByBookAuthorNameStartingWith(String startingWith);

    Long findCountByTitleLongerThan(int length);

    BookInformation findFirstByTitle(String title);

    int increaseBookCopies(LocalDate date, int copies);

    int deleteBookByCopiesLowerThan(int copies);

    int AuthorTotalBooks(String firstName, String lastName);













}
