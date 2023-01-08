package com.bookshop.demo.repositories;

import com.bookshop.demo.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findAuthorById(long id);

    List<Author> findByFirstNameEndingWith(String endingWith);
}
