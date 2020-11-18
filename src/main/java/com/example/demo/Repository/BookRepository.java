package com.example.demo.Repository;

import com.example.demo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT * FROM books", nativeQuery = true)
    Collection<Book> findAllBooks();

    @Query(value = "SELECT * FROM books WHERE id = ?1", nativeQuery = true)
    Book findBook(Integer id);

    @Query(value = "INSERT INTO books (title, author, rating) VALUES (?1, ?2, ?3) RETURNING id", nativeQuery = true)
    Integer createBook(String title, String author, Integer rating);

    @Query(value = "UPDATE books SET (title, author, rating) = (?2, ?3, ?4) WHERE id = ?1 RETURNING id", nativeQuery = true)
    Integer updateBook(Integer id, String title, String author, Integer rating);

    @Query(value = "DELETE FROM books WHERE id = ?1 RETURNING id", nativeQuery = true)
    Integer deleteBook(Integer id);
}
