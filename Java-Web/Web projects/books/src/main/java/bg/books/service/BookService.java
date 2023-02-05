package bg.books.service;

import bg.books.model.DTOs.AuthorDTO;
import bg.books.model.DTOs.BookDTO;
import bg.books.model.entity.BookEntity;
import bg.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<BookDTO> getBookById(Long bookId) {
        return this.bookRepository
                .findById(bookId)
                .map(this::mapToBookDTO);
    }

    public List<BookDTO> getAllBooks(){
        return bookRepository.findAll()
                .stream()
                .map(this::mapToBookDTO)
                .toList();
    }

    private BookDTO mapToBookDTO(BookEntity book) {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setAuthor(new AuthorDTO(book.getAuthor()));

        return bookDTO;

    }
}
