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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private BookService bookServ;
    private BookRepository bookRepo;
    private AuthorRepository authRepo;
    private AuthorService authServ;

    public HomeController(BookService bookServ, BookRepository bookRepo, AuthorRepository authRepo, 
            AuthorService authServ){
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
    //     List<Book> book = bookServ.allBooks();
    //     model.addAttribute("books", book);
        
    //     return "newBook";
    // }

    @GetMapping("/books/new")
    public String newPost(Model model) {
        List<Book> bookList = bookServ.allBooks();
        model.addAttribute("bookObj", bookList);

        List<Author> authorsList = authServ.getAuthors();
        model.addAttribute("authorObj", authorsList);
        return "newBook";
    }

    @PostMapping("/books/add")
    // @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public String createBook(@RequestParam(value="bookName") String bookName
                        ,@RequestParam(value="publisher") String publisher
                        ,@RequestParam(value="location") String location
                        ,@RequestParam(value="firstName") String firstName
                        ,@RequestParam(value="lastName") String lastName
                        ,@RequestParam(value="address") String address
                        ,@RequestParam(value="email") String email
                        ,@RequestParam(value="aId") String aId

                        ) {
        
        
        Long id = Long.parseLong(aId);
        Book addBooks = new Book();
        Author addAuthor = new Author();
    
        addAuthor.setId(id);
        addAuthor.setFirstName(firstName);
        addAuthor.setLastName(lastName);
        addAuthor.setAddress(address);
        addAuthor.setEmail(email);
      
        addBooks.setAId(id);
        // addBooks.setAuthor(author); = addAuthor.getId();
        addBooks.setBookName(bookName);
        addBooks.setPublisher(publisher);
        addBooks.setLocation(location);

        // Book newBook = bookServ.createBook(addBook);

        return "redirect:/books/new";
    }

    // @RequestMapping(value="/api/books", method=RequestMethod.POST)
    // public BookModel create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
    //     BookModel addBooks = new BookModel(title, desc, lang, numOfPages);
    //     return bookService.createBook(addBooks);
    // }

    // @PostMapping("/books/new")
    // public String createBook(@Valid @ModelAttribute("book") Book book, Author author, BindingResult result){
    //     if(result.hasErrors()){
    //         return "redirect:/books/new";
    //     }else {
    //         Book newBook = bookServ.createBook(book);
    //         Author newAuthor = authServ.createAuthor(author);
            
    //         return "redirect:/books";
    //     }
        
        
    // }
    // @PostMapping("/new")
	// public String newEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
	// 	if(result.hasErrors()) {
	// 		return "dashboard.jsp";
	// 	}
	// 	long user_id = (long) session.getAttribute("user");
	// 	User host = userServ.findUserById(user_id);
	// 	event.setUser(host);
	// 	eventServ.createEvent(event);
	// 	return "redirect:/events";
	// }

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