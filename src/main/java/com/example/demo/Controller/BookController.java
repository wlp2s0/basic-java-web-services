package com.example.demo.Controller;

import com.example.demo.Entity.Book;
import com.example.demo.Service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/api/v1/book")
    public Book createBook(@RequestBody Book book) {
        return bookService.create(book);
    }

    @GetMapping("/api/v1/book")
    public List<Book> retrieveAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/api/v1/book/{id}")
    public ResponseEntity<Book> retrieveBook(@PathVariable Integer id) {
        return bookService.retrieveBook(id);
    }

    @PutMapping("/api/v1/book/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book updatedBook, @PathVariable Integer id) {
        return bookService.updateBook(updatedBook, id);
    }

    @DeleteMapping("/api/v1/book/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id) {
        return bookService.deleteBook(id);
    }
}
