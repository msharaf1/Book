package com.msbooks.msx.controllers;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.msbooks.msx.models.Book;
import com.msbooks.msx.repositories.BookRepository;
import com.msbooks.msx.services.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        
        return "show";
    }

    // @GetMapping("/books/{id}")
    // public String shoObj(@PathVariable("id") Long id, Model model){
    //     List<Book> books = bookServ.findById(id);
    //     model.addAttribute("bId", findById);
        
    //     return "show";
    // }

    @GetMapping("/books/new")
    public String showAllBook(Model model){
        List<Book> books = bookServ.allBooks();
        System.out.println(books.size());
        model.addAttribute("books", books);
        
        return "index";
    }

    @PostMapping("/books/new")
    public String createBook(@Valid @ModelAttribute("books") Book book, BindingResult result){
        if(result.hasErrors()){
            return "redirect:/books";
        }else {
            Book newBook = bookServ.createBook(book);
            
            return "redirect:/books";
        }
        
        
    }
}