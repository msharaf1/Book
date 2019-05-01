package com.msbooks.msx.controllers;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import com.msbooks.msx.models.Book;
import com.msbooks.msx.repositories.BookRepository;
import com.msbooks.msx.services.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    private BookService bookServ;
    private BookRepository bookRepo;

    public HomeController(BookService bookServ, BookRepository bookRepo){
        this.bookRepo = bookRepo;
        this.bookServ = bookServ;
    }

    @GetMapping("/books")
    public String allBooks(Model model){
        List<Book> books = bookServ.allBooks();
        System.out.println(books.size());
        model.addAttribute("books", books);
        
        return "index";
    }

    @GetMapping("/books/{id}")
    public String showById(@PathVariable("id") Long id, Model model){
        Optional<Book> findById = bookServ.findById(id);
        model.addAttribute("bId", findById);
        
        return "index";
    }


}