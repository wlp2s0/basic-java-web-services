package com.example.demo.Service;

import com.example.demo.Controller.Response;
import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book create(Book book) {
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public ResponseEntity<Book> retrieveBook(Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()) {
            return ResponseEntity.of(bookRepository.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Book> updateBook(Book updatedBook, Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(!bookOptional.isPresent()){
            return ResponseEntity.notFound().build();
        } else {
            Book book = bookOptional.get();
            // book.setId(id);
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setRating(updatedBook.getRating());
            bookRepository.save(book);
            return ResponseEntity.of(bookRepository.findById(id));
        }
    }

    public ResponseEntity deleteBook(Integer id) {
        bookRepository.deleteById(id);
        Response response = new Response();
        response.setMessage("Book Successfully Deleted");
        return ResponseEntity.ok(response);
    }
}
