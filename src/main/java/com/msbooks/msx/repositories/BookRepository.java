package com.msbooks.msx.repositories;

import java.util.List;
import java.util.Optional;

import com.msbooks.msx.models.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
    
    Optional<Book> findById(Long id);
    List<Book> findAll();
    // List<Book> findBook(Book book);
	// List<Book> findBook(Book book);
    
    // List<Book> findByBookName(String bookName);
    
    // Book findByName(String bookName);
}
