package com.bookshop.demo.services.author;

import com.bookshop.demo.domain.entities.Author;

import java.util.List;

public interface AuthorService {

    void seedAuthors(List<Author> authors);

    boolean isDataSeeded();

    Author findRandomAuthorId();

    List<Author> findByFirstNameEndingWith(String endingWith);



}
