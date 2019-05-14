package com.msbooks.msx.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import com.msbooks.msx.models.Author;
import com.msbooks.msx.models.Book;
import com.msbooks.msx.repositories.AuthorRepository;
import com.msbooks.msx.repositories.BookRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;



@Service
public class BookService {
    private BookRepository bookRepo;
    private AuthorRepository authRepo;

    public BookService(BookRepository bookRepo, AuthorRepository authRepo){
        this.bookRepo = bookRepo;
        this.authRepo = authRepo;
    }

    public List<Book> allBooks(){
        // List<Book> books = bookRepo.findAll();
        // return books;
        return bookRepo.findAll();
    }

    public Book findBookById(Long id){
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        } else {
            return null;
        }
    }

    // public Optional<Book> findById(Long id){
    //     return bookRepo.findById(id);
    // }


	public Book createBook( Book book) {
		return bookRepo.save(book);
    }
    public void deleteBook(Long id){
        bookRepo.deleteById(id);
    }

    ///edit
    // public Optional<Book> getBookById(Long bookId) {
    //     if (!bookRepo.existsById(bookId)) {
    //         // throw new ResourceNotFoundException("Book with id " + bookId + " not found");
    //         return null;
    //     }
    //     return bookRepo.findById(bookId);
    // }


    // public Book createBook(Long authorId, Book book) {
    //     Set<Book> books = new HashSet<>();
    //     Author newAuthor = new Author();
    //     Optional<Author> authById = authRepo.findById(authorId);
    //     if (!authById.isPresent()) {
    //         // throw new ResourceNotFoundException("Author with id " + authorId + " does not exist");
    //         return null;
    //     }
    //     Author author = authById.get();
    //     //tie Author to Book
    //     book.setAuthor(author);
    //     Book newBook = bookRepo.save(book);
    //     //tie Book to Author
    //     books.add(newBook);
    //     newAuthor.setBooks(books);
    //     return newBook;

    // }
}