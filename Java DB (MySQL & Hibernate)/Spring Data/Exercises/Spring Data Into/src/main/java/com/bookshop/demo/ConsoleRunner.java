package com.bookshop.demo;

import com.bookshop.demo.domain.entities.Author;
import com.bookshop.demo.domain.entities.Book;
import com.bookshop.demo.services.author.AuthorService;
import com.bookshop.demo.services.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final BookService bookService;

    private final AuthorService authorService;


    @Autowired
    public ConsoleRunner(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        String[] fullName = scanner.nextLine().split(" ");

        System.out.println(this.bookService.AuthorTotalBooks(fullName[0], fullName[1]));

    }

}
