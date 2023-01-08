package com.bookshop.demo.services.author;

import com.bookshop.demo.domain.entities.Author;
import com.bookshop.demo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public void seedAuthors(List<Author> authors) {
        this.authorRepository.saveAll(authors);
    }

    @Override
    public boolean isDataSeeded() {
        return this.authorRepository.count() > 0;
    }

    @Override
    public Author findRandomAuthorId() {
        long count = this.authorRepository.count();

        if (count != 0) {
            long randomAuthorId = new Random().nextLong(1, count);
            return this.authorRepository.findAuthorById(randomAuthorId).orElseThrow(NoSuchElementException::new);
        }

        throw new RuntimeException();
    }

    @Override
    public List<Author> findByFirstNameEndingWith(String endingWith) {
        return this.authorRepository.findByFirstNameEndingWith(endingWith);
    }
}
