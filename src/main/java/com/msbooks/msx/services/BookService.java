package com.msbooks.msx.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.msbooks.msx.models.Book;
import com.msbooks.msx.repositories.BookRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;



@Service
public class BookService {
    private BookRepository bookRepo;

    public BookService(BookRepository bookRepo){
        this.bookRepo = bookRepo;
    }

    public List<Book> allBooks(){
        List<Book> books = bookRepo.findAll();
        return books;
    }

    public Optional<Book> findById(Long id){
        return bookRepo.findById(id);
    }
    // public Book findBook(Book book){
    //     return bookRepo.findBook(book);
    // }

	public Book createBook( Book book) {
		return bookRepo.save(book);
	}
}