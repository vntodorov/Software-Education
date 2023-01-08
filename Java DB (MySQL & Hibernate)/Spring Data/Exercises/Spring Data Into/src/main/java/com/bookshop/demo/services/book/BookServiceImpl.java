package com.bookshop.demo.services.book;

import com.bookshop.demo.domain.dto.BookInformation;
import com.bookshop.demo.domain.entities.Book;
import com.bookshop.demo.domain.enums.AgeRestriction;
import com.bookshop.demo.domain.enums.EditionType;
import com.bookshop.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public void seedBooks(List<Book> books) {
        this.bookRepository.saveAll(books);
    }

    @Override
    public boolean isDataSeeded() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public List<Book> findByAgeRestriction(String age) {
        AgeRestriction ageRestriction = AgeRestriction.valueOf(age.toUpperCase());

        return this.bookRepository.findByAgeRestriction(ageRestriction);
    }

    @Override
    public List<Book> findByEditionTypeAndCopiesLessThan(String edition, int copies) {
        EditionType editionType = EditionType.valueOf(edition);

        return this.bookRepository.findByEditionTypeAndCopiesLessThan(editionType, copies);
    }

    @Override
    public List<Book> findByPriceLessThanOrPriceGreaterThan(int lower, int greater) {
        BigDecimal lowerBD = new BigDecimal(lower);
        BigDecimal greaterDB = new BigDecimal(greater);

        return this.bookRepository.findByPriceLessThanOrPriceGreaterThan(lowerBD, greaterDB);
    }

    @Override
    public List<Book> findAllByReleaseDateNot(LocalDate date) {
        return this.bookRepository.findAllByReleaseDateNot(date);
    }

    @Override
    public List<Book> findByReleaseDateBefore(LocalDate date) {
        return this.bookRepository.findByReleaseDateBefore(date);
    }

    @Override
    public List<Book> findByTitleContainingIgnoreCase(String contain) {
        return this.bookRepository.findByTitleContainingIgnoreCase(contain);
    }

    @Override
    public List<Book> findByBookAuthorNameStartingWith(String startingWith) {
        return this.bookRepository.findByBookAuthorNameStartingWith(startingWith);
    }

    @Override
    public Long findCountByTitleLongerThan(int length) {
        return this.bookRepository.findCountByTitleLongerThan(length);
    }

    @Override
    public BookInformation findFirstByTitle(String title) {
        return this.bookRepository.findFirstByTitle(title);
    }

    @Override
    @Transactional
    public int increaseBookCopies(LocalDate date, int copies) {
        return this.bookRepository.increaseBookCopies(date, copies);
    }

    @Override
    @Transactional
    public int deleteBookByCopiesLowerThan(int copies) {
        return this.bookRepository.deleteBookByCopiesLowerThan(copies);
    }

    @Override
    public int AuthorTotalBooks(String firstName, String lastName) {
        return this.bookRepository.AuthorTotalBooks(firstName, lastName);
    }


}
