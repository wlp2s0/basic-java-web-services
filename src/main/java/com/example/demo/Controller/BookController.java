package com.example.demo.Controller;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController()
public class BookController {


    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/api/v1/book")
    public Book createBook(@RequestBody Book book) {
        Integer id = bookRepository.createBook(book.getTitle(), book.getAuthor(), book.getRating());
        return bookRepository.findBook(id);
    }

    @GetMapping("/api/v1/book")
    public Collection<Book> retrieveAllBooks() {
        return bookRepository.findAllBooks();
    }

    @GetMapping("/api/v1/book/{id}")
    public Book retrieveBook(@PathVariable Integer id) {
        return bookRepository.findBook(id);
    }

    @PutMapping("/api/v1/book/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Integer id) {
        bookRepository.updateBook(id, book.getTitle(), book.getAuthor(), book.getRating());
        return bookRepository.findBook(id);
    }

    @DeleteMapping("/api/v1/book/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id) {
        bookRepository.deleteBook(id);
        return ResponseEntity.ok("ok");
        // return bookService.deleteBook(id);
    }
}
