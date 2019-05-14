package com.msbooks.msx.controllers;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.msbooks.msx.models.Author;
import com.msbooks.msx.models.Book;
import com.msbooks.msx.repositories.AuthorRepository;
import com.msbooks.msx.repositories.BookRepository;
import com.msbooks.msx.services.AuthorService;
import com.msbooks.msx.services.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {
    private BookService bookServ;
    private BookRepository bookRepo;
    private AuthorRepository authRepo;
    private AuthorService authServ;

    public HomeController(BookService bookServ, BookRepository bookRepo, AuthorRepository authRepo, 
            AuthorService authorServ){
        this.bookRepo = bookRepo;
        this.bookServ = bookServ;
        this.authRepo = authRepo;
        this.authServ = authServ;
    }

    @GetMapping("/books")
    public String allBooks(Model model){
        List<Book> booksList = bookServ.allBooks();
        model.addAttribute("books", booksList);
        
        return "index";
    }

    @GetMapping("/books/{id}")
    public String showById(@PathVariable("id") Long id, Model model){
        Book bookById = bookServ.findBookById(id);
        model.addAttribute("bookDetail", bookById);
        
        return "showBook";
    }

    // @GetMapping("/books/{id}")
    // public String shoObj(@PathVariable("id") Long id, Model model){
    //     List<Book> books = bookServ.findById(id);
    //     model.addAttribute("bId", findById);
        
    //     return "show";
    // }

    // @GetMapping("/books/new")
    // public String showAllBook(Model model){
    //     List<Book> books = bookServ.allBooks();
        
    //     model.addAttribute("books", books);
        
    //     return "newBook";
    // }

    @GetMapping("/books/new")
    public String newPost(@ModelAttribute("book") Book book) {
        return "newBook";
    }

    @PostMapping("/books/new")
    public String createBook(@Valid @ModelAttribute("book") Book book, Author author, BindingResult result){
        if(result.hasErrors()){
            return "redirect:/books/new";
        }else {
            Book newBook = bookServ.createBook(book);
            Author newAuthor = authServ.createAuthor(author);
            
            return "redirect:/books";
        }
        
        
    }

    // @PostMapping("/new")
    // public String createIdea(@ModelAttribute("idea") Idea idea, BindingResult result, HttpSession session, Model model){
	// 	if (idea.getContent().length() < 1) {
    // 		model.addAttribute("errors", "Must include content");
    // 		model.addAttribute("idea", new Idea());
    // 		System.out.println("1");
    //         return "create"; 
    // 	} else {
    // 		Long user_id = (Long)session.getAttribute("id"); 
    //     	User creator =  uS.findById(user_id);
    // 		idea.setCreator(creator);
    // 		iS.create(idea);
    // 		return "redirect:/ideas";
    // 	}
    // }

        //Book
        // @PostMapping(value = "/book/{authorId}")
        // public Book createBook(@PathVariable(value = "authorId") Long authorId, @RequestBody Book book) {
        //     return bookServ.createBook(authorId, book);
        // }
    
        // @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
        // public Optional<Book> getBookById(@PathVariable(value = "bookId") Long bookId) {
        //     return bookService.getBookById(bookId);
        // }
}