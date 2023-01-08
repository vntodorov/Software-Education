package com.bookshop.demo.repositories;

import com.bookshop.demo.domain.dto.BookInformation;
import com.bookshop.demo.domain.entities.Book;
import com.bookshop.demo.domain.enums.AgeRestriction;
import com.bookshop.demo.domain.enums.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal greater);

    List<Book> findAllByReleaseDateNot(LocalDate date);

    List<Book> findByReleaseDateBefore(LocalDate date);

    List<Book> findByTitleContainingIgnoreCase(String contain);

    @Query("SELECT b FROM Book b WHERE b.author.lastName LIKE :startingWith%")
    List<Book> findByBookAuthorNameStartingWith(String startingWith);

    @Query("SELECT COUNT(b) FROM Book AS b WHERE CHAR_LENGTH(b.title) > :length")
    Long findCountByTitleLongerThan(int length);

    @Query("SELECT new com.bookshop.demo.domain.dto.BookInformation(b.title, b.editionType, b.ageRestriction, b.price) FROM Book b WHERE b.title = :title")
    BookInformation findFirstByTitle(String title);

    @Query("UPDATE Book AS b SET b.copies = b.copies + :copies WHERE b.releaseDate > :date")
    @Modifying
    int increaseBookCopies(LocalDate date, int copies);

    @Query("DELETE Book AS b WHERE b.copies < :copies")
    @Modifying
    int deleteBookByCopiesLowerThan(int copies);

    @Procedure
    int AuthorTotalBooks(String firstName, String lastName);

}
